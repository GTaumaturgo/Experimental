package br.unb.exp.search;

import br.unb.exp.Graph.Edge;
import br.unb.exp.Graph.Graph;
import br.unb.exp.Graph.Node;

import java.util.Queue;

public abstract class Search {
    protected SearchStatistics statistics;
    Graph g;


    public void markVisit(Edge e){// TODO trocar pra nodeid
        statistics.visitedNodes++;
        statistics.visited.add(e.to);

//        System.out.println(statistics.bestPath.size());
    }

    protected abstract void realizarBusca(int origin, int target);


    public void buscaAux(int origin, int target){
        long start = System.nanoTime();
        realizarBusca(origin,target);


        long end = System.nanoTime();


        long duration = end - start;
        statistics.execTime = duration;
        statistics.uniqueNodesVisited = statistics.visited.size();
    }

    public SearchStatistics getStatistics(){return statistics;}



}
