package br.unb.exp;

import br.unb.exp.Calculator.Calculator;
import br.unb.exp.Graph.Graph;
import br.unb.exp.search.*;

import java.io.File;
import java.util.*;

public class Main {


    private static void printa(Object o){
        System.out.println(o.toString());
    }

    public static void le_arquivos(Graph h,HashMap<Integer,Coordinate> coordinates){
        String prefix = "files/";
        String coord = "USA-road-d.NY.co";
        String graph = "USA-road-d.NY.gr";
        try{

            File f = new File(prefix + coord);
            Scanner input = new Scanner(f);
            while(input.hasNext()){

                String s = input.next();// ignorar primeira letra
                int idx = input.nextInt();
                idx--;// indexado em 0
                double lon = input.nextDouble();
                lon /= 1000000; // precisa dividir por 10^6
                double lat = input.nextDouble();
                lat /= 1000000;

                coordinates.put(idx, new Coordinate(lat,lon));
            }
            input.close();
        }
        catch (Exception e){printa("arquivo n encontrado");}

        try{

            File f = new File(prefix + graph);
            Scanner input = new Scanner(f);
            while(input.hasNext()){
                String s = input.next();
                int a = input.nextInt();
                int b = input.nextInt();
                a--;
                b--;//indexado em 0
                double w = input.nextDouble();
                w /= 10.0;
                h.addEdge(a,b,w);
            }
            input.close();
        }
        catch (Exception e){printa(e.getMessage());}
    }

    public static void main(String[] args) {

        Graph h = new Graph(264346);
        HashMap<Integer,Coordinate> coordinates = new HashMap<>();

        le_arquivos(h,coordinates);
        SearchStatistics st;


//        System.out.println("Breadth First Search:");
//        BreadthFirstSearch bfs = new BreadthFirstSearch(h);
//        bfs.buscaAux(0,3);
//        st = bfs.getStatistics();
//        printa("\tPath weight = " + st.pathWeight);
//        printa("\tNodes visited = " + st.visitedNodes);
//
//        System.out.println("Uniform Cost Search:");
//        UniformCostSearch ucs = new UniformCostSearch(h);
//        ucs.buscaAux(0,2);
//        st = ucs.getStatistics();
//        printa(st.bestPath.get(0));
//        printa(st.bestPath.get(1));
//        printa(st.bestPath.get(2));
//        printa("\tPath weight = " + st.pathWeight);
//        printa("\tNodes visited = " + st.visitedNodes);

//
//        System.out.println("Greedy Search:");
//        GreedySearch gs = new GreedySearch(h,coordinates);
//        gs.buscaAux(0,3);
//        st = gs.getStatistics();
//        printa("\tPath weight = " + st.pathWeight);
//        printa("\tNodes visited = " + st.visitedNodes);
//
//        System.out.println("A* Search:");
//        AStarSearch as = new AStarSearch(h,coordinates);
//        as.buscaAux(0,3);
//        st = as.getStatistics();
//        printa("\tPath weight = " + st.pathWeight);
//        printa("\tNodes visited = " + st.visitedNodes);

        HashSet<Integer> nodes = new HashSet<Integer>();
        Random r = new Random();

        for (int i = 0; i < 5; i ++){
            int a;
            do{
                a = r.nextInt(264346);
            }while(nodes.contains(a));
            nodes.add(a);
        }

        UniformCostSearch ucs = new UniformCostSearch(h,coordinates);
        ucs.buscaAux(11201,-1);
        st = ucs.getStatistics();
        printa(st.heuristicMaxError);
        printa( segundos(st.execTime));



    }

    private static String segundos(long execTime) {
        return (new Double(execTime / 1e9).toString()) + " segundos";
    }
}
