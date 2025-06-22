public class Main {
    public static void main(String[] args) {
        ILista<String> lista = new Lista<>();

        lista.insertar("A", "Alumno A");
        lista.insertar("B", "Alumno B");
        lista.insertar("C", "Alumno C");

        System.out.println("Listado:");
        System.out.println(lista.imprimir());

        System.out.println("Cantidad de elementos: " + lista.cantElementos());

        System.out.println("Buscar clave 'B':");
        Nodo<String> encontrado = lista.buscar("B");
        if (encontrado != null) {
            encontrado.imprimir();
        } else {
            System.out.println("No encontrado");
        }

        System.out.println("Eliminar 'B': " + (lista.eliminar("B") ? "Eliminado" : "No encontrado"));
        System.out.println("Listado actualizado:");
        System.out.println(lista.imprimir());
    }
}
