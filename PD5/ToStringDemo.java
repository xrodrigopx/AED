public class ToStringDemo {
    public static void main(String[] args) {
        double d = 858.48;
        String s = Double.toString(d);

        int dot = s.indexOf('.');

        System.out.println(dot + " digits " + "before decimal point.");
        System.out.println( (s.length() - dot - 1) + " digits after decimal point.");
    }
}

/*
Indicar por qué se imprime cada uno de los datos y la razón de su forma
se toma el double d como valor y se le pasa a s como string mediante el metodo Double.toString
se toma el punto como referencia mediante el metodo indexof indicando que el punto existe en la posicion 3 y se almacena en dot
se toma el largo total de la cadena, que seria 6 en este caso, se le resta la cantidad del valor del indice del punto que es 3, finalmente se le resta el indice 0 porque es el valor del punto en si mismo, la cuenta seria 6 - 3 - 1 = 2

 */