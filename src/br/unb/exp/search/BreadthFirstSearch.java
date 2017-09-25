package br.unb.exp.search;

import br.unb.exp.Graph.Edge;
import br.unb.exp.Graph.Graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class BreadthFirstSearch extends Search {
    @Override
    protected void realizarBusca(Graph g, int origin, int target) {
        ArrayDeque<Edge> q = new ArrayDeque<>();


        q.add(new Edge(origin,0));
        while(q.size() > 0){
            Edge e = q.peek(); q.remove();

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
