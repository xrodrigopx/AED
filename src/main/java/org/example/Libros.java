package org.example;

import java.util.Stack;

public class Libros {
    public static void main(String[] args) {
        Stack<String> libros = new Stack<String>();
        libros.push("Java");
        libros.push("Python");
        libros.push("JavaScript");
        libros.push("PHP");


        System.out.println(libros); // muestra toda la pila

        System.out.println(libros.peek()); // mmuestra el libro que esta mas arriba
        System.out.println(libros.pop()); // elimina el elemento de mas arriba
        System.out.println(libros);
        System.out.println(libros.peek()); // ahora Python deberia estar en lo mas alto.
        System.out.println(libros.search("Java")); // esto muestra la posicion del libro con respecto al mas alto.
        System.out.println(libros.isEmpty()); // consulta si la pila esta vacia.
    }
}
