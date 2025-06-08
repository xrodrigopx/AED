/*
Indicar el error al ejecutar la clase Alumno y corregirlo. ¿cómo lo detectaste?

En la clase Alumno, me di cuenta de que en el método getNombreAdmiracion había un lío porque intentaba concatenar con un nombre que podía ser null y eso causaba un error. Así que le puse una verificación para manejar ese caso y ahora devuelve un mensaje alternativo.
 */

public class Alumno {
    private String nombre;

    public Alumno() {
        nombre = null;
    }

    public String getNombreAdmiracion() {
        return nombre != null ? nombre.concat("!") : "¡Sin nombre!";
    }

    public static void main(String[] args) {
        Alumno alumno = new Alumno();
        System.out.println(alumno.getNombreAdmiracion());
    }
}
