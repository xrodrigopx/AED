/*
1) El siguiente código crea un array y una string. ¿Cuántas referencias a estos objetos
existen luego de que el código se ha ejecutado? ¿Es alguno de los objetos candidato a
ser eliminado por el garbage collector?
String[] students = new String[10];
String studentName = "Peter Parker";
students[0] = studentName;
studentName = null;
...
2) Cómo hace un programa para destruir un objeto que ha creado?
    mediante el garbage collector, de manera recurrente pasa el camion de la basura para levantar aquellos objetos que no tienen referencias hace cierto tiempo. por ejemplo, si seteamos una variable en null, el garbage collector realizará un chequeo de esta misma y la marcará para borrarla, cuando vuelve a pasar por esta variable, si la variable sigue en null, se borra.



3) Dada la siguiente clase, llamada “ContenedorDeNumeros”, escribe un programa que
cree una instancia de la clase, inicialice sus dos variables miembro yluego muestre el
valor de cada una de ellas.
public class NumberHolder {
public int anInt;
public float aFloat;
}

Se crea un array de strings de 10 objetos en la variable students
Se crea un String studentName llamado Peter Parker.
en el array students[] se hace referencia a studentName
se setea studentName en null

hay dos referencias que apuntan a Peter Parker, una en studentName y otra en  el indice 0 de students

si bien al asignar null a studentName, todavia tenemos la referencia del indice 0 del array students apuntando a Peter Parker y studentName accede a students[0]

por lo tanto, no hay candidatos para el garbage collector, ya que todos los objetos tienen una referencia.

 */

public class ContenedorDeNumeros {
    // atributos
    public int anInt;
    public float aFloat;

    // constructor
    public ContenedorDeNumeros(int anInt, float aFloat) {
        this.anInt = anInt;
        this.aFloat = aFloat;
    }

    // metodo main para imprimir
    public static void main(String[] args) {
        int anInt = 10;
        float aFloat = 12.5f;
        // instanciar el objeto que recibe dos parametros
        ContenedorDeNumeros numberHolder = new ContenedorDeNumeros(anInt, aFloat);

        System.out.println("anInt: " + numberHolder.anInt);
        System.out.println("aFloat: " + numberHolder.aFloat);
    }
}



