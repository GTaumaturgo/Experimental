package br.unb.exp.search;

import br.unb.exp.Graph.Edge;
import br.unb.exp.Graph.Graph;
import br.unb.exp.Graph.Node;

import java.util.Queue;

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

    public SearchStatistics getStatistics(){return statistics;}

    public void itera(Graph g, int origin, int target, Queue<Edge> q){
        q.add(new Edge(origin,0));
        while(true && q.size() > 0){
            Edge e = q.peek(); q.remove();

            if (statistics.wasVisited(e.to)){
                markVisit(e.to);
                continue;
            }
            markVisit(e.to);

            if(e.to == target){
                statistics.pathWeight = e.weight;
                break;
            }


            for (Edge w: g.getNode(e.to).adjList) {
                if(!statistics.wasVisited(w.to)){
                    q.add(new Edge(w.to,e.weight + w.weight));
                }
            }

        }
    }

}
