package practica2y3;

import java.util.ArrayList;
import java.util.List;

public class Arbol {
    List<List<Integer>> adjList = new ArrayList<>();

    public Arbol(List<LadoArbol> edges) {
        int n = 0;
        for (LadoArbol e : edges) {
            n = Integer.max(n, Integer.max(e.src, e.dest));
        }

        for (int i = 0; i <= n; i++) {
            adjList.add(i, new ArrayList<>());
        }

        for (LadoArbol current : edges) {
            adjList.get(current.src).add(current.dest);
        }
    }

    public static void mostrarArbol(Arbol arbol)
    {
        int src = 0;
        int n = arbol.adjList.size();

        while (src < n)
        {
            // imprime el vértice actual y todos sus vértices vecinos
            for (int dest: arbol.adjList.get(src)) {
                System.out.print("(" + src + " ——> " + dest + ")\t");
            }
            System.out.println();
            src++;
        }
    }
}
