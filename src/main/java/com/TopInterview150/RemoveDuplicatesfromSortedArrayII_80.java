package com.TopInterview150;

public class RemoveDuplicatesfromSortedArrayII_80 {

    public static void main(String[] args) {
            int []nums= {1,2,2,4,4,4,6,7,7,7};

            //o/p = {1,2,2,4,4,6,7,7}  8
         System.out.println(removeDuplicateFromSortedArray1(nums));
    }


    static int removeDuplicateFromSortedArray1(int []nums){
        int count =0;
        for (final int num : nums){
            //add initial 2elements as it is , then check from third to 2 element prior if it is less than
            //current elment (as they are in assending order)
            if(count < 2 || num > nums[count-2] ){
                nums[count++] = num;
            }
        }
        return count;
    }

}
