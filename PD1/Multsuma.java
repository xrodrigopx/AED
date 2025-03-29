/*
EJERCICIO 3
Muchos cálculos pueden ser expresados de manera concisa usando la operación “multsuma”
,
que toma tres operandos y computa a*b + c. Algunos procesadores incluso proveen una
implementación de hardware para esta operación para números de punto flotante.
Crear un nuevo programa llamado Multsuma.java. Escribir un método llamado multsuma que
toma tres doubles como parámetros y que imprime el resultado de multisumarlo.
Escribir un método main que testee multsuma invocándolo con unos pocos parámetros
simples, como por ejemplo 1.0, 2.0, 3.0, y después imprima por consola el resultado, que en
ese caso debería ser 5.0.
 */

public class Multsuma {
    public static void multsuma(double a, double b, double c) {
        double resultado = a * b + c;
        System.out.println("El resultado de " + a + " * " + b + " + " + c + " es: " + resultado);
    }

    public static void main(String[] args) {
        multsuma(1.0, 2.0, 3.0); // esto debería dar 5.0
        multsuma(4.0, 5.0, 6.0); // otro ejemplo
        multsuma(0.5, 10.0, 2.0); // mass ejemplos
    }
}

