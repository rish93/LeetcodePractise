package com.Practise.AmazonTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AmazonInterviewHackerrank {

    public static void main(String[] args) {

    }


    public static List<String> processLogs(List<String> logs, int threshold) {
        List<String> result= new ArrayList<>();
        // Write your code here
        Map<String, Integer> mapResult = new HashMap<>();
        for(String log : logs){
            String[]tempArr = log.split(" ");

            for(int i=0;i<2;i++){
                mapResult.put(tempArr[i],
                        mapResult.get(tempArr[i])!=null ?
                                mapResult.get(tempArr[i])+1:
                                1);
            }

        }

        result = mapResult.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .filter(s-> s.getValue()>=threshold)
                .map(mapTemp-> String.valueOf(mapTemp.getKey()))
                .collect(Collectors.toList());

        return  result;

    }

}

