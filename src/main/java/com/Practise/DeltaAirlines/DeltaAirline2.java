package com.Practise.DeltaAirlines;

import java.util.*;
import java.util.stream.Collectors;

public class DeltaAirline2 {
    /* Given an array of strings strs, group the anagrams together.
      You can return the answer in any order.

      An Anagram is a word or phrase formed by rearranging the letters
      of a different word or phrase, typically using all the original letters exactly once.

      Example 1:

      Input: strs = ["eat","tea","tan","ate","nat","bat"]
      Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
      */
    public static void main(String[] args) {
        //List.of("eat","es");
        String[] strArr= new String[]{"eat","tea","tan","ate","nat","bat"}; //eatt, teab
        List<List<String>> resultList = new ArrayList<>();
        List<String> partialResult;
        for(int i=0;i<strArr.length;i++){
            int k=i+1;
            char[] chars= strArr[k==strArr.length?strArr.length-1:k].toCharArray();
            partialResult = new ArrayList<>();
            for(int j=0;j<chars.length;j++){

                if(strArr[i].indexOf(String.valueOf(chars[j])) ==-1)
                    break;
                else
                {
                    partialResult.add(strArr[i]);

                }
            }
            resultList.add(partialResult);
        }
       // Collections.frequency()
        System.out.println(resultList);


      System.out.println( processAnagram());


    System.out.println( processAnagramAscii());

            System.out.println(groupAnagram(strArr));

    }

    private static List<List<String>> groupAnagram(String[] strArr){
        List<List<String>> result= new ArrayList<>();
        List<String> tempResult=new ArrayList<>();
        Map<Integer,List<String>> map=new HashMap<>();
        // Group strings by their ASCII sum

        List<String> input= Arrays.asList(strArr);
        Map<Integer, List<String>> asciiSumMap = input.stream()
                .collect(Collectors.groupingBy(
                        DeltaAirline2::calculateAsciiSum
                ));
        result= asciiSumMap.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
        return result;
    }

    private static int calculateAsciiSum(String str) {
        return str.chars().sum();
    }

    private static String processAnagramAscii(){
        String[] strArr= new String[]{"eat","tea","tan","ate","nat","bat"}; //eatt, teab

        Map<Integer,List<String>> map=new HashMap<>();
        List<String> words = new ArrayList<>();
        for(int i=0;i<strArr.length;i++){
            char []charArr=strArr[i].toCharArray();
            int n=0;
            for(char c: charArr){
                n+=c;
            }
            if(map.get(n)!=null) {
                words.add(strArr[i]);
            } else
            {
                words= new ArrayList<>();
                words.add(strArr[i]);
            }

            map.put(n,words);
            n=0;
        }
        return map.toString();
    }
    private static String processAnagram(){
        String s="ate";    // map<> putting   key a, t e
        String s1="eta";   //map<>  containes key a || t ||e

        Map<Character,Integer> map=new HashMap<>();

        if(s.length()!=s1.length()){
            return "Not anagram";
        }
        char cArr[] =s.toCharArray();
        char cArr2[]=s1.toCharArray();
        for(char c: cArr){
            map.put(c,1);
        }

        for(char c: cArr2){
            if(map.get(c)!=null)
                map.put(c, map.get(c)!=null ? map.get(c)+1 : 0);
            else
                map.put(c,0);
        }
        return map.toString();
    }
}
