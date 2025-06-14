import java.util.Collection;
import java.util.Map;

public abstract class TGrafo {
    protected Map<Comparable, TVertice> vertices;

    public TGrafo(Collection<TVertice> vertices, Collection<TArista> aristas) {
        // Inicializa el mapa de vértices
        this.vertices = new java.util.TreeMap<>();
        for (TVertice v : vertices) {
            this.vertices.put(v.getEtiqueta(), v);
        }
        // Las aristas se insertan en las subclases según el tipo de grafo
    }

    public Map<Comparable, TVertice> getVertices() {
        return vertices;
    }

    public abstract boolean insertarArista(TArista arista);
    public abstract boolean eliminarArista(Comparable origen, Comparable destino);

    public void mostrarMatrizAdyacencia() {
        Object[] etiquetas = vertices.keySet().toArray();
        int n = etiquetas.length;
        int[][] matriz = new int[n][n];

        for (int i = 0; i < n; i++) {
            TVertice vOrigen = vertices.get(etiquetas[i]);
            for (int j = 0; j < n; j++) {
                TVertice vDestino = vertices.get(etiquetas[j]);
                matriz[i][j] = vOrigen.tieneAdyacente(vDestino.getEtiqueta()) ? 1 : 0;
            }
        }

        // Imprimir matriz
        System.out.print("    ");
        for (Object etiqueta : etiquetas) {
            System.out.print(etiqueta + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(etiquetas[i] + " | ");
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void desvisitarVertices() {
        for (TVertice v : getVertices().values()) {
            v.setVisitado(false);
        }
    }
}
