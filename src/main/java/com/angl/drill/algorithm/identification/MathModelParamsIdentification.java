package com.angl.drill.algorithm.identification;

import com.angl.drill.db.entity.DrillHole;
import com.angl.drill.db.entity.Excavation;
import com.angl.drill.db.entity.ExcavationSession;
import com.angl.drill.db.entity.Experiment;


import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Andrii on 01.02.2016.
 */
public class MathModelParamsIdentification {

    public static double RIGHT_LIMIT = 100;
    public static double LEFT_LIMIT = 0.0001;
    public static final double PRECISION = 0.00001;
    public static double START_WEAR_RATE = 1;
    public final static double PHI = (1 + Math.sqrt(5)) / 2;
    public static final int SIZE = 3;

    public static double equation(double x, double e_0, List<Excavation> race) {
        double result = 0;
        double part1 = delta_H_e_j_summary(x, e_0, race) / quadratic_sigma_j_summary(x, e_0, race);
        Excavation iter0 = race.get(0);
        long firstDate = race.get(0).getTime().getTime();
        for (int j = 1; j < race.size(); j++) {
            double delta_H_j = race.get(j).getExc() - iter0.getExc();
            double delta_t_j = ((double)TimeUnit.MILLISECONDS.toMinutes(race.get(j).getTime().getTime() - firstDate))/60;
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
            double delta_t_j = ((double)TimeUnit.MILLISECONDS.toMinutes(race.get(j).getTime().getTime() - firstDate))/60;
            summ = summ + delta_H_j * sigma_j(e_j(x, delta_t_j, e_0), e_0);
        }
        return summ;
    }

    public static double quadratic_sigma_j_summary(double x, double e_0, List<Excavation> race) {
        double summ = 0;
        Excavation iter0 = race.get(0);
        long firstDate = race.get(0).getTime().getTime();
        for (int j = 1; j < race.size(); j++) {
            double delta_t_j = ((double)TimeUnit.MILLISECONDS.toMinutes(race.get(j).getTime().getTime() - firstDate))/60;
            summ = summ + Math.pow(sigma_j(e_j(x, delta_t_j, e_0), e_0), 2);
        }
        return summ;
    }

    public static double findSpeed(double k_e, double e_0, List<Excavation> race) {
        return k_e * (delta_H_e_j_summary(k_e, e_0, race) / quadratic_sigma_j_summary(k_e, e_0, race));
    }

    public static List<ExcavationSession> findMathModelParams(List<ExcavationSession> testRuns, Experiment experiment, DrillHole drillHole) {
        System.out.println("Start");
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
                long t_end = testRunExcavations.get(testRunExcavations.size() - 1).getTime().getTime();
                double v = findSpeed(c, e_0, testRunExcavations);
                testRun.setWearRate(c);
                testRun.setDrillSpeed(v);
                e_0 = e_0 + c * (((double)TimeUnit.MILLISECONDS.toMinutes(t_end - t_start))/60);

//                double c_b = 46;
                //double t_sp = 7;
                double d = drillHole.getBitCost();// example 132

                double e = findEMinimizingCost(experiment, testRun, drillHole);
                System.out.println("e "+e);
                System.out.println("c " + c);
                testRun.setPredictableDrillTime(e - 1 / c);
                System.out.println("cost"+findCost(e, experiment, testRun, drillHole));
                testRun.setPredictableCost(findCost(e, experiment, testRun, drillHole));

                System.out.println("setPredictableCost" + testRun.getPredictableCost());
//                double alfa = 0.6;
//                double beta = 1;
//                double F = testRun.getBitLoad();
//                double n = 120;
//                double A = 0.001;
//                double t = Math.pow(F, alfa) * Math.pow(n, beta);
            } else {//if smth goes wrong

            }
        }
        //findOptimumBitLoad(experiment, testRuns);
        return testRuns;
    }


    public static double findEMinimizingCost(Experiment experiment, ExcavationSession es, DrillHole drillHole) {
        double x1, x2;
        double a = LEFT_LIMIT;
        double b = RIGHT_LIMIT;
        while (true) {
            x1 = b - (b - a) / PHI;
            x2 = a + (b - a) / PHI;
            if (findCost(x1, experiment, es, drillHole) >= findCost(x2, experiment, es, drillHole))
                a = x1;
            else
                b = x2;
            if (Math.abs(b - a) < PRECISION)
                break;
        }
        return (a + b) / 2;
    }

    public static double findCost(double x, Experiment exp, ExcavationSession es, DrillHole drillHole) {
        double tau = drillHole.getDescAscTime() + drillHole.getBitCost() / drillHole.getCostPerHour();
        return (drillHole.getCostPerHour() * (x - 1 + es.getWearRate() * tau)) / (es.getDrillSpeed() * Math.log(x));
    }

    public static Experiment findOptimumBitLoad(Experiment experiment, List<ExcavationSession> testRuns) {
        double[][] matrix = new double[SIZE][SIZE + 1];
        for (int i = 0; i < SIZE; i++) {
            matrix[i][0] = 1;
            matrix[i][1] = testRuns.get(i).getBitLoad();
            matrix[i][2] = Math.pow(testRuns.get(i).getBitLoad(), 2);
            matrix[i][3] = testRuns.get(i).getPredictableCost();
        }
        double[] previousVariableValues = new double[3];
        for (int i = 0; i < SIZE; i++) {
            previousVariableValues[i] = 0.0;
        }
        // Будем выполнять итерационный процесс до тех пор,
        // пока не будет достигнута необходимая точность
        while (true) {
            // Введем вектор значений неизвестных на текущем шаге
            double[] currentVariableValues = new double[SIZE];

            // Посчитаем значения неизвестных на текущей итерации
            // в соответствии с теоретическими формулами
            for (int i = 0; i < SIZE; i++) {
                // �?нициализируем i-ую неизвестную значением
                // свободного члена i-ой строки матрицы
                currentVariableValues[i] = matrix[i][SIZE];

                // Вычитаем сумму по всем отличным от i-ой неизвестным
                for (int j = 0; j < SIZE; j++) {
                    // При j < i можем использовать уже посчитанные
                    // на этой итерации значения неизвестных
                    if (j < i) {
                        currentVariableValues[i] -= matrix[i][j] * currentVariableValues[j];
                    }

                    // При j > i используем значения с прошлой итерации
                    if (j > i) {
                        currentVariableValues[i] -= matrix[i][j] * previousVariableValues[j];
                    }
                }

                // Делим на коэффициент при i-ой неизвестной
                currentVariableValues[i] /= matrix[i][i];
            }

            // Посчитаем текущую погрешность относительно предыдущей итерации
            double error = 0.0;

            for (int i = 0; i < SIZE; i++) {
                error += Math.abs(currentVariableValues[i] - previousVariableValues[i]);
            }

            // Если необходимая точность достигнута, то завершаем процесс
            System.out.println("error" + error);
            if (error < PRECISION) {
                break;
            }

            // Переходим к следующей итерации, так
            // что текущие значения неизвестных
            // становятся значениями на предыдущей итерации
            previousVariableValues = currentVariableValues;
        }

        double optimumBitLoad = -0.5 * (previousVariableValues[1] / previousVariableValues[2]);
        double predictableCost = previousVariableValues[0] - (0.5 * previousVariableValues[1]) / optimumBitLoad;
        experiment.setOptimumBitLoad(optimumBitLoad);
        experiment.setPredictableDrillCost(predictableCost);
        return experiment;
    }
}