package br.unb.exp.search;

import br.unb.exp.Graph.Edge;
import br.unb.exp.Graph.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class BreadthFirstSearch extends Search {
    @Override
    protected void realizarBusca(Graph g, int origin, int target) {
        ArrayDeque<Edge> q = new ArrayDeque<>();

        ArrayList<Boolean> visited = new ArrayList<Boolean>(g.getSize());
        for(Boolean b: visited) b = false;

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
