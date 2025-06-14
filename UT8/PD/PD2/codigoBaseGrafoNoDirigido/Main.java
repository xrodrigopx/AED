import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<TVertice> vertices = Arrays.asList(
            new TVertice("A"),
            new TVertice("B"),
            new TVertice("C"),
            new TVertice("D")
        );

        List<TArista> aristas = Arrays.asList(
            new TArista("A", "B", 1),
            new TArista("B", "D", 2),
            new TArista("C", "D", 3),
            new TArista("A", "C", 4)
        );

        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);

        List<TArista> mstKruskal = grafo.Kruskal();

        System.out.println("Aristas del Árbol de Expansión Mínima (AAM) por Kruskal:");
        int pesoKruskal = 0;
        for (TArista a : mstKruskal) {
            System.out.println(a.getEtiquetaOrigen() + " - " + a.getEtiquetaDestino() + " : " + a.getCosto());
            pesoKruskal += a.getCosto();
        }
        System.out.println("Peso total Kruskal: " + pesoKruskal);

        List<TArista> mstPrim = grafo.Prim();
        System.out.println("\nAristas del Árbol de Expansión Mínima (AAM) por Prim:");
        int pesoPrim = 0;
        for (TArista a : mstPrim) {
            System.out.println(a.getEtiquetaOrigen() + " - " + a.getEtiquetaDestino() + " : " + a.getCosto());
            pesoPrim += a.getCosto();
        }
        System.out.println("Peso total Prim: " + pesoPrim);
    }

    public static void ejemplo2() {
        List<TVertice> vertices = Arrays.asList(
            new TVertice("A"),
            new TVertice("B"),
            new TVertice("C"),
            new TVertice("D"),
            new TVertice("E")
        );

        List<TArista> aristas = Arrays.asList(
            new TArista("A", "B", 2),
            new TArista("A", "C", 6),
            new TArista("A", "D", 3),
            new TArista("B", "D", 5),
            new TArista("B", "E", 4),
            new TArista("C", "D", 1),
            new TArista("D", "E", 7)
        );

        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);

        List<TArista> mstKruskal = grafo.Kruskal();

        System.out.println("AAM ejemplo 2 por Kruskal:");
        int pesoKruskal = 0;
        for (TArista a : mstKruskal) {
            System.out.println(a.getEtiquetaOrigen() + " - " + a.getEtiquetaDestino() + " : " + a.getCosto());
            pesoKruskal += a.getCosto();
        }
        System.out.println("Peso total Kruskal: " + pesoKruskal);

        List<TArista> mstPrim = grafo.Prim();
        System.out.println("\nAAM ejemplo 2 por Prim:");
        int pesoPrim = 0;
        for (TArista a : mstPrim) {
            System.out.println(a.getEtiquetaOrigen() + " - " + a.getEtiquetaDestino() + " : " + a.getCosto());
            pesoPrim += a.getCosto();
        }
        System.out.println("Peso total Prim: " + pesoPrim);
    }
}