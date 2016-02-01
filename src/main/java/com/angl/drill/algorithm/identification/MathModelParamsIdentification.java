package com.angl.drill.algorithm.identification;

import com.angl.drill.db.entity.Excavation;
import com.angl.drill.db.entity.ExcavationSession;
import com.angl.drill.db.entity.Experiment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrii on 01.02.2016.
 */
public class MathModelParamsIdentification {

    public static double RIGHT_LIMIT = 100;
    public static double LEFT_LIMIT = 0.0001;
    public static final double PRECISION = 0.00001;
    public static double START_WEAR_RATE = 1;

    public static double equation(double x, double e_0, List<Excavation> race) {
        double result = 0;
        double part1 = delta_H_e_j_summary(x, e_0, race) / quadratic_sigma_j_summary(x, e_0, race);
        Excavation iter0 = race.get(0);
        long firstDate = race.get(0).getTime().getTime();
        for (int j = 1; j < race.size(); j++) {
            double delta_H_j = race.get(j).getExc() - iter0.getExc();
            double delta_t_j = ((race.get(j).getTime().getTime() - firstDate) / (60 * 1000) % 60) / 60;
            result = result + ((delta_H_j - part1 * sigma_j(e_j(x, delta_t_j, e_0), e_0)) *
                    (((x * delta_t_j * e_0) / e_j(x, delta_t_j, e_0)) - sigma_j(e_j(x, delta_t_j, e_0), e_0)));
        }
        return result;
    }

    public static double sigma_j(double e_j, double e_0) {
        return Math.log(e_j / e_0);
    }

    public static double e_j(double x, double delta_t_j, double e_0) {
        return x * delta_t_j + e_0;
    }

    public static double delta_H_e_j_summary(double x, double e_0, List<Excavation> race) {
        double summ = 0;
        Excavation iter0 = race.get(0);
        long firstDate = race.get(0).getTime().getTime();
        for (int j = 1; j < race.size(); j++) {
            double delta_H_j = race.get(j).getExc() - iter0.getExc();
            double delta_t_j = ((race.get(j).getTime().getTime() - firstDate) / (60 * 1000) % 60) / 60;
            summ = summ + delta_H_j * sigma_j(e_j(x, delta_t_j, e_0), e_0);
        }
        return summ;
    }

    public static double quadratic_sigma_j_summary(double x, double e_0, List<Excavation> race) {
        double summ = 0;
        Excavation iter0 = race.get(0);
        long firstDate = race.get(0).getTime().getTime();
        for (int j = 1; j < race.size(); j++) {
            double delta_t_j = ((race.get(j).getTime().getTime() - firstDate) / (60 * 1000) % 60) / 60;
            summ = summ + Math.pow(sigma_j(e_j(x, delta_t_j, e_0), e_0), 2);
        }
        return summ;
    }

    public static double findSpeed(double k_e, double e_0, List<Excavation> race) {
        return k_e * (delta_H_e_j_summary(k_e, e_0, race) / quadratic_sigma_j_summary(k_e, e_0, race));
    }

    public static List<ExcavationSession> findMathModelParams(List<ExcavationSession> testRuns,Experiment experiment) {
        double e_0 = START_WEAR_RATE;
        for (int i = 0; i < testRuns.size(); i++) {
            ExcavationSession testRun = testRuns.get(i);
            List<Excavation> testRunExcavations = testRun.getExcavation();
            double a = LEFT_LIMIT;
            double b = RIGHT_LIMIT;
            double f_c;
            double c;

            if (equation(a, e_0, testRunExcavations) > 0) {
                c = a;
                a = b;
                b = c;
            }
            int backdoor = 1;
            do {
                c = (a + b) / 2;
                f_c = equation(c, e_0, testRunExcavations);
                if (f_c > 0) {
                    b = c;
                } else {
                    a = c;
                }
                backdoor++;
            } while ((Math.abs(a - b) - PRECISION > 0 || Math.abs(f_c) > PRECISION) && backdoor < 1000);
            if (backdoor < 1000) {//if value is found
                long t_start = testRunExcavations.get(0).getTime().getTime();
                double t_end = testRunExcavations.get(testRunExcavations.size() - 1).getTime().getTime();
                double v = findSpeed(c, e_0, testRunExcavations);
                testRun.setWearRate(c);
                testRun.setDrillSpeed(v);
                e_0 = e_0 + c * (((t_end - t_start) / (60 * 1000) % 60) / 60);

                double c_b = 46;
                double d = experiment.getBitCost();// example 132
                double t_sp = 7;
                double q;
                double tau = t_sp + d / c_b;
                q = c_b * (e_0 - 1 + c * tau) / (v * Math.log(e_0));
                testRun.setPredictableCost(q);

                double alfa = 0.6;
                double beta = 1;
                double F = testRun.getBitLoad();
                double n = 120;
                double A = 0.001;
                double t = Math.pow(F, alfa) * Math.pow(n, beta);
            } else {//if smth goes wrong

            }
        }
        return testRuns;
    }

    //for future: find minimum
//    double findMin(double a, double b, double e){
//        double x1, x2;
//        while (true){
//            x1 = b - (b - a) / PHI;
//            x2 = a + (b - a) / PHI;
//            if (f(x1) >= f(x2))
//                a = x1;
//            else
//                b = x2;
//            if (Math.abs(b - a) < e)
//                break;
//        }
//        return (a + b) / 2;
//    }
}
