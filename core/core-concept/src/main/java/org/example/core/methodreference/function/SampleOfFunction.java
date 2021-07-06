package org.example.core.methodreference.function;

import java.util.function.Function;

public class SampleOfFunction {

    public static void main(String[] args) {
        Function<String,Integer> fun= x->x.length();

        fun.apply("hiva");
    }
}
