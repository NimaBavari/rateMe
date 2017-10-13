package com.EnDATA;

import java.lang.*;

class Rating {

    double getResult(double smPoint, double trPoint, double atPoint){
        return Math.pow((smPoint + 1) * (trPoint + 1) * (atPoint + 1), 1.0 / 3.0) - 1;
    }
}