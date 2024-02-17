package com.blind75.string;


import java.util.*;
//adobe
//nick white problem solve
//https://www.youtube.com/watch?v=3IETreEybaA
/*
Given a string s, find the length of the longest substring without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0
 */
public class LongestUniqueSubstring {


    public static void main(String []args){
    //    String input="aaabbcdc";
    //    String input ="pwwkew";   // 3
    //    String input="ababbb";
    //    String input="dvdf";   //3
          String input ="aabaab!bb";
    //    System.out.println("OUTPUT->  "+longestUniqueSubstring(input));
        System.out.println("OUTPUT->  "+longestUniqueSubstringLinearComplexity(input));


    }


    private static Integer longestUniqueSubstring(String input){
        List<Character> convList=new ArrayList<>();
        int max=0;
        for(Character c: input.toCharArray()){
            if(convList.contains(c)){
//                convList.remove(c);
                convList = convList.subList( convList.indexOf(c), convList.size()-1);
            }
            convList.add(c);   //
            if(convList.size()>max)
                max=convList.size();
        }
        return max;
    }



  private static Integer longestUniqueSubstringLinearComplexity(String s) {
    Set<Character> uniqueSet= new HashSet<>();
    int pointer_a = 0;
    int pointer_b = 0;
    int max = 0;

    if(s==null || s.isEmpty())
        return 0;

    char []charArray= s.toCharArray();
    while(pointer_b < charArray.length){

        if(!uniqueSet.contains(charArray[pointer_b])){
            uniqueSet.add(charArray[pointer_b]);
            max =  Math.max(max, uniqueSet.size());
            pointer_b++;
        }else{
            uniqueSet.remove(charArray[pointer_a]);
            pointer_a+=1;
        }
     }
    return max;
    }







//    int n = s.length(), ans = 0;
//    Map<Character, Integer> map = new HashMap<>(); // current index of character
//    // try to extend the range [i, j]
//    for (int j = 0, i = 0; j < n; j++) {
//      if (map.containsKey(s.charAt(j))) {
//        i = Math.max(map.get(s.charAt(j)), i);
//      }
//      ans = Math.max(ans, j - i + 1);
//      map.put(s.charAt(j), j + 1);
//    }
//    return ans;
//    }
}
