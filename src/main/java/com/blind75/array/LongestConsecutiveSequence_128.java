package com.blind75.array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LongestConsecutiveSequence_128 {

    /***
    * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
    * You must write an algorithm that runs in O(n) time.
    * Example 1:
    * Input: nums = [100,4,200,1,3,2]
    * Output: 4
    * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
    * Example 2:
    * Input: nums = [0,3,7,2,5,8,4,6,0,1]
    * Output: 9
    * Constraints:
    * 0 <= nums.length <= 105
    * -109 <= nums[i] <= 109
    * * */
    public static void main(String[] args) {
        int nums[] = new int []{0,3,7,2,5,8,4,6,0,1};
        //o/p=9
        int nums1[] = new int []{100,4,200,1,3,2};
        //o//p=4
        int nums3[] = new int[]{1,0,-1};
        System.out.println(longestConsecutiveSubsequence(nums)); //O (nLogN) as Arrays/collections .sort() uses quick sort algo
        System.out.println(longestConsecutiveSubsequence(nums1));
        System.out.println("**************************************");
        System.out.println(longestConsecutive(nums));
        System.out.println(longestConsecutive(nums1));
        System.out.println(longestConsecutive(nums3));
    }

    private static int longestConsecutiveSubsequence(int[] nums) {
        Arrays.sort(nums);
       // System.out.println(Arrays.toString(nums));
        int i=0;
        int count=1;

        while(Math.abs(nums[i]-nums[i+1]) ==1
                && nums[i]!=nums[i+1]){
            count++;
            i++;
        }
        return count;
    }
    private static int longestConsecutive(int[] nums) {
        //int[] to set ways
       // will set all array in index 0 Set<Integer> set= new HashSet(Arrays.asList(nums));
       // will set all array in index 0 (immutable) Set<int[]> set1= Set.of(nums);
       // will set all array in index 0 Set<Integer> set= Stream.of(nums).collect(Collectors.toCollection(HashSet::new));
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int count=1;
        Map<Integer,Integer> map= new HashMap<>();
        List<Integer> lst= new ArrayList<>();
        //int max=Integer.MIN_VALUE;
        for(Integer element:set){

            if(!set.contains(element-1)){
                //count=1;
                //if(map.get(element)==null) {
                    map.put(element, count);
               // }
            }
            if(set.contains(element+1)){
                //count++;
               // max=Math.max(count,max);
                map.put(element+1, map.get(element)!=null?(map.get(element)+1):1);
            }
        }
        //return Stream.of(map.values().stream().max((o1, o2) -> o1.compareTo(o2))).findFirst().get().get();

        return map.entrySet().stream().max(Map.Entry.comparingByValue()).isPresent()?
                map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue():
                0;
    }
}
