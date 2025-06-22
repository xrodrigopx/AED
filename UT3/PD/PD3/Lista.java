public class Lista<T> implements ILista<T> {

    private Nodo<T> primero;

    @Override
    public void insertar(Nodo<T> nodo) {
        if (primero == null) {
            primero = nodo;
        } else {
            Nodo<T> actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nodo);
        }
    }

    @Override
    public void insertar(Comparable etiqueta, T dato) {
        Nodo<T> nuevo = new Nodo<>(etiqueta, dato);
        insertar(nuevo);
    }

    @Override
    public Nodo<T> buscar(Comparable clave) {
        Nodo<T> actual = primero;
        while (actual != null) {
            if (actual.getEtiqueta().compareTo(clave) == 0) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (primero == null) {
            return false;
        }

        if (primero.getEtiqueta().compareTo(clave) == 0) {
            primero = primero.getSiguiente();
            return true;
        }

        Nodo<T> anterior = primero;
        Nodo<T> actual = primero.getSiguiente();

        while (actual != null) {
            if (actual.getEtiqueta().compareTo(clave) == 0) {
                anterior.setSiguiente(actual.getSiguiente());
                return true;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }

        return false;
    }

    @Override
    public String imprimir() {
        return imprimir(" -> ");
    }

    @Override
    public String imprimir(String separador) {
        StringBuilder resultado = new StringBuilder();
        Nodo<T> actual = primero;

        while (actual != null) {
            resultado.append(actual.getEtiqueta());
            if (actual.getSiguiente() != null) {
                resultado.append(separador);
            }
            actual = actual.getSiguiente();
        }

        return resultado.toString();
    }

    @Override
    public int cantElementos() {
        int contador = 0;
        Nodo<T> actual = primero;
        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }

    @Override
    public void setPrimero(Nodo<T> unNodo) {
        this.primero = unNodo;
    }
}
