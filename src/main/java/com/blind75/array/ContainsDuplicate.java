package com.blind75.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*Given an integer array nums, return true if any value appears
 at least twice in the array, and return false if every element is distinct.



        Example 1:

        Input: nums = [1,2,3,1]
        Output: true
        Example 2:

        Input: nums = [1,2,3,4]
        Output: false
        Example 3:

        Input: nums = [1,1,1,3,3,4,3,2,4,2]
        Output: true*/
public class ContainsDuplicate {

    public static void main(String[] args) {

        System.out.println(containsDuplicate(new int[]{1,  3, 3, 4, 3, 2, 4, 2}));
        System.out.println(containsDuplicate(new int[]{1,2,3,4,5}));

        System.out.println(containsDuplicateByStreams(new Integer[]{1,2,3,4,5,5}));

    }

    public static Integer containsDuplicateByStreams(Integer []arr){
       return Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
               .entrySet()
               .stream()
               .filter(integerLongEntry -> integerLongEntry.getValue()>1L)
               .map(Map.Entry::getKey)
               .findFirst()
               .get();

    }
    public static boolean containsDuplicate(int[] nums) {

        Map<Integer, Integer> mapNums = new HashMap<>();
        int i = 0;
        for (Integer num : nums) {
            if (mapNums.containsKey(num))
                return true;

            mapNums.put(num, i++);

        }


        return false;
    }
}
