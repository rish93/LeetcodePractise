package com.Practise;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UKG {

    public static void main(String[] args) {
        Map<Integer,String> map= new HashMap<>();

        map.put(1,"ONE");
        map.put(7,"RISHABH");
        map.put(2,"TWO");
        map.put(3,"THREE");

        //list of string value sorted by order whose number is greater than 2

        List<String> ls=map.entrySet()
                .stream()
                .filter(m-> m.getKey()>2)
        //.map(Comparator.naturalOrder()).
                .map(m->m.getValue())
                .collect(Collectors.toList());
        System.out.println(ls);

    }
}

/*
*  //serializable
            //immuatble
            // trasnsacional
            * how internaly connecton workds in spring boot
            * ///spring bot benefit
            * //repostirotty benefit
            * //when to use immuatvboel class
            * * * * * *
* * */
