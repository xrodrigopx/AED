import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class TGrafoNoDirigido extends TGrafo implements IGrafoNoDirigido {

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TGrafoNoDirigido Kruskal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
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
}
