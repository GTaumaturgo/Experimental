package br.unb.exp.search;

import br.unb.exp.Calculator.Calculator;
import br.unb.exp.Coordinate;
import br.unb.exp.Graph.Edge;
import br.unb.exp.Graph.Graph;

import java.util.HashMap;
import java.util.PriorityQueue;


public class AStarSearch extends Search {

    double factor;
    public AStarSearch(Graph g, HashMap<Integer, Coordinate> coordinates,double factor) {
        this.g = g;
        this.coordinates = coordinates;
        this.statistics = new SearchStatistics(g.getSize());
        this.factor = factor;
    }


    @Override
    protected void realizarBusca(int origin, int target) {
        PriorityQueue<HeuristicState> q = new PriorityQueue<>();
        Calculator c = new Calculator();



        q.add(new HeuristicState(new Edge(origin,0.0),0.0));

        while(q.size() > 0){


            HeuristicState u = q.poll();

            if(statistics.wasVisited(u.estimatedCost.to)){
                markVisit(u.estimatedCost);
                continue;
            }

            markVisit(u.estimatedCost);
            if(u.estimatedCost.to == target){
                statistics.pathWeight = u.realCost;
//                System.out.println(u.estimatedCost.weight);
                break;
            }

            for(Edge w: g.getNode(u.estimatedCost.to).adjList){
                double distance = c.calculateDistance(coordinates.get(target),coordinates.get(w.to));
                q.add(new HeuristicState(new Edge(w.to,(distance / factor) + u.realCost + w.weight),u.realCost + w.weight));

            }
        }
    }

}
