package org.example;

public class ContadorPalabras {
    public int contador(String palabra) {
        int contador = 0;
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == 'a') {
                contador++;

            }
        }
    return contador;
    }
};
