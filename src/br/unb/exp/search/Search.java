package br.unb.exp.search;

import br.unb.exp.Grafo.Graph;
import br.unb.exp.Grafo.Node;

public abstract class Search {
    SearchStatistics statistics;



    public void markVisit(int nodeId){
        statistics.visitedNodes++;
        statistics.visited.add(nodeId);

    }

    protected abstract void realizarBusca(Graph g, Node origin, Node target);


    public void buscaAux(Graph g, Node origin, Node target){
        statistics = new SearchStatistics();

        long start = System.nanoTime();
        realizarBusca(g,origin,target);
        long end = System.nanoTime();
        long duration = end - start;
        statistics.execTime = duration;
        statistics.uniqueNodesVisited = statistics.visited.size();
    }

}
