package aron.sinoai.interfacelambdastreamtest;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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

        long count1 = fruitList.stream()
                .filter((item) -> !item.getName().equals("apple"))
                .count();

        Assert.assertEquals("2 filtered items", 2l, count1);
    }

}
