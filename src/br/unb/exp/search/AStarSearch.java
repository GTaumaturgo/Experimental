package br.unb.exp.search;

import br.unb.exp.Graph.Edge;
import br.unb.exp.Graph.Graph;

import java.util.Queue;

public class AStarSearch extends Search {
    @Override
    protected void realizarBusca(Graph g, int origin, int target) {

    }

    @Override
    protected void enqueue(Queue<Edge> q, Edge aggregated, Edge e) {

    }

    @Override
    protected boolean condition(Edge e, Edge w) {
        return false;
    }
}
