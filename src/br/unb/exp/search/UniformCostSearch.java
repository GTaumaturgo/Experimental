package br.unb.exp.search;

import br.unb.exp.Graph.Edge;
import br.unb.exp.Graph.Graph;

import java.util.PriorityQueue;
import java.util.Queue;

public class UniformCostSearch extends Search {
    @Override
    protected void realizarBusca(Graph g, int origin, int target) {

        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(origin,0.0));
        while(q.size() > 0){
            Edge e = q.peek(); q.remove();

            markVisit(e);
            if(e.to == target){
                statistics.pathWeight = e.weight;
                break;
            }


            for (Edge w: g.getNode(e.to).adjList){
                if (statistics.bestPath.get(w.to) > e.weight + w.weight){

                    q.add(new Edge(w.to,w.weight + e.weight));
                    statistics.bestPath.add(w.to,Math.min(statistics.bestPath.get(w.to),e.weight + w.weight));
                    statistics.ancestor.add(w.to,new Edge(e.to,w.weight));
                }
            }

        }
    }


}
