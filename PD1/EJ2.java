/*
Dado el siguiente código fuente:
public class Zumbido {
public static void desconcertar (String dirigible) {
System.out.println (dirigible);
sipo ("ping", -5);
}
public static void sipo (String membrillo, int flag) {
if (flag < 0) {
System.out.println (membrillo + " sup");
} else {
System.out.println ("ik");
desconcertar (membrillo);
System.out.println ("muaa-ja-ja-ja");
}
public static void main (String[] args) {
sipo ("traqueteo", 13);
}
}
}
a) ¿Cuál es la primera sentencia que se ejecuta?
primero se ejecuta el main, que tiene sipo adentro
lo primero que se ejecuta es sipo ("traqueteo", 13);

b) Escribir número 2 al lado de la segunda sentencia, un 3 al lado de la que se ejecuta en
tercer lugar, y así siguiendo hasta el final del programa. Si una sentencia se ejecuta más
de una vez, puede que termine con más de un número al lado.

Aquí tienes sin los índices:

sipo("traqueteo", 13);  1
System.out.println("ik");   2
desconcertar("traqueteo");  3
System.out.println("traqueteo");  4
sipo("ping", -5);  5
System.out.println("ping sup");  6
System.out.println("muaa-ja-ja-ja");  7

 */

public class EJ2 {
}
