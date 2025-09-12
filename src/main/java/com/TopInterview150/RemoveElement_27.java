package com.TopInterview150;

/*public class RemoveElement_27 {

    public static void main(String[] args) {

        int[] nums = {2,2,3,4,56,5,2};
        int val = 2;
        System.out.println(removeElement(nums, val));
    }

     static int removeElement(int[] nums, int val){
         int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[count]= nums[i];
                count++;
            }
        }
        return count;
    }




}*/

import java.util.Arrays;
import java.util.Collections;

class RemoveElements_27 {
    public static int removeElement(int[] nums, int val) {
        Integer[] outputNums = Arrays.stream( nums ).boxed().toArray( Integer[]::new );
        int k=0;
        for(int i=0;i<outputNums.length;i++){
            if(outputNums[i]!=val)
                k++;
        }

        int  i=0;
        while(i<outputNums.length){
            if(outputNums[i]==val){
                outputNums[i]=outputNums[i]-val;

            }
            i++;
            //Arrays.sort()
        }
        Arrays.sort(outputNums, Collections.reverseOrder());

        for(int l=0;l<outputNums.length;l++){
            nums[l] = outputNums[l];
        }


        return k;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,3,4,56,5,2};
        int val = 2;
        System.out.println(removeElement(nums, val));
    }
}
