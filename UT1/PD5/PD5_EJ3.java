
/*
Revisar el tutorial de ORACLE en http://docs.oracle.com/javase/tutorial/java/data/strings.html
Analizar el ejercicio sobre “palíndromo”
. Introducir el código fuente en NetBeans y probarlo
con diferentes frases. Ver qué sucede al tener letras en mayúsculas y minúsculas, y algunos
símbolos de puntuación como “
”
“
.
,
,
” y “;”
.
 */
public class PD5_EJ3 {
//codigo de palindromo
    public static void main(String[] args) {
        String palindrome = "Dot saw; I, was Tod."; // agregar coma y punto
        // como el codigo crea un array temporal para almacenar los char y luego va iterando sobre cada char insertando en el nuevo array, los puntos y las comas son agregados de la misma forma que los caracteres, en orden inverso, por lo tanot, la salida esta ordenada completamente a la inversa.
        int len = palindrome.length();
        char[] tempCharArray = new char[len];
        char[] charArray = new char[len];

        // put original string in an
        // array of chars
        for (int i = 0; i < len; i++) {
            tempCharArray[i] =
                    palindrome.charAt(i);
        }

        // reverse array of chars
        for (int j = 0; j < len; j++) {
            charArray[j] =
                    tempCharArray[len - 1 - j];
        }

        String reversePalindrome =
                new String(charArray);
        System.out.println(reversePalindrome);
    }
}
