package com.company.functionalinterface;


import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {


    public static void main(String[] args){
        //Function
        int increment = incrementByOne (0);
        System.out.println(increment);
        int increment2 = incrementByOneFunction.apply(2);
        System.out.println(increment2);

        int multipleBy10 = multipleBy10Function.apply(increment2);
        System.out.println(multipleBy10);

        Function<Integer, Integer> addBy1AndThenMultiplyBy10Function = incrementByOneFunction.andThen(multipleBy10Function);
        System.out.println(addBy1AndThenMultiplyBy10Function.apply(4));

        //BiFunction




    }
    BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyFunction = (numberInc, numberToMulti) -> (numberInc + 1) * numberToMulti;

    static Function<Integer, Integer> incrementByOneFunction = number-> number+1;
    static Function<Integer, Integer> multipleBy10Function = number -> number * 10;
    static int incrementByOne(int number){
        return number +1;
    }
    static int incrementByOneAndMultiply(int number, int numToMulti){
        return (number +1) * numToMulti;
    }
}
