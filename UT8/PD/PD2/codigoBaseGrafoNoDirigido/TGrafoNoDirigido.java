import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;

public class TGrafoNoDirigido extends TGrafo implements IGrafoNoDirigido, List<TArista> {

    protected TAristas lasAristas = new TAristas();

    /**
     *
     * @param vertices
     * @param aristas
     */
    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
        if (aristas != null) {
            for (TArista arista : aristas) {
                this.insertarArista(arista);
            }
        }
        lasAristas.insertarAmbosSentidos(aristas);

    }

    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        TArista arInv = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
        tempbool = (insertarAristaSimple(arista) && insertarAristaSimple(arInv));
        return tempbool;
    }

    private boolean insertarAristaSimple(TArista arista) {
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
            TVertice vertOrigen = getVertices().get(arista.getEtiquetaOrigen());
            TVertice vertDestino = getVertices().get(arista.getEtiquetaDestino());
            if ((vertOrigen != null) && (vertDestino != null)) {
                return vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
            }
        }
        return false;
    }

    public TAristas getLasAristas() {
        return lasAristas;
    }

    @Override
    public TGrafoNoDirigido Prim() {
        Set<Comparable> visitados = new HashSet<>();
        List<TArista> mst = new ArrayList<>();
        PriorityQueue<TArista> cola = new PriorityQueue<>();

        // Selecciona un vértice inicial arbitrario
        TVertice inicial = this.getVertices().values().iterator().next();
        visitados.add(inicial.getEtiqueta());

        // Agrega todas las aristas del vértice inicial a la cola
        for (TArista arista : this.getLasAristas()) {
            if (arista.getEtiquetaOrigen().equals(inicial.getEtiqueta()) || arista.getEtiquetaDestino().equals(inicial.getEtiqueta())) {
                cola.add(arista);
            }
        }

        while (visitados.size() < this.getVertices().size() && !cola.isEmpty()) {
            TArista menor = cola.poll();
            Comparable nuevo = null;

            if (visitados.contains(menor.getEtiquetaOrigen()) && !visitados.contains(menor.getEtiquetaDestino())) {
                nuevo = menor.getEtiquetaDestino();
            } else if (visitados.contains(menor.getEtiquetaDestino()) && !visitados.contains(menor.getEtiquetaOrigen())) {
                nuevo = menor.getEtiquetaOrigen();
            }

            if (nuevo != null) {
                mst.add(menor);
                visitados.add(nuevo);

                // Agrega las aristas del nuevo vértice a la cola
                for (TArista arista : this.getLasAristas()) {
                    if ((arista.getEtiquetaOrigen().equals(nuevo) && !visitados.contains(arista.getEtiquetaDestino())) ||
                        (arista.getEtiquetaDestino().equals(nuevo) && !visitados.contains(arista.getEtiquetaOrigen()))) {
                        cola.add(arista);
                    }
                }
            }
        }
        return new TGrafoNoDirigido(this.getVertices().values(), mst);
    }

    @Override
    public TGrafoNoDirigido Kruskal() {
        List<TArista> aristas = this.getLasAristas(); // Método que retorna todas las aristas del grafo
        Collections.sort(aristas); // Asegúrate que TArista implemente Comparable por peso

        Map<Comparable, Comparable> parent = new HashMap<>();
        for (TVertice v : this.getVertices().values()) {
            parent.put(v.getEtiqueta(), v.getEtiqueta());
        }

        List<TArista> mst = new ArrayList<>();

        for (TArista arista : aristas) {
            Comparable u = find(parent, arista.getEtiquetaOrigen());
            Comparable v = find(parent, arista.getEtiquetaDestino());
            if (!u.equals(v)) {
                mst.add(arista);
                union(parent, u, v);
            }
        }
        // Crear un nuevo grafo no dirigido con los mismos vértices y las aristas del MST
        return new TGrafoNoDirigido(this.getVertices().values(), mst);
    }

    private Comparable find(Map<Comparable, Comparable> parent, Comparable i) {
        if (!parent.get(i).equals(i)) {
            parent.put(i, find(parent, parent.get(i)));
        }
        return parent.get(i);
    }

    private void union(Map<Comparable, Comparable> parent, Comparable x, Comparable y) {
        parent.put(find(parent, x), find(parent, y));
    }

    @Override
    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	 
    @Override
    public LinkedList puntosArticulacion(Comparable etOrigen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
	@Override
    public boolean esConexo(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<TVertice> bea() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bea'");
    }

    @Override
    public boolean eliminarArista(Comparable origen, Comparable destino) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarArista'");
    }

    public Collection<TVertice> bpf() {
        desvisitarVertices();
        LinkedList<TVertice> visitados = new LinkedList<>();
        for (TVertice v : vertices.values()) {
            if (!v.getVisitado()) {
                v.bpf(visitados);
            }
        }
        return visitados;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public boolean contains(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }

    @Override
    public Iterator<TArista> iterator() {
        return lasAristas.iterator();
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    @Override
    public boolean add(TArista e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public boolean remove(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'containsAll'");
    }

    @Override
    public boolean addAll(Collection<? extends TArista> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }

    @Override
    public boolean addAll(int index, Collection<? extends TArista> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeAll'");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retainAll'");
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    @Override
    public TArista get(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public TArista set(int index, TArista element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public void add(int index, TArista element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public TArista remove(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public int indexOf(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'indexOf'");
    }

    @Override
    public int lastIndexOf(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lastIndexOf'");
    }

    @Override
    public ListIterator<TArista> listIterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public ListIterator<TArista> listIterator(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public List<TArista> subList(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subList'");
    }


}
