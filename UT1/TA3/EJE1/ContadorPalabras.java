import java.util.HashSet;
import java.util.Set;

public class ContadorPalabras {
    // método que cuenta cuántas veces aparece la letra 'a' en una palabra
    public int contador(String palabra) {
        int contador = 0; // variable para contar la cantidad de veces que aparece 'a'

        // recorremos toda la palabra letra por letra
        for (int i = 0; i < palabra.length(); i++) {
            // si encontramos la letra 'a', aumentamos el contador
            if (palabra.charAt(i) == 'a') {
                contador++;
            }
        }

        return contador; // devolvemos el número de veces que apareció 'a'
    }

    // método que encuentra las palabras comunes en dos arreglos
    public String[] palabrasComunes(String[] palabras1, String[] palabras2) {
        Set<String> set1 = new HashSet<>(); // creamos un conjunto para almacenar las palabras del primer arreglo
        Set<String> comunes = new HashSet<>(); // creamos otro conjunto para almacenar las palabras comunes

        // agregamos todas las palabras del primer arreglo al conjunto
        for (String palabra : palabras1) {
            set1.add(palabra);
        }

        // recorremos el segundo arreglo y verificamos si la palabra está en el primer conjunto
        for (String palabra : palabras2) {
            if (set1.contains(palabra)) { // si la palabra está en ambos, la agregamos al conjunto de palabras comunes
                comunes.add(palabra);
            }
        }

        // convertimos el conjunto de palabras comunes a un array y lo devolvemos
        return comunes.toArray(new String[0]);
    }
}

