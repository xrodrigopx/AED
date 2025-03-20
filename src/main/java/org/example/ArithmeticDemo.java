package org.example;

/*
Analice el siguiente programa para identificar oportunidades de utilizar asignaciones
compuestas (operadores).
 */

public class ArithmeticDemo {
    public static void main(String[] args) {
        int result = 1 + 2; // la suma es 3
        System.out.println(result); // imprimo 3
        result = result - 1; // resto 1, la cuenta va en 2
        System.out.println(result); // imprimo 2
        result = result * 2; // la cuenta es 4
        System.out.println(result); // imprimo 4
        result = result / 2; // la cuenta es 2
        System.out.println(result); // imprimo 2
        result = result + 8; // la cuenta es 10
        result = result % 7; // el resto es 3
        System.out.println(result); // imprimo 3


        int i = 3; // asignacion
        i++; // aumenta 1, es 4
        System.out.println(i); // imprimo 4
        ++i; // aumenta 1
        System.out.println(i); // imprimo 5
        System.out.println(++i); // aumenta 1 e imprimo 6
        System.out.println(i++); // imprimo 6, aumenta 1
        System.out.println(i); // imprimo 7
    }
}
