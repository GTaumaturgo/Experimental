package br.unb.exp.search;

import br.unb.exp.Graph.Edge;
import br.unb.exp.Graph.Graph;

import java.util.PriorityQueue;
import java.util.Queue;

public class UniformCostSearch extends Search {
    @Override
    protected void realizarBusca(Graph g, int origin, int target) {

        PriorityQueue<Edge> q = new PriorityQueue<>();

        iterate(g,origin,target,q);
    }

    @Override
    protected void enqueue(Queue<Edge> q, Edge aggregated, Edge e) {
        q.add(new Edge( e.to,aggregated.weight + e.weight));
    }
}
