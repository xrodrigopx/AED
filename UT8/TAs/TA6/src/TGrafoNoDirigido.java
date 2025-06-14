import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido {

    protected TAristas lasAristas = new TAristas();

    /**
     *
     * @param vertices
     * @param aristas
     */
    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
        lasAristas.insertarAmbosSentidos(aristas);

    }

    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        TArista arInv = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
        tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));
        return tempbool;
    }

    public TAristas getLasAristas() {
        return lasAristas;
    }

    @Override
    public TGrafoNoDirigido Prim() {
        // sacamos todos los vertices y chequeamos que haya alguno
        LinkedList<TVertice> vertices = new LinkedList<>(this.getVertices().values());
        int n = vertices.size();
        if (n == 0) return null; // si no hay vertices, no hay MST

        // aca vamos guardando las aristas del MST y los vertices ya visitados
        LinkedList<TArista> mstAristas = new LinkedList<>();
        java.util.HashSet<Comparable> visitados = new java.util.HashSet<>();
        java.util.PriorityQueue<TArista> pq = new java.util.PriorityQueue<>(); // heap para elegir la arista mas barata

        // arrancamos desde el primer vertice que encontremos
        TVertice inicial = vertices.getFirst();
        visitados.add(inicial.getEtiqueta());

        // metemos al heap todas las aristas que salen del inicial
        for (TArista arista : this.getLasAristas()) {
            if (arista.getEtiquetaOrigen().equals(inicial.getEtiqueta()) ||
                arista.getEtiquetaDestino().equals(inicial.getEtiqueta())) {
                pq.add(arista);
            }
        }

        // mientras falten aristas para el MST y haya opciones en el heap
        while (!pq.isEmpty() && mstAristas.size() < n - 1) {
            TArista arista = pq.poll();
            Comparable u = arista.getEtiquetaOrigen();
            Comparable v = arista.getEtiquetaDestino();

            // buscamos el vertice nuevo (el que todavia no esta en el MST)
            Comparable nuevo = null;
            if (visitados.contains(u) && !visitados.contains(v)) {
                nuevo = v;
            } else if (visitados.contains(v) && !visitados.contains(u)) {
                nuevo = u;
            } else {
                continue; // si ambos ya estan o ninguno, seguimos
            }

            // sumamos la arista al MST y marcamos el vertice como visitado
            mstAristas.add(arista);
            visitados.add(nuevo);

            // metemos al heap las aristas que salen del nuevo vertice y van a uno no visitado
            for (TArista a : this.getLasAristas()) {
                if ((a.getEtiquetaOrigen().equals(nuevo) && !visitados.contains(a.getEtiquetaDestino())) ||
                    (a.getEtiquetaDestino().equals(nuevo) && !visitados.contains(a.getEtiquetaOrigen()))) {
                    pq.add(a);
                }
            }
        }

        // si no se pudo conectar todo, el grafo no es conexo
        if (mstAristas.size() != n - 1) {
            return null;
        }
        // devolvemos el MST como un nuevo grafo
        return new TGrafoNoDirigido(vertices, mstAristas);
    }

    @Override
    public TGrafoNoDirigido Kruskal() {
        // aca armamos una lista con solo una direccion de cada arista (para no repetir)
        LinkedList<TArista> aristas = new LinkedList<>();
        for (TArista arista : this.getLasAristas()) {
            // solo agregamos si origen < destino (asi evitamos duplicados)
            if (arista.getEtiquetaOrigen().toString().compareTo(arista.getEtiquetaDestino().toString()) < 0) {
                aristas.add(arista);
            }
        }
        // ordenamos las aristas por costo, asi Kruskal siempre agarra la mas barata
        Collections.sort(aristas);

        LinkedList<TVertice> vertices = new LinkedList<>(this.getVertices().values());
        int n = vertices.size();
        if (n == 0) return null; // si no hay vertices, no hay MST

        // mapeamos cada vertice a un indice para usar Union-Find
        java.util.HashMap<Comparable, Integer> etiquetaAIndice = new java.util.HashMap<>();
        int idx = 0;
        for (TVertice v : vertices) {
            etiquetaAIndice.put(v.getEtiqueta(), idx++);
        }

        // Union-Find para chequear ciclos y unir componentes
        UnionFind uf = new UnionFind(n);
        LinkedList<TArista> mstAristas = new LinkedList<>();
        for (TArista arista : aristas) {
            int u = etiquetaAIndice.get(arista.getEtiquetaOrigen());
            int v = etiquetaAIndice.get(arista.getEtiquetaDestino());
            // si no forman ciclo, la sumamos al MST
            if (uf.find(u) != uf.find(v)) {
                mstAristas.add(arista);
                uf.union(u, v);
                if (mstAristas.size() == n - 1) break; // ya tenemos el MST completo
            }
        }

        // si no se pudo conectar todo, el grafo no es conexo
        if (mstAristas.size() != n - 1) {
            return null;
        }
        // devolvemos el MST como un nuevo grafo
        return new TGrafoNoDirigido(vertices, mstAristas);
    }

    // Union-Find para Kruskal, bien basico pero funciona
    private static class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // compresion de caminos
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot == yRoot) return;
            if (rank[xRoot] < rank[yRoot]) {
                parent[xRoot] = yRoot;
            } else if (rank[xRoot] > rank[yRoot]) {
                parent[yRoot] = xRoot;
            } else {
                parent[yRoot] = xRoot;
                rank[xRoot]++;
            }
        }
    }

    @Override
    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
