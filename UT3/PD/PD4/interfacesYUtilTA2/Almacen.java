import java.util.ArrayList;

public class Almacen implements IAlmacen {

    private String direccion;
    private String telefono;
    private String nombre;
    private Lista<IProducto> listaProductos;

    public Almacen(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.listaProductos = new Lista<>();
    }

    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String getTelefono() {
        return telefono;
    }

    @Override
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public Lista getListaProductos() {
        return listaProductos;
    }

    @Override
    public void insertarProducto(Producto unProducto) {
        Nodo<IProducto> nodoEncontrado = listaProductos.buscar(unProducto.getEtiqueta());
        if (nodoEncontrado != null) {
            // Si existe, actualizo el stock sumando
            IProducto prodExistente = nodoEncontrado.getDato();
            prodExistente.setStock(prodExistente.getStock() + unProducto.getStock());
        } else {
            listaProductos.insertar(unProducto.getEtiqueta(), unProducto);
        }
    }

    @Override
    public boolean eliminar(Comparable clave) {
        return listaProductos.eliminar(clave);
    }

    @Override
    public String imprimirProductos() {
        Nodo<IProducto> actual = listaProductos.getPrimero();
        StringBuilder sb = new StringBuilder();
        while (actual != null) {
            sb.append(actual.getDato().toString()).append("\n");
            actual = actual.getSiguiente();
        }
        return sb.toString();
    }

    @Override
    public String imprimirSeparador(String separador) {
        Nodo<IProducto> actual = listaProductos.getPrimero();
        StringBuilder sb = new StringBuilder();
        while (actual != null) {
            sb.append(actual.getDato().getNombre());
            if (actual.getSiguiente() != null) {
                sb.append(separador);
            }
            actual = actual.getSiguiente();
        }
        return sb.toString();
    }

    @Override
    public Boolean agregarStock(Comparable clave, Integer cantidad) {
        Nodo<IProducto> nodo = listaProductos.buscar(clave);
        if (nodo != null) {
            IProducto prod = nodo.getDato();
            prod.setStock(prod.getStock() + cantidad);
            return true;
        }
        return false;
    }

    @Override
    public Integer restarStock(Comparable clave, Integer cantidad) {
        Nodo<IProducto> nodo = listaProductos.buscar(clave);
        if (nodo != null) {
            IProducto prod = nodo.getDato();
            int stockActual = prod.getStock();
            int cantidadARestar = Math.min(stockActual, cantidad);
            prod.setStock(stockActual - cantidadARestar);
            return cantidadARestar;
        }
        return 0;
    }

    @Override
    public Producto buscarPorCodigo(Comparable clave) {
        Nodo<IProducto> nodo = listaProductos.buscar(clave);
        if (nodo != null) {
            return (Producto) nodo.getDato();
        }
        return null;
    }

    @Override
    public void listarOrdenadoPorNombre() {
        // Para listar ordenado, una forma simple es: pasar a ArrayList, ordenar y mostrar
        ArrayList<Producto> productos = new ArrayList<>();
        Nodo<IProducto> actual = listaProductos.getPrimero();
        while (actual != null) {
            productos.add((Producto) actual.getDato());
            actual = actual.getSiguiente();
        }
        productos.sort((p1, p2) -> p1.getNombre().compareToIgnoreCase(p2.getNombre()));
        for (Producto p : productos) {
            System.out.println(p.getNombre() + " - Stock: " + p.getStock());
        }
    }

    @Override
    public Producto buscarPorDescripcion(String descripcion) {
        Nodo<IProducto> actual = listaProductos.getPrimero();
        while (actual != null) {
            if (actual.getDato().getNombre().equalsIgnoreCase(descripcion)) {
                return (Producto) actual.getDato();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    @Override
    public int cantidadProductos() {
        return listaProductos.cantElementos();
    }
}

