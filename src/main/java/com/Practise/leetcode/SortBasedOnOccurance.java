package com.Practise.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class SortBasedOnOccurance {
    public static void main(String[] args) {

        int arr[] = new int[]{3,3,3,1,1,1,4,5,2};

        sortBasedOnOccurance(arr);
    }

    static void sortBasedOnOccurance(int []arr){
       //for primitive type it will create single value with comma seperated values
        List numList = Arrays.asList(arr);

       //it will actual create lit of element for primitive type
        List<Integer>numberList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println(numList+""+numberList);
        Map<Integer,Integer> map= new TreeMap<>();
        for(Integer i:numberList){
            map.put(i, Collections.frequency(numberList,i))  ;
        }
        System.out.println(map);

        ArrayList<Integer> b = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();

        map.entrySet().stream().sorted((k1, k2) -> k1.getValue().compareTo(k2.getValue()))
                .forEach(e -> {
                    a.add(e.getKey());
                    b.add(e.getValue());

                });
        System.out.println(a);
        System.out.println(b);


    }
}
