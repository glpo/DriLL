package com.angl.drill.algorithm.layer;

import com.angl.drill.db.entity.Excavation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrii on 30.01.2016.
 */
public class LayersChangingIdentification {
    // Метод_Ньютона.cpp: определяет точку входа для консольного приложения

    public static double RIGHT_LIMIT = 100;
    public static final double PRECISION = 0.00001;

    public static double f(double x, double l, double t, double tprev) //возвращает значение функции f(x) = x^2-2
    {
        return Math.pow((1 + x * tprev), l) - x * t - 1;
    }

    public static double df(double x, double l, double t, double tprev) //возвращает значение производной
    {
        return l * Math.pow((1 + x * tprev), l - 1) * tprev - t;
    }

    public static double d2f(double x, double l, double t, double tprev) // значение второй производной
    {
        return l * (l - 1) * tprev * tprev * Math.pow((1 + x * tprev), l - 2);
    }

    public static boolean idefPlast(List<Excavation> excavations) {
        List<Double> ke = new ArrayList<Double>();
        double ksred;
        double a;
        double t0;
        double t1;
        double l;
        double x0, xn;// вычисляемые приближения для корня
        Excavation firstExc = excavations.get(0);
        long firstDate = firstExc.getTime().getTime();
        double firstExcavation = firstExc.getExc();
        Excavation iter;
        double Gt = 0;
        for (int i = 1; i < excavations.size(); i++) {
            iter = excavations.get(i);
            double currentDeltaTime = ((iter.getTime().getTime() - firstDate) / (60 * 1000) % 60) / 60;
            double prevDeltaTime = ((firstExc.getTime().getTime() - firstDate) / (60 * 1000) % 60) / 60;
            double currentDeltaExcavation = iter.getExc() - firstExcavation;
            double prevDeltaExcavation = firstExc.getExc() - firstExcavation;
            a = -1 / currentDeltaTime;
            l = currentDeltaExcavation / prevDeltaExcavation;
            t1 = currentDeltaTime;
            t0 = prevDeltaTime;
            if (f(a, l, t1, t0) * d2f(a, l, t1, t0) > 0)
                x0 = a; // для выбора начальной точки проверяем f(x0)*d2f(x0)>0 ?
            else x0 = RIGHT_LIMIT;
            xn = x0 - f(x0, l, t1, t0) / df(x0, l, t1, t0); // считаем первое приближение
            while (Math.abs(x0 - xn) > PRECISION) // пока не достигнем необходимой точности, будет продолжать вычислять
            {
                x0 = xn;
                xn = x0 - f(x0, l, t1, t0) / df(x0, l, t1, t0); // непосредственно формула Ньютона
            }
            firstExc = iter;
            ke.add(xn);
            double keSred = getKeSred(ke);
            double keDispersia = getKeDispersia(ke, keSred);
            double gt = Math.pow(xn - keSred, 2);
            Gt = Math.sqrt(1 - (1 / i)) * Gt + (gt - keDispersia) / (Math.sqrt(2 * i) * keDispersia);
        }
        System.out.println("Gt= " + Gt);
        if (Gt > 2.5) return true;
        return false;
    }

    public static double getKeSred(List<Double> set) {
        double sum = 0;
        for (Double d : set) {
            sum += d;
        }
        return sum / set.size();
    }

    public static double getKeDispersia(List<Double> set, double KeSred) {
        double sum = 0;
        for (Double d : set) {
            sum += Math.pow(d - KeSred, 2);
        }
        return sum / set.size();
    }
}
