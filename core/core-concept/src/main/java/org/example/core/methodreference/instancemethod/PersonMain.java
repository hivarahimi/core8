package org.example.core.methodreference.instancemethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PersonMain {
    public static void main(String[] args) {
        List<Person> students= Arrays.asList(
                new Person("mahtab",21),
                new Person("ziba",20),
                new Person("ali",24),
                new Person("mobin",22)
        );
        ComparisonProvider comparisonProvider = new ComparisonProvider();
        students.sort(comparisonProvider::compareByName);//Reference to an instance method of a particular object:
        students.forEach(System.out::println);
    }
}
