package br.unb.exp.search;

import br.unb.exp.Graph.Edge;
import br.unb.exp.Graph.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class BreadthFirstSearch extends Search {
    @Override
    protected void realizarBusca(Graph g, int origin, int target) {
        ArrayDeque<Edge> q = new ArrayDeque<>();


        itera(g,origin,target,q);



    }
}
