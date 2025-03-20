package org.example;

public class Operadores {
    public static void main(String[] args) {

        //definimos nuestras variables
        int x = 10;
        int y = 20;
        int z = 30;

        System.out.println(x + y); // adicion
        System.out.println(x -y); // sustraer
        System.out.println(x * y); // multiplicar
        System.out.println(y / x); // dividir
        System.out.println(x % y); // modulo o resto de la division entera

        System.out.println(++z); // incremento predeciendo la variable
        System.out.println(x++); // incremento siguiendo la variable, este no imprime nada porque primero la imprime y luego la incrementa.
        System.out.println(x); // si la imprimimos ahora, va a imprimirse incrementada


    }
}
