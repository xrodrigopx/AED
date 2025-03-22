package org.example;

import java.util.Scanner;

/*
Hacer un programa en Java que indique si un número dado es primo. Si lo es, el programa deberá
calcular la suma de los números pares desde 0 hasta el número dado, y en caso contrario deberá
calcular la suma de los números impares desde 0 hasta el número dado. Utilizar solamente sentencias
while o do-while.

un numero primo es cuando solo es divisible por si mismo y la unidad, y tiene que ser positivo, 2 es el unico numero primo par, hay que hacer un if para determinar esto primero.
Luego, hay que implementar una logica en un while o do while para hacer la suma de los pares desde 0 hasta el numero
lo mismo para los impares

 */
public class IsPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int cero = 0;
        // cuando no es primo
        while (n % n != 1) {
            System.out.println(n + " no es primo");

            // logica de la suma de los numeros pares
            while (cero < n) {
                cero++;
                System.out.println(cero + " cero");
            }
        }
    }
}