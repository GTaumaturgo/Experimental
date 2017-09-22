package br.unb.exp.search;

import java.util.HashSet;

public class SearchStatistics {
    int visitedNodes;
    int uniqueNodesVisited;
    long execTime;
    HashSet<Integer> visited;
    double pathWeight;

    public SearchStatistics(){
        visitedNodes = 0;
        uniqueNodesVisited = 0;
        execTime = 0;
        visited = new HashSet<Integer>();
    }

    boolean wasVisited(int nodeid){
        return visited.contains(nodeid);
    }

}
