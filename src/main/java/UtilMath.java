/*
Implementar un método que calcule el factorial de un número entero cualquiera, siendo este un
parámetro del método. Utilizar únicamente bucles for.
Si N=3 entonces factorial(N) = 3.2.1 = 6
Una posible firma del método:
public static int factorial(int num)
{...}


el factorial de 5 es 5 x 4 x 3 x 2 x 1.
Esto quiere decir que el factorial de 5 es: 5 * (5-1) * (5-2) * (5-3) * (5-4) y ahi termina.
Por lo tanto, vamos a tener que definir un metodo que contenga la logica del calculo del factorial.
Este metodo tiene un bucle for que se encargara de realizar las operaciones aritmeticas necesarias.
El for, seria uno que comienza en el numero dado, le reste uno y nunca llegue a 0. Con cada iteracion el resultado es multiplicado por el numero dado. Devuelve un resultado.
 */

public class UtilMath {
    public static void main(String[] args) {
        int aNumber = 5; // variable de numero cualquiera
        int factorialResult = factorial(aNumber); // metodo que se le aplica al numero deseado.
        System.out.println(factorialResult); // imprimir resultado
    }
    // ahora vamos a definir el metodo para calcular el factorial
    public static int factorial (int num){
        int resultado = num; // vamos a almacenar el resultado en una variable
        for (int i = num -1; i > 0; i--){ // esta logica comienza con el valor de la variable, decrementa en 1, hasta llegar a 1
            resultado *= i; // con cada iteracion se debe multiplicar el resultado de la iteracion anterior por el numero dado
            System.out.println(resultado); // mensaje para debbugear
        }
        return resultado; // devolver resultado del metodo.
    }
}

