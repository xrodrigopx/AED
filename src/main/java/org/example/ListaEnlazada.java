package org.example;

import java.util.LinkedList;

// se basa en nodos enlazados
// es mejor para insertar y eliminar elementos si se tiene una referencia al nodo O(1)
// mayor uso de memoria debido a la sobrecarga de los nodos

public class ListaEnlazada {
    public static void main(String[] args) {
        LinkedList<String> lista = new LinkedList<>(); // crear el objeto

        // insertar elementos
        lista.add("Elemento 1"); // agregar al final
        lista.addFirst("Elemento 0"); // agregar al principio
        lista.add(1, "Elemento 0.5"); // agregar en la posición 1

        // buscar elementos
        int index = lista.indexOf("Elemento 1"); // buscar el elemento 1 por el indice
        if (index != -1) {
            System.out.println("Elemento encontrado en índice: " + index);
        } else {
            System.out.println("Elemento no encontrado.");
        }

        // eliminar elementos
        lista.remove("Elemento 0.5"); // eliminar por valor especifico
        lista.remove(0); // eliminar por índice

        System.out.println("Lista final: " + lista);
    }
}
