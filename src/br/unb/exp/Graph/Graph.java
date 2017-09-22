package br.unb.exp.Graph;

import java.util.ArrayList;

public class Graph {
    ArrayList<Node> vertices;
    int size;
    public Graph(int size){
        vertices = new ArrayList<>(size);
        this.size = size;
    }

    public int getSize(){return size;}

    public Node getNode(int nodeId){
        return vertices.get(nodeId);
    }
}
