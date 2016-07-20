package aron.sinoai.interfacelambdastreamtest;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.stream.Collectors;

/**
 */
public class StreamTest
{
    @Test
    public void simpleTest() {
        List<Fruit> fruitList = Arrays.asList(
                new Fruit("apple", 1.0),
                new Fruit("pear", 2.0),
                new Fruit("banana", 3.5)
        );

        long count = fruitList.stream()
                .filter((item) -> !item.getName().equals("apple"))
                .count();

        Assert.assertEquals("2 filtered items", 2l, count);
    }


    @Test
    public void sumTest() {
        List<Fruit> fruitList = Arrays.asList(
                new Fruit("apple", 1.0),
                new Fruit("pear", 2.0),
                new Fruit("banana", 3.5)
        );

        double sum = fruitList.stream()
                .map(Fruit::getPrice)
                .reduce(0.0, Double::sum);

        Assert.assertEquals("Sum", 6.5, sum, 0);
    }


    @Test
    public void collectTest() {
        List<Fruit> fruitList = Arrays.asList(
                new Fruit("apple", 1.0),
                new Fruit("pear", 2.0),
                new Fruit("banana", 3.5)
        );

        List<Fruit> sorted = fruitList.stream()
                .sorted(Comparator.comparing(Fruit::getName))
                .collect(Collectors.toList());

        Assert.assertEquals("Pear is the last one", "pear", sorted.get(2).getName());

    }

}
