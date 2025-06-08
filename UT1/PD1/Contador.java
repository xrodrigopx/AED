/*
ejercicio 5
Escriba una clase Contador y utilice un bucle while para mostrar el valor de una variable
contador que se incrementa de a uno.
Siga los siguientes pasos para crear su clase:
1. 2. Cree una clase llamada contador con tres atributos llamados: MAX
CONT, incremento
_
y contador. Asigne el valor 50 a MAX
_
CONT y el valor 1 a contador e incremento.
Asegúrese de declarar MAX
CONT como una variable "final"
.
_
Cree un método público mostrarContador en la clase, que no reciba parámetros y
retorne void. Por ejemplo:
public void displayCount()
3. 4. 5. 6. Cree un bucle while en el método con las siguientes características:
a. Expresión booleana: Repita si el valor de contador es menor o igual que el
valor de MAX
CONT.
_
b. Bloque de código:
i. Imprima el valor de la variable contador.
ii. Incremente el valor de la variable contador con el valor de incremento.
Por ejemplo: contador = contador + incremento;
ejecute el archivo Contador.java y observe los valores emitidos.
Reescriba el algoritmo de manera de usar una sentencia do-while. Verifique que hace
lo mismo.
Reescriba el algoritmo de manera de usar una sentencia for. Verifique que hace lo
mismo.

 */

public class Contador {
    // atributos
    private final int MAX_CONT = 50; // maximo valor
    private int contador = 1; // contador inicial
    private int incremento = 1; // incremento

    // metodo para mostrar el contador usando while
    public void mostrarContador() {
        while (contador <= MAX_CONT) { // mientras el contador sea menor o igual que MAX_CONT
            System.out.println(contador); // imprimir contador
            contador = contador + incremento; // incrementar contador
        }
    }

    public static void main(String[] args) {
        Contador c = new Contador(); // crear un objeto Contador
        System.out.println("Usando while:");
        c.mostrarContador(); // mostrar con while

        c.contador = 1; // reiniciar contador para el siguiente metodo

        System.out.println("Usando do-while:");
        c.mostrarContadorDoWhile(); // mostrar con do-while

        c.contador = 1; // reiniciar contador

        System.out.println("Usando for:");
        c.mostrarContadorFor(); // mostrar con for
    }

    // metodo para mostrar el contador usando do-while
    public void mostrarContadorDoWhile() {
        do {
            System.out.println(contador); // imprimir contador
            contador = contador + incremento; // incrementar
        } while (contador <= MAX_CONT); // repetir mientras contador <= MAX_CONT
    }

    // metodo para mostrar el contador usando for
    public void mostrarContadorFor() {
        for (contador = 1; contador <= MAX_CONT; contador += incremento) {
            System.out.println(contador); // imprimir contador
        }
    }
}

