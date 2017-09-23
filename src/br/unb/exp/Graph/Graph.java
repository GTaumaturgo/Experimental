package br.unb.exp.Graph;

import java.util.ArrayList;

public class Graph {
    ArrayList<Node> vertices;
    int size;
    public Graph(int size){

        vertices = new ArrayList<>(size);
        this.size = size;
        for(int i = 0; i < size; i++){
            vertices.add(i,new Node());
            vertices.get(i).adjList = new ArrayList<Edge>();
        }
    }

    public int getSize(){return size;}

    public Node getNode(int nodeId){ return vertices.get(nodeId);}

    public void addEdge(int from, int to, double weight){
        vertices.get(from).adjList.add(new Edge(to,weight));
    }
}
