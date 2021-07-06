package org.example.core.methodreference.function;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class ConvertorMain {
    public static void main(String[] args) {
        //region convertListToMap
        Set<String> set = new HashSet<>(Arrays.asList("man", "to"));

        Convertor.convertListToMap(set,x->x.length());
        Convertor.convertListToMap(set, String::length);
        Map<String, Integer> mapResult = Convertor.convertListToMap(set, Convertor::getLength);
        System.out.println(mapResult);
        //endregion
        //region convertToCapitalList

        List newList = Convertor.convertToCapitalList(Arrays.asList("sara","mina"), StringUtils::upperCase);
        System.out.println(newList);
    }
}
