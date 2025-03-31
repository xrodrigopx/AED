import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Principal4 {
    public static void main(String[] args) {
        String rutaArchivo = "/Users/rperdomo/IdeaProjects/UT1/PD6/entrada3.txt"; // ruta del archivo de entrada
        transformarT9Texto(rutaArchivo); // llamamos al método para transformar el texto
    }

    // método para invertir el texto y transformarlo a dígitos T9
    public static void transformarT9Texto(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            FileWriter writer = new FileWriter("/Users/rperdomo/IdeaProjects/UT1/PD6/salida2.txt"); // archivo de salida

            String linea;
            while ((linea = br.readLine()) != null) {
                StringBuilder resultado = new StringBuilder(linea).reverse(); // invertimos la línea
                StringBuilder t9Resultado = new StringBuilder();
                for (char c : resultado.toString().toCharArray()) {
                    t9Resultado.append(transformarCaracter(c)); // transformamos a dígitos T9
                }
                writer.write(t9Resultado.toString() + "\n"); // escribimos en el archivo
            }
            writer.close(); // cerramos el escritor
        } catch (IOException e) {
            System.out.println("no se puede leer o escribir el archivo: " + e.getMessage());
        }
    }

    // método para convertir un carácter a su correspondiente en T9
    private static String transformarCaracter(char c) {
        if (Character.isLetter(c)) {
            c = Character.toUpperCase(c); // convertimos a mayúscula
            switch (c) {
                case 'A': case 'B': case 'C': return "2";
                case 'D': case 'E': case 'F': return "3";
                case 'G': case 'H': case 'I': return "4";
                case 'J': case 'K': case 'L': return "5";
                case 'M': case 'N': case 'O': return "6";
                case 'P': case 'Q': case 'R': case 'S': return "7";
                case 'T': case 'U': case 'V': return "8";
                case 'W': case 'X': case 'Y': case 'Z': return "9";
            }
        } else if (c == ' ') {
            return "0"; // espacio
        } else if (c == '.' || c == '!') {
            return "1"; // punto o exclamación
        }
        return ""; // si no es un carácter válido
    }
}
