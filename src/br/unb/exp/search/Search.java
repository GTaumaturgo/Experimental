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
        statistics.bestPath.add(e.to,Math.min(statistics.bestPath.get(e.to),e.weight));
    }

    protected abstract void realizarBusca(Graph g, int origin, int target);
    protected abstract void enqueue(Queue<Edge> q, Edge aggregated, Edge e);


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

    public void iterate(Graph g, int origin, int target, Queue<Edge> q){
        q.add(new Edge(origin,0));
        while(true && q.size() > 0){
            Edge e = q.peek(); q.remove();


            markVisit(e);

            if(e.to == target){
                statistics.pathWeight = e.weight;
                break;
            }


            for (Edge w: g.getNode(e.to).adjList)
                if (statistics.bestPath.get(w.to) > (e.weight + w.weight)) enqueue(q, e, w);

        }
    }

}
