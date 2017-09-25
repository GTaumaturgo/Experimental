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
    protected abstract void enqueue(Queue<Edge> q, Edge aggregated, Edge e);
    protected abstract boolean condition(Edge e, Edge w);


    public void buscaAux(Graph g, int origin, int target){
        statistics = new SearchStatistics(g.getSize());

        long start = System.nanoTime();
        realizarBusca(g,origin,target);

        Edge e = statistics.ancestor.get(target);
        double acc = 0;
        int cur = target;
        while(cur != origin){

            acc += e.weight;
            cur = e.to;
            e = statistics.ancestor.get(cur);
        }
        statistics.pathWeight = acc;
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
                break;
            }


            for (Edge w: g.getNode(e.to).adjList)

                if (condition(e,w)){
                    enqueue(q, e, w);

                    statistics.bestPath.add(w.to,Math.min(statistics.bestPath.get(w.to),e.weight + w.weight));
                    statistics.ancestor.add(w.to,new Edge(e.to,w.weight));
                }

        }
    }

}
