package com.Practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RemoveDuplicateFromArray {
public static void main(String[]args){
    Integer tarr[]= new Integer[]{2,3,5,76,76};
    int []arr= new int[]{3,3,4,5,5,5,9,9,10,10};

    Solution solution= new Solution();

    System.out.println(solution.removeDuplicates(arr));//leetcode solution

    //System.out.println(solution.removeDuplicates(tarr));

}



static class Solution{


    public int removeDuplicates(int[] nums) {

        //using two pointers or reference to number in array
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public int removeDuplicates(Integer[] nums) {
      //  int nums1[] = nums;

        List<String> lsInt= new ArrayList(Arrays.asList(nums));
       // List<Integer> lsInt = Arrays.asList(nums);
       /*
       The List returned by Arrays.asList method of java.util.Arrays class is a fixed-size list object which means that elements cannot be added to or removed from the list.

        So functions like Adding or Removing cannot be operated on such kind of Lists.

        The solution to adding or removing without getting java.lang.UnsupportedOperationException is ->

        List<String> strList= new ArrayList<>(Arrays.asList(strs));

        //Then Add or Remove can be called on such List

        newList.add("100");
        newList.remove("100");
        */

       for (int i = 0; i < nums.length; i++) {
            int times = Collections.frequency(lsInt, nums[i]);
            if (times > 1) {
                lsInt.remove(i);
            }
        }
        return lsInt.size();
    }

}

}
