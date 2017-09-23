package br.unb.exp.search;

import br.unb.exp.Graph.Edge;
import br.unb.exp.Graph.Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class UniformCostSearch extends Search {
    @Override
    protected void realizarBusca(Graph g, int origin, int target) {

        PriorityQueue<Edge> q = new PriorityQueue<>();

        itera(g,origin,target,q);
    }
}
