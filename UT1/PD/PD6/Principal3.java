import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Principal3 {
    public static void main(String[] args) {
        String rutaArchivo = "/Users/rperdomo/IdeaProjects/UT1/PD6/entrada2.txt"; // ruta del archivo de entrada
        transformarTextoT9(rutaArchivo); // llamamos al método para transformar el texto
    }

    // método para transformar el texto a dígitos T9
    public static void transformarTextoT9(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            FileWriter writer = new FileWriter("/Users/rperdomo/IdeaProjects/UT1/PD6/salida.txt"); // archivo de salida

            String linea;
            while ((linea = br.readLine()) != null) {
                StringBuilder resultado = new StringBuilder();
                for (char c : linea.toCharArray()) {
                    resultado.append(transformarCaracter(c)); // transformamos cada carácter
                }
                writer.write(resultado.toString() + "\n"); // escribimos la línea transformada en el archivo
            }
            writer.close(); // cerramos el escritor
        } catch (IOException e) {
            System.out.println("no se puede leer o escribir el archivo: " + e.getMessage());
        }
    }

    // método para convertir un caracter a su correspondiente en T9
    private static String transformarCaracter(char c) {
        if (Character.isLetter(c)) {
            c = Character.toUpperCase(c); // convertimos a mayúscula para simplificar
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
