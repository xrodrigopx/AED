package org.example;

import java.util.Arrays;

// primero definimos la clase
public class Granja {

    // luego los elementos de la clase
    String[] animales;

    // luego el constructor, en este caso vamos a querer definir los animales de la granja, por lo tanto, es un array con animales en string
    public Granja() {
        this.animales = new String[]{"Vaca", "Caballo", "Gallina"};
    }

    // ahora hay que pasar el constructor a String denuevo, porque el constructor no es una String, sino que es unarray formado por strings
    public String obtenerAnimales() {
        return Arrays.toString(animales);
    }

    // definimos el metodo principal para ver que vamos a hacer con la granja.
    public static void main(String[] args) {

        // ahora tenemos que crear una granja obviamente
        Granja miGranja = new Granja();

        // Al final llamamos al metodo obtenerAnimales para imprimir el contenido de miGranja
        System.out.println(miGranja.obtenerAnimales());
    }
}

