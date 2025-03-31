/*
Parte a)
Escribe un programa que lea de un archivo !entrada.txt” e imprima la siguiente salida por
consola:
El entero leído es: 12
El número de punto flotante es: 33.44
La cadena leída es “Peter”
¡Hola Peter! La suma de 12 y 33.44 es 45.44.
La división entera de 33.44 y 12 es 2 y su resto es 9.44.
Contenido del archivo del ejemplo:
12
33.44
Peter
Creando un método está/co llamado “leerEntradaArchivo” en la clase “Principal” del
programa. La firma de este método será:
public sta/c void leerEntradaArchivo(String rutaArchivo);
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) {
        String rutaArchivo = "/Users/rperdomo/IdeaProjects/UT1/PD6/entrada.txt"; // aquí ponemos el nombre del archivo
        leerEntradaArchivo(rutaArchivo); // llamamos al método para leer el archivo
    }

    // método para leer del archivo
    public static void leerEntradaArchivo(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            // leemos cada línea del archivo
            int entero = Integer.parseInt(br.readLine()); // leemos un entero
            double puntoFlotante = Double.parseDouble(br.readLine()); // leemos un número de punto flotante
            String cadena = br.readLine(); // leemos una cadena

            // mostramos los resultados
            System.out.println("El entero leído es: " + entero);
            System.out.println("El número de punto flotante es: " + puntoFlotante);
            System.out.println("La cadena leída es \"" + cadena + "\"");
            System.out.println("¡Hola " + cadena + "! La suma de " + entero + " y " + puntoFlotante + " es " + (entero + puntoFlotante) + ".");
            System.out.println("La división entera de " + puntoFlotante + " y " + entero + " es " + ((int)(puntoFlotante / entero)) + " y su resto es " + (puntoFlotante % entero) + ".");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error en el formato de los datos: " + e.getMessage());
        }
    }
}
