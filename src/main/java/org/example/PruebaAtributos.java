/*
1. Cree un pequeño programa (clase “PruebaAtributos”) que defina algunos atributos (variables de
instancia). Intente crear algunos nombres de atributos incorrectos y vea qué tipo de error
produce el compilador. Utilice como guía las reglas y convenciones de nomenclatura (vea el
apartado “Naming” en el link anterior)

2. Extienda el programa para que imprima los valores de los atributos. Deje los atributos sin
inicializar y observe qué sucede al ejecutar.

3. Intente lo mismo con variables locales y vea qué errores de compilador puede producir
(Familiarizarse con los errores comunes de compilación va a hacer que le sea más fácil reconocer
bugs en su código.)
 */

//PruebaAtributos
package org.example;

import java.util.Arrays;

public class PruebaAtributos {
    public static void main(String[] args) {

        // primitivos

        int x = 10, y = 20; // van desde -2,147,483,648 hasta 2,147,483,647
        System.out.println("x: " + x);
        System.out.println("y: " + y);

        float z = 3.14f; // de punto flotante, pueden tener 6 o hasta 7 cifras de presición, hay que ponerle la f al final para especificar
        System.out.println("z: " + z);

        double d = 3.14; // mismo que el float pero puede tener hasta 15 o 16 cifras de presición
        System.out.println("d: " + d);

        long l = 10L; // van desde -9,223,372,036,854,775,808 hasta 9,223,372,036,854,775,807, hay que ponerle la L al final
        System.out.println("l: " + l);

        short s = (short) 10; // van desde -32768 hasta 32767
        System.out.println("s: " + s);

        byte b = 127;  // van desde -128 hasta 127
        System.out.println("b: " + b);

        boolean bool = true;
        boolean bool2 = false;
        System.out.println("bool: " + bool);
        System.out.println("bool2: " + bool2);

        char c = 'c'; // para una sola letra, de valor ASCII
        System.out.println("c: " + c);

        // no primitivos
        // los no primitivos pueden ser String, Arrays, Classes, etc, lo que empieze con mayúsculas.
        // algo importante a saber es que a los no primitivos los podemos declarar sin inicializar, su valor por defecto si no le asignamos uno es null. Esto nos permite declararlos primero y luego inicializarlos, o en una misma línea declararlos e inicializarlos.

        String Vaca = "Lola"; // almacena líneas de texto entre comillas dobles, aquí declaramos e inicializamos
        System.out.println("Vaca: " + Vaca);

        String[] Animalitos = {"Vaca", "Caballo", "Pato", "Chancho"}; // Aquí declaramos e inicializamos también.
        System.out.println("Animalitos: " + Arrays.toString(Animalitos)); // aquí imprimimos usando el méthod Arrays.toString y pasandole como argumento el nombre del objeto.

    }
}