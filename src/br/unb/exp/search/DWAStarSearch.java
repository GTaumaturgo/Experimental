package br.unb.exp.search;

import br.unb.exp.Coordinate;
import br.unb.exp.Graph.Edge;
import br.unb.exp.Graph.Graph;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class DWAStarSearch extends Search {

    double factor;
    public DWAStarSearch(Graph g, HashMap<Integer, Coordinate> coordinates, double factor) {
        this.g = g;
        this.coordinates = coordinates;
        this.statistics = new SearchStatistics(g.getSize());
        this.factor = factor;
    }


    @Override
    protected void realizarBusca( int origin, int target) {
        PriorityQueue<HeuristicState> q;




    }

}
