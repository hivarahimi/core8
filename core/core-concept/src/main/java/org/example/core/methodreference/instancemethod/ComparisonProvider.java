package org.example.core.methodreference.instancemethod;

public class ComparisonProvider {

    public int compareByName(Person person1,Person person2){
        return person1.getName().compareTo(person2.getName());
    }

    public int compareByAge(Person person1,Person person2){
        return person1.getAge().compareTo(person2.getAge());
    }
}
