package aron.sinoai.interfacelambdastreamtest;

import java.util.List;

/**
 */
@FunctionalInterface
public interface INamedPriceCalculator {

    double calculate(List<Double> values);

    // default method - note the keyword default
    default String getName(){
        return "Hello calculator";
    }

}
