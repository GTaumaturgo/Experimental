package br.unb.exp;

import br.unb.exp.Graph.Graph;
import br.unb.exp.search.BreadthFirstSearch;
import br.unb.exp.search.SearchStatistics;

public class Main {


    static void printa(Object o){
        System.out.println(o.toString());
    }


    public static void main(String[] args) {

        // teste BFS
        Graph g = new Graph(4);
        g.addEdge(0,1,1.0);
        g.addEdge(1,2,1.0);
        g.addEdge(2,3,1.0);
        g.addEdge(0,3,1000.0);
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.buscaAux(g,0,3);
        SearchStatistics statistics = bfs.getStatistics();
        printa(statistics.execTime);
        printa(statistics.pathWeight);
        printa(statistics.uniqueNodesVisited);
        printa(statistics.visitedNodes);
    }
}
