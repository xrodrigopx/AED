import java.util.Scanner;

public class MultiplicacionVectores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // pedimos el tamaño del vector
        System.out.print("tamaño del vector: ");
        int tamañoVector = scanner.nextInt();

        // pedimos las dimensiones de la matriz
        System.out.print("número de filas de la matriz: ");
        int filasMatriz = scanner.nextInt();

        System.out.print("número de columnas de la matriz: ");
        int columnasMatriz = scanner.nextInt();

        // checamos si se puede multiplicar
        if (tamañoVector != columnasMatriz) {
            System.out.println("el tamaño del vector debe ser igual al número de columnas de la matriz");
            return; // salimos si no se puede
        }

        // creamos el vector
        int[] vector = new int[tamañoVector];
        System.out.println("elementos del vector:");
        for (int i = 0; i < tamañoVector; i++) {
            vector[i] = scanner.nextInt(); // llenamos el vector
        }

        // creamos la matriz
        int[][] matriz = new int[filasMatriz][columnasMatriz];
        System.out.println("elementos de la matriz:");
        for (int i = 0; i < filasMatriz; i++) {
            for (int j = 0; j < columnasMatriz; j++) {
                matriz[i][j] = scanner.nextInt(); // llenamos la matriz
            }
        }

        // hacemos la multiplicación
        int[] resultado = multiplicar(vector, matriz);

        // mostramos el resultado
        System.out.println("el resultado es:");
        for (int val : resultado) {
            System.out.print(val + " "); // imprimimos cada valor del resultado
        }
    }

    // método para multiplicar el vector por la matriz
    public static int[] multiplicar(int[] vector, int[][] matriz) {
        int[] resultado = new int[matriz.length]; // nuevo vector para el resultado

        for (int i = 0; i < matriz.length; i++) {
            int suma = 0; // inicializamos la suma
            for (int j = 0; j < matriz[i].length; j++) {
                suma += vector[j] * matriz[i][j]; // multiplicamos y sumamos
            }
            resultado[i] = suma; // guardamos el resultado
        }

        return resultado; // regresamos el vector resultado
    }
}
