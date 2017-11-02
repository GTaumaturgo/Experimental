package br.unb.exp;

import br.unb.exp.Calculator.Calculator;
import br.unb.exp.Graph.Edge;
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

    private static String segundos(long execTime) {
        return (Double.toString(execTime / 1e9)) + " segundos";
    }

    public static void main(String[] args) {
        int k = 3;
        Graph h = new Graph(264346);
        HashMap<Integer,Coordinate> coordinates = new HashMap<>();

        le_arquivos(h,coordinates);
        SearchStatistics st;




        ArrayList<SearchStatistics> resBFS = new ArrayList<>();
        ArrayList<SearchStatistics> resUCS = new ArrayList<>();
        ArrayList<SearchStatistics> resGS = new ArrayList<>();
        ArrayList<SearchStatistics> resAS = new ArrayList<>();

        HashSet<Integer> nodes = new HashSet<Integer>();
        Random r = new Random();


        while(nodes.size() < 5){
            int a;
            do{

                a = r.nextInt(264346);

            }while(nodes.contains(a));

            int u = a;
            UniformCostSearch ucsAux = new UniformCostSearch(h,coordinates);
            ucsAux.buscaAux(u,-1);
            st = ucsAux.getStatistics();
            printa(st.heuristicMaxError);
            ArrayList<Integer> km5 = new ArrayList<>();
            ArrayList<Integer> km15 = new ArrayList<>();
            ArrayList<Integer> km50 = new ArrayList<>();
            ArrayList<Integer> km50mais = new ArrayList<>();

            printa(u);
            for (int i = 0; i < h.getSize(); i++) {
                if(i == u) {
                    continue;
                }
                if(st.bestPath.get(i) <= 5000.0) {
                    km5.add(km5.size(),i);
                }
                else if(st.bestPath.get(i) <= 15000.0) {
                    km15.add(km15.size(),i);
                }
                else if(st.bestPath.get(i) <= 50000.0) {
                    km50.add(km50.size(),i);
                }
                else
                    km50mais.add(km50mais.size(),i);
            }

            if(km5.size() < 3)
                continue;
            HashSet<Integer> aux = new HashSet<>();
            do{
                aux.add(r.nextInt(km5.size()));
            }while(aux.size() < k);


            BreadthFirstSearch bfs = new BreadthFirstSearch(h);
            UniformCostSearch ucs = new UniformCostSearch(h);
            GreedySearch gs = new GreedySearch(h,coordinates);
            AStarSearch as = new AStarSearch(h,coordinates,st.heuristicMaxError);

            for(Integer v: aux){
                bfs.buscaAux(u,v);
                resBFS.add(bfs.getStatistics());
                ucs.buscaAux(u,v);
                resUCS.add(ucs.getStatistics());
                gs.buscaAux(u,v);
                resGS.add(gs.getStatistics());
                as.buscaAux(u,v);
                resAS.add(as.getStatistics());
            }
            nodes.add(a);

        }








    }


}
