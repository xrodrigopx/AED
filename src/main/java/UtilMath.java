/*
Implementar un método que calcule el factorial de un número entero cualquiera, siendo este un
parámetro del método. Utilizar únicamente bucles for.
Si N=3 entonces factorial(N) = 3.2.1 = 6
Una posible firma del método:
public static int factorial(int num)
{...}


el factorial de 5 es 5 x 4 x 3 x 2 x 1.
Esto quiere decir que el factorial de 5 es: 5 * (5-1) * (5-2) * (5-3) * (5-4) y ahi termina.
Por lo tanto, vamos a definir tres variables, una para nuestro numero, una para el producto de la multiplicacion y una para el resultado de la resta.
La resta tiene que ser el numero menos un contador incremental de 1 en 1 que haremos con un for.
Luego, con un if, vamos a evaluar si la resta, si la resta no es igual a 1, realizamos la multiplicacion y guardamos el valor. Con cada iteracion, debemos multiplicar el resultado anterior por el que ya tenemos. Si la resta es igual a uno, se imprime el numero resultante. Para 5 es 720.


 */

public class UtilMath {
    public static void main(String[] args) {
        // variables
        int aNumber = 5; // queremos el factorial de esto.
        int bNumber = 0; // resultado del producto.
        int cNumber = 0; // resultado de la resta.

        for (int i = 0; i < aNumber; i++) {
            System.out.println(bNumber);
        }

    }
}
