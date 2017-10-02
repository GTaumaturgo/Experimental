package br.unb.exp.search;

import br.unb.exp.Graph.Edge;
import br.unb.exp.Graph.Graph;

import java.util.PriorityQueue;

public class UniformCostSearch extends Search {
    public UniformCostSearch(Graph g) {
        this.g = g;
        this.statistics = new SearchStatistics(g.getSize());
    }

    @Override
    protected void realizarBusca(int origin, int target) {

        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(origin,0.0));

        while(q.size() > 0){
            Edge e = q.poll();

            if(statistics.wasVisited(e.to)) {
                markVisit(e);
                continue;
            }

            markVisit(e);
            if(e.to == target){
                statistics.pathWeight = e.weight;
                break;
            }


            for (Edge w: g.getNode(e.to).adjList){
//                if (statistics.bestPath.get(w.to) > e.weight + w.weight){

                q.add(new Edge(w.to,w.weight + e.weight));
//                statistics.bestPath.add(w.to,e.weight + w.weight);
//                }
            }

        }
    }


}
