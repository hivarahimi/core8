package org.example.core.anonymous;

public class OuterClassMain {
    public static void main(String[] args) {
        OuterClass o = new OuterClass();

        //Instantiating an inner class from outside the outer class Instance Code
        OuterClass.InnerClassB b= new OuterClass().new InnerClassB();
        b.getInB();

        o.display();
        OuterClass.InnerClassA a = new OuterClass.InnerClassA();
        a.getInA();

        o.sample();// inner class in method

        OuterClass.Nested n = new OuterClass.Nested(); // nested static class
    }
}
