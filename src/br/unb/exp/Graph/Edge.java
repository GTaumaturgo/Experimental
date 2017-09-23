package br.unb.exp.Graph;

public class Edge implements Comparable{
    public int to;
    public double weight;
    public Edge(int t,double w)
    {
        weight = w;
        to = t;
    }

    @Override
    public int compareTo(Object o) {
        Edge e = (Edge) o;
        Double d = this.weight;
        return d.compareTo(e.weight);
    }


}
