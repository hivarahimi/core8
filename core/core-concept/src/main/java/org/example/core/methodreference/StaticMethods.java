package org.example.core.methodreference;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;



public class StaticMethods {



    public static void main(String[] args) {
        List<String> names = Arrays.asList("mina","amir");
//        names.forEach(word-> StringUtils.capitalize(word));

        names.forEach(StringUtils::capitalize);
        names.forEach(System.out::println);

    }
}
