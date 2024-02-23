package com.TopInterview150;

public class RemoveDuplicatesSortedArray_26 {

    public static void main(String[] args) {
        int[] nums = {2,2,3,4,56,5,2};
       System.out.println( removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int i=0;
        try{
            for(int j=1;i<nums.length;j++){
                if(nums[i]!=nums[j]){
                    i++;
                    nums[i]=nums[j];

                }

            }

        }catch(Exception e){

        }
        return i+1;
    }
}

