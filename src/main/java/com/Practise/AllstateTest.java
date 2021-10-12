package com.Practise;

import java.net.Inet4Address;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AllstateTest {

    public static void main(String[] args) {
            //I/P : AAAABBBB  O/P : ABABABAB
//@Transactional
//        String input="AAAABBBB";
//        StringBuilder output= new StringBuilder();
//        String []str=        input.split("");
//        int length =str.length-1;
//        for(int i=0;i<str.length;i++){
//            if(str[i].equals("A") )
//                output.append(str[i]);
//           else if(str[length].equals("B")){
//               output.append(str[length]);
//               length = length-i;
//            }
//        }//memory issue substring
//        System.out.print(output);

//   [3:28 PM] Shashi (Guest)
//        In an array [1,2,3,4,5,6]  filter the even numbers and add 1 to it

//        Integer [] arr = new Integer[]{1,2,3,4,5,6};
//        List<Integer> output= Arrays.stream(arr).filter(n-> n%2==0).map(integer -> integer+1).collect(Collectors.toList());
//        System.out.print(output);


        /*
        * First Non-repeated character in a String .
        * i/p shashi
        * o/p a
        * */

        String input = "shashi";
        Map<Character, Integer> mapOutput= new HashMap<>();
        char [] arr = input.toCharArray();

        for(char c: arr){
            mapOutput.put(c, mapOutput.get(c) == null ?1:mapOutput.get(c) +1);
        }
        System.out.print(mapOutput.entrySet().stream().filter(characterIntegerEntry -> characterIntegerEntry.getValue()==1).findFirst().get());


        /*Why use serializable with entities
        * If an entity instance is to be passed by value as a detached object (e.g., through a remote interface), the entity class must implement the Serializable interface.
         In practice, if our object is to leave the domain of the JVM, it'll require serialization.
         Each entity class consists of persistent fields and properties.
        * */

        /*
        * Compartor has two methods why it is called as functional Interface
        * */

    }
}

