package aron.sinoai.interfacelambdastreamtest;

import java.util.List;

/**
 */
@FunctionalInterface
public interface IPriceCalculator {

    double calculate(List<Double> values);

}
