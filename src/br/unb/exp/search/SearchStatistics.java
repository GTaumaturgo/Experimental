package br.unb.exp.search;

import java.util.HashSet;

public class SearchStatistics {
    int visitedNodes;
    int uniqueNodesVisited;
    long execTime;
    HashSet<Integer> visited;
    public SearchStatistics(){
        visitedNodes = 0;
        uniqueNodesVisited = 0;
        execTime = 0;
        visited = new HashSet<Integer>();
    }


}
