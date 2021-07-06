package org.example.core.anonymous;

/**
 *  anonymous inner class with two interface extend
 *  Implement two interfaces in an anonymous class
 */
public class MyClass {
    interface A{
        void displayA();
    }
    interface B{
        void displayB();
    }
    interface C extends A,B{
        void displayC();
    }

    public void displayItems(C c){
        c.displayA();
        c.displayB();
        c.displayC();
    }

    public static void main(String[] args) {
        MyClass m = new MyClass();
        m.displayItems(new C()  {
            @Override
            public void displayC() {
                System.out.println("IT IS C");
            }

            @Override
            public void displayA() {
                System.out.println("IT IS A");
            }

            @Override
            public void displayB() {
                System.out.println("IT IS B");
            }
        });
    }
}
