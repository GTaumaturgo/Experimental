package br.unb.exp.search;

import br.unb.exp.Calculator.Calculator;
import br.unb.exp.Coordinate;
import br.unb.exp.Graph.Edge;
import br.unb.exp.Graph.Graph;

import java.util.HashMap;
import java.util.PriorityQueue;

public class UniformCostSearch extends Search {
    public UniformCostSearch(Graph g) {
        this.g = g;
        this.statistics = new SearchStatistics(g.getSize());
    }

    public UniformCostSearch(Graph g,HashMap<Integer, Coordinate> coordinates) {
        this.g = g;
        this.statistics = new SearchStatistics(g.getSize());
        this.coordinates = coordinates;
    }


    @Override
    protected void realizarBusca(int origin, int target) {

        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(origin,0.0));
        Calculator c = new Calculator();
        statistics.bestPath.add(origin,0.0);
        while(q.size() > 0){
            Edge e = q.poll();



            if(statistics.wasVisited(e.to)) {
                markVisit(e);
                continue;
            }

            markVisit(e);
            if(e.to == target){
                statistics.pathWeight = e.weight;
                break;
            }
            if(target == -1){

                if(e.weight != 0.0){
                    double deviation = c.calculateDistance(coordinates.get(origin),coordinates.get(e.to)) / e.weight;
                    statistics.heuristicMaxError = Math.max(statistics.heuristicMaxError,deviation);
                }
            }

            for (Edge w: g.getNode(e.to).adjList){
                if (!statistics.wasVisited(w.to)){

                    q.add(new Edge(w.to,w.weight + e.weight));
                    statistics.bestPath.add(w.to,Math.min(e.weight + w.weight,statistics.bestPath.get(w.to)));
                }
            }

        }
    }


}
