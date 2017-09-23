package br.unb.exp.search;

import java.util.HashSet;

public class SearchStatistics {
    public int visitedNodes;
    public int uniqueNodesVisited;
    public long execTime;
    HashSet<Integer> visited;
    public double pathWeight;

    public SearchStatistics(){
        visitedNodes = -1;
        uniqueNodesVisited = -1;
        execTime = 0;
        visited = new HashSet<Integer>();
    }

    boolean wasVisited(int nodeid){
        return visited.contains(nodeid);
    }

}
