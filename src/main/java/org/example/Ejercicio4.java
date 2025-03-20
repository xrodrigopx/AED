package org.example;

/*
if (aNumber >= 0)
if (aNumber == 0)
System.out.println("first string");
else System.out.println("second string");
System.out.println("third string");

Qué salida cree que producirá el código si aNumber es 3?
Cree un programa de prueba que contenga el código anterior; haga que aNumber valga 3.
¿Cuál es la salida del programa? ¿Es la que usted predijo?
Explique por qué la salida es la que es, o, en otras palabras, ¿cuál es el flujo de control del código provisto?
Utilizando sólo espacios y saltos de línea, reformatee el código para hacer que el flujo de control
sea más fácil de entender.
Utilice llaves, { y } para aclarar aún más el código.
 */

public class Ejercicio4 {
    public static void main(String[] args) {
        int aNumber = 3;

        if (aNumber >= 0) // va a entrar por aca primero
            if (aNumber == 0) // aca no entra nunca porque no vale 0
                System.out.println("first string");
            else
                System.out.println("second string"); // entra aca porque el 3 pertenece al else en este caso
        System.out.println("third string"); // esto siempre se imprime.

    }
}
