package com.Practise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SynechronInterview {


    public static void main(String[] args) {
//        1) List<Integer> list = {3,4,7,1,2,9,8,10,5,3,2}
//        Output:
//        1. Get the sum of all distinct odd Integers > 1 & < 9.

        //public double <T,T> testMethod(T val1, T val2);

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(7);
        list.add(2);
        list.add(10);

//      list.stream().filter(s->s%2!=0 && s>1&& s<9).distinct().mapToInt(Integer::intValue).sum()
        int sum =list.stream().filter(s-> s%2!=0).mapToInt(Integer::intValue).sum();
        System.out.print(sum);

        System.out.println(list.stream().filter(s-> s%2!=0).collect(Collectors.summingInt(Integer::intValue)));

        //how to handle authentication in api gateway

        //generic methods
//        public double <T,T> testMethod(T val1, T val2);
//        public double <Double,Float> testMethod(T val1, T val2);
//        public double <T,T> testMethod(T val1, T val2);



    }
}
