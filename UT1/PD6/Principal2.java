/*
Parte b)
Haz un programa similar al de la parte anterior que devuelva el área y perímetro de una
circunferencia a parGr del radio de la misma.
Los parámetros se deberán leer de stdin.
Creando un método está/co llamado “leerEntradaStdin” en la clase “Principal” del
programa. La firma de este método será:
public sta/c void leerEntradaStdin();"
 */

import java.util.Scanner;

public class Principal2 {
    public static void main(String[] args) {
        leerEntradaStdin(); // llamamos al método para leer desde la entrada estándar
    }

    // método para leer desde stdin
    public static void leerEntradaStdin() {
        Scanner scanner = new Scanner(System.in); // creamos un scanner para leer la entrada
        System.out.print("el radio de la circunferencia: "); // pedimos el radio

        double radio = scanner.nextDouble(); // leemos el radio

        // calculamos el área y el perímetro
        double area = Math.PI * Math.pow(radio, 2); // área de la circunferencia
        double perimetro = 2 * Math.PI * radio; // perímetro de la circunferencia

        // mostramos los resultados
        System.out.println("área de la circunferencia es: " + area);
        System.out.println("perímetro de la circunferencia es: " + perimetro);

        scanner.close(); // cerramos el scanner
    }
}
