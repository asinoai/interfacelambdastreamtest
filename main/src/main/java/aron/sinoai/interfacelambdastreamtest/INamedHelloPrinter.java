package aron.sinoai.interfacelambdastreamtest;

/**
 */
@FunctionalInterface
public interface INamedHelloPrinter {

    void print();

    // default method - note the keyword default
    default String getName(){
        return "Hello Printer";
    }
}