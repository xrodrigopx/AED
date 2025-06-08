/*
Indica qué es lo que está mal en el siguiente programa:
public class SomethingIsWrong {
public static void main(String[] args) {
Rectangle myRect;
myRect.width = 40;
myRect.height = 50;
System.out.println("myRect's area is " + myRect.area());
}
}
Repara el error, ejecuta el programa y verifica que la salida es correcta.

Falta un objeto rectangulo si queremos conservar la clase SomethingIsWrong.
falta el metodo para calcular el area
falta instanciar la clase rectangle
falta declarar atributos

 */

public class SomethingIsWrong {
    public static void main(String[] args) {
        Rectangle myRect = new Rectangle(); // instanciar la clase Rectangle
        myRect.width = 40;
        myRect.height = 50;
        System.out.println("myRect's area is " + myRect.area());
    }
}

