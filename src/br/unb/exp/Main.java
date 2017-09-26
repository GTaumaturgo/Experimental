package br.unb.exp;

import br.unb.exp.Graph.Graph;
import br.unb.exp.search.BreadthFirstSearch;
import br.unb.exp.search.SearchStatistics;
import br.unb.exp.search.UniformCostSearch;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Main {


    static void printa(Object o){
        System.out.println(o.toString());
    }


    public static void main(String[] args) {

        // teste BFS
        Graph g = new Graph(4);
        g.addEdge(0,1,1.0);
        g.addEdge(1,2,1.0);
        g.addEdge(0,2,1.99);
        g.addEdge(2,3,1.0);
        g.addEdge(0,3,1000.0);
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.buscaAux(g,0,3);
        SearchStatistics statistics = bfs.getStatistics();
        printa(statistics.pathWeight);
        UniformCostSearch ucs = new UniformCostSearch();
        ucs.buscaAux(g,0,3);
        SearchStatistics st = ucs.getStatistics();
        printa(st.pathWeight);


        Graph h = new Graph(264346);

        String prefix = "files/";
        String coord = "USA-road-d.NY.co";
        String graph = "USA-road-d.NY.gr";
        HashMap<Integer,Coordinate> coordinates = new HashMap<>();
        try{

            File f = new File(prefix + coord);
            Scanner input = new Scanner(f);
            while(input.hasNext()){

                String s = input.next();// ignorar primeira letra
                int idx = input.nextInt();
                idx--;// indexado em 0
                double lon = input.nextDouble();
                lon /= 1000000; // precisa dividir por 100
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
                int w = input.nextInt();
                h.addEdge(a,b,(double)w);// TODO descobrir a unidade que ele dá essa distancia, porque a distanciad da heuristica ta vindo em metros e n pode misturar.

            }
            input.close();
        }
        catch (Exception e){printa(e.getMessage());}


        System.out.println(coordinates.get(0).longitude);









    }
}
