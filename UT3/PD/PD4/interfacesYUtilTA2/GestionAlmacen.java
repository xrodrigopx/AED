public class GestionAlmacen {

    private IAlmacen almacen;

    public GestionAlmacen(IAlmacen almacen) {
        this.almacen = almacen;
    }

    public int procesarAltas(String archivoAltas) {
        int montoTotal = 0;
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(archivoAltas);

        for (String linea : lineas) {
            String[] campos = linea.split(",");
            if (campos.length < 4) continue;

            String codigo = campos[0].trim();
            String nombre = campos[1].trim();
            int precio = Integer.parseInt(campos[2].trim());
            int cantidad = Integer.parseInt(campos[3].trim());

            Producto nuevoProd = new Producto(codigo, nombre, precio, cantidad);

            Nodo<IProducto> nodoExistente = almacen.getListaProductos().buscar(codigo);

            if (nodoExistente != null) {
                // Producto existe, actualizar stock y precio si se quiere (aquí solo sumamos stock)
                IProducto prodExistente = nodoExistente.getDato();
                prodExistente.setStock(prodExistente.getStock() + cantidad);
            } else {
                almacen.insertarProducto(nuevoProd);
            }
            montoTotal += precio * cantidad;
        }
        return montoTotal;
    }

    public int procesarVentas(String archivoVentas) {
        int montoTotal = 0;
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(archivoVentas);

        for (String linea : lineas) {
            String[] campos = linea.split(",");
            if (campos.length < 2) continue;

            String codigo = campos[0].trim();
            int cantidadVenta = Integer.parseInt(campos[1].trim());

            Nodo<IProducto> nodo = almacen.getListaProductos().buscar(codigo);
            if (nodo != null) {
                IProducto prod = nodo.getDato();
                int stockActual = prod.getStock();
                int cantidadVendida = Math.min(cantidadVenta, stockActual);
                prod.setStock(stockActual - cantidadVendida);
                montoTotal += cantidadVendida * prod.getPrecio();
            }
        }
        return montoTotal;
    }
}
