package com.TopInterview150;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement_169 {

    public static void main(String[] args) {

        int []nums = {2,4,2,2,4,4,5,5,2,4,4};
       System.out.println(majorityElementWithHashMap(nums));
        System.out.print(" "+majorityElementWithMooresVotingAlgorithm(nums));
    }

    public static int majorityElementWithHashMap(int[] nums) {
//        Map<Integer, Integer> map= new HashMap<>();
//        for(int i=0;i<nums.length;i++){
//            if(map.get(nums[i])!=null){
//                map.put(nums[i],map.get(nums[i])+1);
//            }else{
//                map.put(nums[i],map.get(nums[i])+1);
//            }
//        }
//      return map.size();
//
        return 0;
    }


    public static int majorityElementWithMooresVotingAlgorithm(int[] nums) {
        int count = 0;
        int ele = 0;
            for(int i=0;i<nums.length;i++){
                if(count == 0){
                    ele = nums[i];
                }
                if(ele != nums[i]){
                    count--;
                }else {
                    count++;
                }
            }
            System.out.print("Majority element ");
        return ele;
    }


}
