package com.AskedInInterview;

import java.util.*;

//Cognizant
public class OccuranceOfCharacterInString {

    //given string find occuranc eof each character in it
    //eg  String s ="aaabbcdd"
    /*   a 3 times, b two times, c one time, d two time  */

    public static void main(String []args){
        String s= "aaabbccccdd";
        linearWithMapSolution(s);

    }


    //quadratic On2 Exponential
    private static void solution1(String inputString){
        String []arr= inputString.split("");
        for(int i=0;i<arr.length;i++){
            int count=-1;
            for(int j=0;j<i;j++){
                if(arr[i].equals(arr[j]))
                    count = count+1;
            }
            System.out.println(arr[i]+" occured "+count);
            count=-1;
        }
    }

    //quadratic On2 Exponential
    private static void solution2(String inputString){
        String []arr= inputString.split("");
        List<String> strList = Arrays.asList(arr);
        List<String> processedValues = new ArrayList<String>();
        for(int i=0;i<strList.size();i++){
            if(!processedValues.contains(strList.get(i)))
            {int times= Collections.frequency(strList, strList.get(i));
                System.out.println(strList.get(i)+" occured "+times);
            }
            processedValues.add(strList.get(i));
        }
    }


    private static void linearWithMapSolution(String inputString){
        Map<Character, Integer> resultMap= new HashMap<>();

        for(Character s:inputString.toCharArray()){
            resultMap.put(s, resultMap.get(s)==null?1:resultMap.get(s)+1);
        }
        System.out.println(resultMap);
    }


}

    //select d.name,count(e)  from employee e, departemnt d where e.DId= d.id groupby department
