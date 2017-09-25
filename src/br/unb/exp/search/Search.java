package br.unb.exp.search;

import br.unb.exp.Graph.Edge;
import br.unb.exp.Graph.Graph;
import br.unb.exp.Graph.Node;

import java.util.Queue;

public abstract class Search {
    protected SearchStatistics statistics;



    public void markVisit(Edge e){
        statistics.visitedNodes++;
        statistics.visited.add(e.to);
//        System.out.println(statistics.bestPath.size());
    }

    protected abstract void realizarBusca(Graph g, int origin, int target);


    public void buscaAux(Graph g, int origin, int target){
        statistics = new SearchStatistics(g.getSize());

        long start = System.nanoTime();
        realizarBusca(g,origin,target);


        long end = System.nanoTime();


        long duration = end - start;
        statistics.execTime = duration;
        statistics.uniqueNodesVisited = statistics.visited.size();
    }

    public SearchStatistics getStatistics(){return statistics;}



}
