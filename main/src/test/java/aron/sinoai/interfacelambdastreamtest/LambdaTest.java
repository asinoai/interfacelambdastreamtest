package aron.sinoai.interfacelambdastreamtest;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 */
public class LambdaTest {


    @Test
    public void simpleHelloPrinterTestJava7() {

        final IHelloPrinter printer = new IHelloPrinter() {
            @Override
            public void print() {
                System.out.println("Hello world printer!");
            }
        };


        printer.print();
    }


    @Test
    public void simpleHelloPrinterTest() {

        final IHelloPrinter printer = () -> System.out.println("Hello world printer!");


        printer.print();
    }

    @Test
    public void multiStatementPrinterTest() {

        final IHelloPrinter printer = () -> {
            System.out.println("Hello world printer!");
            System.out.println("Hello again!");
        };

        printer.print();
    }

    @Test
    public void simpleReturnValueTest() {

        //final IPriceCalculator calculator = (final List<Double> list) -> 3.14;
        final IPriceCalculator calculator = (list) -> 3.14;

        Assert.assertEquals("Expect 3.14!", 3.14, calculator.calculate(Arrays.asList(1.0, 2.0)), 0.0);
    }

    @Test
    public void returnValueTest() {

        final IPriceCalculator calculator = (list) -> {
            double result = 0.0;

            for(final Double item : list) {
                result += item;
            }

            return result;
        };

        Assert.assertEquals("Expect 3!", 3.0, calculator.calculate(Arrays.asList(1.0, 2.0)), 0.0);
    }

    @Test
    public void prebuiltTest() {

        final List<Double> doubles0 = convertIntegerToDouble(Arrays.asList(1, 2, 3), (item) -> (double) item * 2);

        Assert.assertEquals("Expect 6!", 6.0, doubles0.get(2), 0.0);

        final List<Double> doubles1 = convertIntegerToDouble(Arrays.asList(1, 2, 3), LambdaTest::conversion1);

        Assert.assertEquals("Expect 6!", 6.0, doubles1.get(2), 0.0);

        delta = 3.0;
        final List<Double> doubles2 = convertIntegerToDouble(Arrays.asList(1, 2, 3), this::conversion2);

        Assert.assertEquals("Expect 6!", 6.0, doubles2.get(2), 0.0);
    }


    private List<Double> convertIntegerToDouble(final List<Integer> list, final Function<Integer, Double> conversion) {
        final List<Double> result = new ArrayList<>(list.size());

        for (final Integer item : list) {
            result.add(conversion.apply(item));

        }

        return  result;
    }

    private static double conversion1(final int value) {
        return value * 2;
    }

    private double delta;

    private double conversion2(final int value) {
        return value + delta;
    }


}
