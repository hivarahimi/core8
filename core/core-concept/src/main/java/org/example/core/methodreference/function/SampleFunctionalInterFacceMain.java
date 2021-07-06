package org.example.core.methodreference.function;

public class SampleFunctionalInterFacceMain {
    public static void main(String[] args) {
        SampleFunctionalInterFacce sa = (word)-> word.length();
        System.out.println(sa.getLength("hiva"));
    }
}
