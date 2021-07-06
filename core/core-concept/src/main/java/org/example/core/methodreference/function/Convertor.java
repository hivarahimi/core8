package org.example.core.methodreference.function;

import com.sun.source.tree.BreakTree;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.function.Function;

public class Convertor {

    public static Integer getLength(String word){
        return word.length();
    }


    public static  <T,R> Map<T,R> convertListToMap(Set<T> set, Function<T,R> func){

        Map<T, R> result = new HashMap<>();
        set.forEach(word->result.put(word,func.apply(word)));
        return result;
    }

    public static <T>List<T> convertToCapitalList(List<T> list,Function<T,T> function){

        List<T> result = new ArrayList<>();

        list.forEach(word->result.add(function.apply(word)));
        return result;

    }
}
