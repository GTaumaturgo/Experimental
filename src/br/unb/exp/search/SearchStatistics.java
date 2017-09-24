package br.unb.exp.search;

import java.util.ArrayList;
import java.util.HashSet;

public class SearchStatistics {
    public int visitedNodes;
    public int uniqueNodesVisited;
    public long execTime;
    HashSet<Integer> visited;
    public double pathWeight;
    public ArrayList<Double> bestPath;

    public SearchStatistics(int size){
        double inf = 1e9;
        visitedNodes = -1;
        uniqueNodesVisited = -1;
        execTime = 0;
        visited = new HashSet<Integer>();
        bestPath = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
             bestPath.add(i,inf);
        }

    }

    boolean wasVisited(int nodeid){
        return visited.contains(nodeid);
    }

}
