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
sin unos if no lo puedo hacer
*/
public class IsPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // pedir el número
        System.out.print("Ingrese un número entero positivo: ");
        int n = scanner.nextInt(); // almacenarlo

        if (n <= 0) {
            System.out.println("Por favor, ingrese un número positivo.");
            return;
        }

        boolean esPrimo = true;
        if (n == 1) {
            esPrimo = false; // 1 no es primo
        } else if (n > 2) {
            int divisor = 2;
            while (divisor <= Math.sqrt(n)) {
                if (n % divisor == 0) {
                    esPrimo = false;
                    break;
                }
                divisor++;
            }
        }

        if (esPrimo) {
            System.out.println(n + " es un número primo.");
            // sumar números pares desde 0 hasta n
            int sumaPares = 0;
            int cero = 0;
            while (cero <= n) {
                sumaPares += cero;
                cero += 2; // avanzar solo a números pares
            }
            System.out.println("La suma de los números pares desde 0 hasta " + n + " es: " + sumaPares);
        } else {
            System.out.println(n + " no es un número primo.");
            // sumar números impares desde 0 hasta n
            int sumaImpares = 0;
            int uno = 1;
            while (uno <= n) {
                sumaImpares += uno;
                uno += 2; // avanzar solo a números impares
            }
            System.out.println("La suma de los números impares desde 0 hasta " + n + " es: " + sumaImpares);
        }

        scanner.close();
    }
}
