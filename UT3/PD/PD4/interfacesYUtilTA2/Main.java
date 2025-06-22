public class Main {
    public static void main(String[] args) {

        IAlmacen almacen = new Almacen("G.E.AN.T", "Av. Principal 123", "099123456");
        GestionAlmacen gestion = new GestionAlmacen(almacen);

        int gastoAltas = gestion.procesarAltas("altas.txt");
        System.out.println("Monto total gastado en compras: " + gastoAltas);

        int montoVentas = gestion.procesarVentas("ventas.txt");
        System.out.println("Monto total vendido: " + montoVentas);

        System.out.println("Listado productos:");
        System.out.println(almacen.imprimirProductos());
    }
}
