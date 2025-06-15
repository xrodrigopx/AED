// Basado en el PSF UT8_TA6.pdf

/*
EJERCICIO 1 – Trabajo en grupo:

2. ¿Qué estructuras se usan para implementar Kruskal?

- Se usa una lista con todas las aristas y sus pesos (quién conecta con quién y cuánto cuesta).
- Se utiliza una estructura tipo Union-Find para ir controlando si dos nodos ya están conectados y así evitar ciclos.
- También se necesita otra lista donde se van guardando las aristas que forman el árbol final (MST).

Si no se cuenta con una estructura Union-Find, se implementa con las operaciones básicas `find` y `union`. Lo ideal es agregar compresión de caminos y unión por rango para que funcione más rápido.

3. ¿Cómo funciona Kruskal?

1. Se arranca con una lista vacía llamada `MST`.
2. Se ordenan todas las aristas de menor a mayor peso.
3. Se inicializa Union-Find con todos los nodos (cada uno en su propio grupo).
4. Se recorren las aristas una por una:
    - Si los nodos no están en el mismo grupo, se agrega la arista al MST y se hace la unión de los grupos.
    - Si ya hay (n-1) aristas en el MST, se termina el proceso.
5. Se devuelve la lista final con las aristas del MST.

Estructuras que se usan:
- Lista de aristas
- Union-Find
- Lista para el MST
*/
