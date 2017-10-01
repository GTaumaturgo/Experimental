package br.unb.exp.search;

import br.unb.exp.Graph.Edge;
import br.unb.exp.Graph.Graph;

public class DepthFirstSearch extends Search {

    public DepthFirstSearch(Graph g) {
        this.g = g;
        this.statistics = new SearchStatistics(g.getSize());
    }

    @Override
    protected void realizarBusca(int origin, int target) {
        if(statistics.wasVisited(origin))
            return;
        markVisit(new Edge(origin,0.0));
        System.out.println(origin);
        for(Edge e: g.getNode(origin).adjList){

            realizarBusca(e.to,-1);
        }

    }
}
