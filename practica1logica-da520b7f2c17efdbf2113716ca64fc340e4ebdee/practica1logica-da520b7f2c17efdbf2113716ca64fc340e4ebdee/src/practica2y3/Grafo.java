package practica2y3;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
            List<List<Nodo>> adjList = new ArrayList<>();

            public Grafo(List<Lado> lados)
            {

                int n = 0;
                for (Lado e: lados) {
                    n = Integer.max(n, Integer.max(e.getOrigen(), e.getDestino()));
                }


                for (int i = 0; i <= n; i++) {
                    adjList.add(i, new ArrayList<>());
                }

                for (Lado e: lados)
                {

                    adjList.get(e.getOrigen()).add(new Nodo(e.getDestino(), e.getPeso()));

        }
    }

    public static void printGraph(Grafo grafo)
    {
        int src = 0;
        int n = grafo.adjList.size();

        while (src < n)
        {
            for (Nodo edge: grafo.adjList.get(src)) {
                System.out.printf("%d ——> %s\t", src, edge);
            }

            System.out.println();
            src++;
        }
    }

    public List<List<Nodo>> getAdjList() {
        return adjList;
    }

    public void setAdjList(List<List<Nodo>> adjList) {
        this.adjList = adjList;
    }
}
