package br.unb.exp.search;

import br.unb.exp.Graph.Edge;

public class HeuristicState implements Comparable{
    public Edge estimatedCost;
    public double realCost;

    public HeuristicState(Edge e, double realCost){
        estimatedCost = e;
        this.realCost = realCost;
    }


    @Override
    public int compareTo(Object o) {
        HeuristicState h = (HeuristicState) o;
        Double d = this.estimatedCost.weight;
        return d.compareTo(h.estimatedCost.weight);
    }

}
