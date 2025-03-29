package org.example;
/*
se basa en array dinamico
mejores para acceso aleatorio, notacion O de 1, o O(1)
costoso para eliminar e insertar en el medio O(n)
 */


import java.util.ArrayList;

public class Lista {
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>(); // se crea la lista

        // para insertar:
        lista.add("Elemento 1"); // esto agrega el elemento al final
        lista.add(0, "Elemento 0"); // esto agrega segun el indice

        // para buscar:
        int index = lista.indexOf("Elemento 1"); // esto busca el indice de elemento 1
        if (index != -1) {
            System.out.println("Elemento encontrado en índice: " + index);
        } else {
            System.out.println("Elemento no encontrado.");
        }

        // para eliminar:
        lista.remove("Elemento 0"); // elimina el elemento especifico
        lista.remove(0); // elmina por indice

        System.out.println("Lista final: " + lista);
    }
}

