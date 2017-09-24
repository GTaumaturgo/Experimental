package br.unb.exp.search;

import br.unb.exp.Graph.Edge;
import br.unb.exp.Graph.Graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class BreadthFirstSearch extends Search {
    @Override
    protected void realizarBusca(Graph g, int origin, int target) {
        ArrayDeque<Edge> q = new ArrayDeque<>();


        iterate(g,origin,target,q);



    }

    @Override
    protected void enqueue(Queue<Edge> q, Edge aggregated, Edge e) {
        q.add(new Edge(e.to,aggregated.weight + e.weight));
    }
}
