public class Tablero {
    public static void main(String[] args) {
        int largo = 7;
        int ancho = 7;
        imprimirTablero(largo, ancho); // llama al método para imprimir el tablero
    }

    // método estático para imprimir el tablero
    public static void imprimirTablero(int largo, int ancho) {
        // bucle para las filas
        for (int i = 0; i < largo; i++) {
            // bucle para las columnas
            for (int j = 0; j < ancho; j++) {
                // imprimir '#' seguido de un espacio
                System.out.print("# ");
            }
            // imprimir un salto de línea después de cada fila
            System.out.println();
        }
    }
}
