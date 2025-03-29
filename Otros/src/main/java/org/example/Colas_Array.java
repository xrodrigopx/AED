package org.example;

public class Colas_Array {
    private int[] array; // Arreglo para almacenar los elementos de la cola
    private int front;   // Índice del frente de la cola
    private int rear;    // Índice del final de la cola
    private int size;    // Cantidad actual de elementos en la cola
    private int capacidad; // Capacidad máxima de la cola

    // Constructor para inicializar la cola con una capacidad dada
    public Colas_Array(int capacidad) {
        this.capacidad = capacidad;
        array = new int[capacidad]; // Inicializamos el arreglo con la capacidad especificada
        front = 0;   // El frente empieza en 0
        rear = -1;   // El rear empieza en -1 porque aún no hay elementos
        size = 0;    // Tamaño inicial es 0
    }

    // Agregar elemento al final (enqueue)
    public void enqueue(int element) {
        if (isFull()) { // Verificamos si la cola está llena
            System.out.println("Cola llena, no se puede agregar " + element);
            return;
        }
        rear = (rear + 1) % capacidad; // Avanzamos rear (versión circular)
        array[rear] = element;         // Agregamos el elemento en la posición rear
        size++;                        // Incrementamos el tamaño
        System.out.println(element + " agregado a la cola");
    }

    // Verificar si la cola está llena
    public boolean isFull() {
        return size == capacidad; // La cola está llena si el tamaño actual equals la capacidad
    }

    // Método main para probar la implementación
    public static void main(String[] args) {
        Colas_Array cola = new Colas_Array(3); // Creamos una cola con capacidad 3
        cola.enqueue(1); // Agregamos 1
        cola.enqueue(2); // Agregamos 2
        cola.enqueue(3); // Agregamos 3
        cola.enqueue(4); // Intentamos agregar 4 (debería decir "Cola llena")
    }
}