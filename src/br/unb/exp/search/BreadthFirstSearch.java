package br.unb.exp.search;

import br.unb.exp.Graph.Edge;
import br.unb.exp.Graph.Graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class BreadthFirstSearch extends Search {


    public BreadthFirstSearch(Graph g) {
        this.g = g;
        this.statistics = new SearchStatistics(g.getSize());
    }

    @Override
    protected void realizarBusca(int origin, int target) {
        ArrayDeque<Edge> q = new ArrayDeque<>();


        q.add(new Edge(origin,0));
        while(q.size() > 0){
//            System.out.println("jorge");
            Edge e = q.poll();

            markVisit(e);
            if(e.to == target){
                statistics.pathWeight = e.weight;
                break;
            }


            for (Edge w: g.getNode(e.to).adjList)

                if (statistics.ancestor.get(w.to).to == -1){

                    q.add(new Edge(w.to,w.weight + e.weight));
                    statistics.ancestor.add(w.to,new Edge(e.to,w.weight));
                }

        }


    }


}
