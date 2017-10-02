package br.unb.exp.search;

import br.unb.exp.Graph.Edge;

import java.util.ArrayList;
import java.util.HashSet;

public class SearchStatistics {
    public int visitedNodes;
    public int uniqueNodesVisited;
    public long execTime;
    HashSet<Integer> visited;
    public double pathWeight;
    public ArrayList<Double> bestPath;
    public HashSet<Integer> enqueued;
    public SearchStatistics(int size){
        double inf = 1e9;
        visitedNodes = -1;
        uniqueNodesVisited = -1;
        execTime = 0;
        visited = new HashSet<Integer>();
        bestPath = new ArrayList<>(size);
        enqueued = new HashSet<Integer>();
        for (int i = 0; i < size; i++) {
             bestPath.add(i,inf);
//             ancestor.add(i,new Edge(-1,0));
        }

    }

    public boolean wasVisited(int nodeid){
        return visited.contains(nodeid);
    }
    public boolean wasEnqueued(int nodeid){
        return enqueued.contains(nodeid);
    }

}
