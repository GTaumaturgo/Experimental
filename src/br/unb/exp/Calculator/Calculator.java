package br.unb.exp.Calculator;

import java.util.ArrayList;

public class Calculator {
    public double CalculateStdDeviation(ArrayList<Double> list){
        double mean = CalculateMean(list);
        // terminar dps pq nao lembro rsrs
        return 0.0;
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
