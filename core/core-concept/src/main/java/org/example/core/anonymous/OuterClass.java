package org.example.core.anonymous;

public class OuterClass { //Top level class
    //region inner class
    public static class InnerClassA { // static inner class
        public void getInA() {
            System.out.println("a");
        }

        public static String getClassName() {
            return InnerClassA.class.getName();
        }
    }

    protected class InnerClassB { //inner class
        public void getInB() {
            System.out.println("B");
        }
    }

    private class InnerClassC {
        public void getInC() {
            System.out.println("C");
        }
    }

    public void display() {
        System.out.println(InnerClassA.getClassName());
        new InnerClassC().getInC();
    }

    //endregion

    //region Method–Local inner classes
    public void sample(){
        String localVar=" lv";
        class InnerMethodClass{
            final String name;

            InnerMethodClass(String name1) {
                name = name1;
            }

            private void myMethod(){
                System.out.println("inner class in method 1 "+name +localVar);
            }
            public void MyMethod2(){
                System.out.println("inner class in method 2"+localVar);
            }
        }
        InnerMethodClass innerMethodClass = new InnerMethodClass("mina");
        innerMethodClass.myMethod();
    }
    //endregion

    //region Anonymous Inner Classes
    public void sampleAnonymous(){
        InnerClassForAnonymous inner = new InnerClassForAnonymous(){
            @Override
            public String show() {
                return "in inner class ";
            }
        };
        inner.show();
    }
    //endregion

    //region Static Nested Classes
    static class Nested{

    }
    //endregion

}
