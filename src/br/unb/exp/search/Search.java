package br.unb.exp.search;

import br.unb.exp.Graph.Graph;
import br.unb.exp.Graph.Node;

public abstract class Search {
    protected SearchStatistics statistics;



    public void markVisit(int nodeId){
        statistics.visitedNodes++;
        statistics.visited.add(nodeId);

    }

    protected abstract void realizarBusca(Graph g, int origin, int target);


    public void buscaAux(Graph g, int origin, int target){
        statistics = new SearchStatistics();

        long start = System.nanoTime();
        realizarBusca(g,origin,target);
        long end = System.nanoTime();
        long duration = end - start;
        statistics.execTime = duration;
        statistics.uniqueNodesVisited = statistics.visited.size();
    }

}
