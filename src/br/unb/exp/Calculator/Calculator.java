package br.unb.exp.Calculator;

import br.unb.exp.Coordinate;

import java.util.ArrayList;

public class Calculator {

    public double calculateStdDeviation(ArrayList<Double> list){
        double mean = calculateMean(list);
        double acc = 0.0;
        for(int i = 0; i < list.size(); i++){
            double aux = (mean - list.get(i));
            acc += aux*aux;
        }


        return Math.sqrt(acc);
    }

    public double calculateMean(ArrayList<Double> list)
    {
        double acc = 0;
        for (int i = 0; i < list.size();i++){
            acc += list.get(i);
        }
        return acc / list.size();
    }

    public double calculateDistance(Coordinate u, Coordinate v){
        final double R = 6371.0;
        double deltaLat = Math.toRadians(v.latitude - u.latitude);
        double deltaLon = Math.toRadians(v.longitude - u.longitude);
        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2)
                + Math.cos(Math.toRadians(u.latitude)) * Math.cos(Math.toRadians(v.latitude))
                * Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters
        return distance;

    }
}
