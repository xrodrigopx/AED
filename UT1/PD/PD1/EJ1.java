/*
Dado el siguiente programa:
public static void zoop () {
baffle ();
System.out.print ("Vos zacata ");
baffle ();
}
public static void main (String[] args) {
System.out.print ("No, yo ");
zoop ();
System.out.print ("Yo ");
baffle ();
}
public static void baffle () {
System.out.print ("pac");
ping ();
}
public static void ping () {
System.out.println (".");
}

¿Cuál es la salida? Sé preciso acerca de dónde hay espacios y dónde hay nuevas líneas.
Indicar cuál es la respuesta más correcta: (\n denota nueva línea)

en el método main se imprime "No, yo " con un espacio al final
luego se llama al método zoop
en zoop se llama a baffle
baffle imprime "pac"
luego llama a ping que imprime "." y salta a la siguiente línea
hasta ahora la salida es "No, yo pac"
luego en zoop se imprime "Vos zacata " con un espacio
se llama de nuevo a baffle
imprime "pac"
llama a ping que imprime "." y salta otra línea
ahora la salida es "No, yo pac" "Vos zacata pac"
regresa a main e imprime "Yo " con un espacio
llama a baffle
imprime "pac"
llama a ping que imprime "." y salta otra línea
la salida final del programa es "No, yo pac" "Vos zacata pac" "Yo pac"
 */

public class EJ1 {
}
