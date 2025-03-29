/*
Indicar el error al ejecutar el método “recorrer” y corregirlo. ¿cómo lo detectaste?
Después, en el método recorrer, vi que el bucle empezaba en 1, lo que hacía que fallara al intentar acceder al primer carácter. Le cambié el índice para que empezara en 0.
 */

public class metodosNoAlumno {
    public static int recorrer(String cadena) {
        int res = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) != ' ') {
                res++;
            }
        }
        return res;
    }

    /*
    Indicar el error al ejecutar el método “getValor” y corregirlo. ¿cómo lo detectaste?
    En getValor, noté que estaba intentando acceder al índice 8 de un arreglo que solo llega hasta el 7, así que cambié el índice a 7.
     */

    public static int getValor() {
        int vector[] = {6, 16, 26, 36, 46, 56, 66, 76};
        int idx = 7; // Cambiado de 8 a 7
        return vector[idx];
    }
/*
Indicar el error al ejecutar el método “getPrimerCaracter” y corregirlo. ¿cómo lo detectaste?
el método intentaba acceder a un índice de un arreglo de String que no estaba inicializado y no usaba el parámetro palabra. lo ajusté para que devolviera el primer caracter de la palabra y añadí una verificación para asegurarme de que tuviera longitud.
 */

    public static char getPrimerCaracter(String palabra) {
        if (palabra.length() > 1) {
            return palabra.charAt(0); // cambiado para usar la palabra dada
        }
        return '\0'; // retorna un caracter nulo si la palabra es muy corta
    }

    /*
Indicar el error al ejecutar el método “paraAString” y corregirlo. ¿cómo lo detectaste?
vi que intentaba convertir un objeto Integer a String de forma incorrecta. Lo solucioné usando String.valueOf(a) para hacerlo bien.
*/
    public static String paraAString(int a) {
        return String.valueOf(a); // se usa String.valueOf para convertir
    }
}
