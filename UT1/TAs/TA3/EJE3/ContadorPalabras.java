import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class ContadorPalabras {

    public String[] obtenerLineas(String archivo) {
        try {
            List<String> lineas = Files.readAllLines(Paths.get(archivo));
            System.out.println("Cantidad de líneas leídas: " + lineas.size());
            return lineas.toArray(new String[0]);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return new String[0];
        }
    }

    public int cantPalabras(String[] lineasArchivo) {
        int totalPalabras = 0;
        for (String linea : lineasArchivo) {
            if (!linea.trim().isEmpty()) {
                String[] palabras = linea.trim().split("\\s+");
                totalPalabras += palabras.length;
            }
        }
        return totalPalabras;
    }

    public int contador(String palabra) {
        int contador = 0;
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == 'a') {
                contador++;
            }
        }
        return contador;
    }

    public String[] palabrasComunes(String[] palabras1, String[] palabras2) {
        Set<String> set1 = new HashSet<>();
        Set<String> comunes = new HashSet<>();
        for (String palabra : palabras1) {
            set1.add(palabra);
        }
        for (String palabra : palabras2) {
            if (set1.contains(palabra)) {
                comunes.add(palabra);
            }
        }
        return comunes.toArray(new String[0]);
    }
}
