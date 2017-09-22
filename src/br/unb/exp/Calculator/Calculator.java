package br.unb.exp.Calculator;

import java.util.ArrayList;

public class Calculator {

    public double CalculateStdDeviation(ArrayList<Double> list){
        double mean = CalculateMean(list);
        double acc = 0.0;
        for(int i = 0; i < list.size(); i++){
            double aux = (mean - list.get(i));
            acc += aux*aux;
        }


        return Math.sqrt(acc);
    }

    public double CalculateMean(ArrayList<Double> list)
    {
        double acc = 0;
        for (int i = 0; i < list.size();i++){
            acc += list.get(i);
        }
        return acc / list.size();
    }
}
