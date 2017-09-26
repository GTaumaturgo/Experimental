package br.unb.exp.search;

import br.unb.exp.Graph.Edge;

public class HeuristicState {
    public Edge estimatedCost;
    public double realCost;

    public HeuristicState(Edge e, double realCost){
        estimatedCost = e;
        this.realCost = realCost;
    }


}
