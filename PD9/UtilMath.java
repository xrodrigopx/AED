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

