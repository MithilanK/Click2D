package com.mithilank.libClick.math;

public class OptimizedStuff {
    public static double Q_rsqrt(double number){
        double x = number;
        double xhalf = 0.5d*x;
        long i = Double.doubleToLongBits(x);
        i = 0x5fe6ec85e7de30daL - (i>>1);
        x = Double.longBitsToDouble(i);
        for(int it = 0; it < 4; it++){
            x = x*(1.5d - xhalf*x*x);
        }
        x *= number;
        return x;
    }
}
