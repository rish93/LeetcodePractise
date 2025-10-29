package com.Practise;

import java.util.*;

public class HappiestMind {
    //Jpa vs crud
    //compketable future vs futurte
    //verisoning in api
    //hashcollision
//    web server vs application server
    //intercepter vs filter
    //how to extrasct jwt token i confiug
    public static void main(String[] args) {
        /*program to find common prefix of each word , flown , flower , flack
         */
        /*
        * \race condition in multithreading java*/
        List<String> inputList= List.of("lown","flower","flack");
        Map<Character, Integer> map= new HashMap<>();
        for(int i=0;i<inputList.size();i++) {
            char []chars = inputList.get(i).toCharArray();
            for(int j=0;j<chars.length; j++){
                map.put(chars[j], map.get(chars[j])!=null ?map.get(chars[j])+1 : 1);
            }
        }

        for(Map.Entry<Character, Integer> entry: map.entrySet()){
                if(entry.getValue() == inputList.size())
                    System.out.print(entry.getKey());
        }






//        Set<Character> set = new LinkedHashSet<>();
//        //char []chars = inputList.get(i).toCharArray();
//        int index=0;
//        for(int i=0;i<inputList.size();i++){
//            if(!set.contains(inputList.get(i).charAt(index))) {
//                set.add(inputList.get(i).charAt(index));
//                index++;
//            }else
//                break;
//        }
//        System.out.println(set);
    }
}
