/*
1) Verificar que funciona correctamente e indicar cuál es la salida cuando se invoca con
parámetros 13.4 y 66.1
2) ¿cómo debería modificarse el código si los parámetros de línea de comando fueran
solamente enteros positivos?

si quisiera realizar esa comprobacion, hay que cambiar el tipo de datos a int:

            int a = (Float.valueOf(args[0])).floatValue();
            int b = (Float.valueOf(args[1])).floatValue();

Y luego hay que envolver las operaciones en un if para comprobar que sean positivos.

            if (a > 0 && b > 0) {
                // hacer algunas operaciones aritméticas
                System.out.println("a + b = " + (a + b));
                System.out.println("a - b = " + (a - b));
                System.out.println("a * b = " + (a * b));
                System.out.println("a / b = " + (a / b));
                System.out.println("a % b = " + (a % b));
            }
 */

public class ValueOfDemo {
    public static void main(String[] args) {

        // this program requires two
        // arguments on the command line
        if (args.length == 2) {
            // convert strings to numbers

            float a = (Float.valueOf(args[0])).floatValue();
            float b = (Float.valueOf(args[1])).floatValue();


            // do some arithmetic
            // aca borre algunos espacios innecesarios par que se entienda mejor
            System.out.println("a + b = " + (a + b));
            System.out.println("a - b = " + (a - b));
            System.out.println("a * b = " + (a * b));
            System.out.println("a / b = " + (a / b));
            System.out.println("a % b = " + (a % b));
        } else {
            // arreglo el concat innecesario
            System.out.println("This program requires two command-line arguments.");
        }
    }
}