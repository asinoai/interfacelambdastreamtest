package aron.sinoai.interfacelambdastreamtest;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 */

public class DefaultTest {

    @Test
    public void simpleTest() {
        final PrinterCalculator printerCalculator = new PrinterCalculator();
        printerCalculator.print();
        printerCalculator.calculate(Arrays.asList(1.0, 2.0, 3.0));
    }


    private static class PrinterCalculator implements INamedHelloPrinter, INamedPriceCalculator {

        @Override
        public double calculate(List<Double> values) {
            return 0;
        }

        @Override
        public void print() {
            System.out.println(getName());
        }

        @Override
        public String getName() {
            return "Hello printer calculator";
        }
    }
}
