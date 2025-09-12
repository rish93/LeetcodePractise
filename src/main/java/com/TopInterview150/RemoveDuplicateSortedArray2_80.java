package com.TopInterview150;

public class RemoveDuplicateSortedArray2_80 {


    public static void main(String[] args) {

        int[] nums = {2,2,2,3,4,56,5};// Input array
        int[] expectedNums = {2,2,3,4,5,56}; // The expected answer with correct length

        int k = removeDuplicates(nums); // Calls your implementation


        System.out.println(k==expectedNums.length);
//        assert k == expectedNums.length;
//        for (int i = 0; i < k; i++) {
//            assert nums[i] == expectedNums[i];
//        }

//        int[] nums = {2,2,3,4,56,5,2};
//        System.out.println( removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2){
            return n;
        }
        int idx = 2;
        for (int i = 2; i < n; i++) {
            if (nums[i] != nums[idx - 2]) {
                nums[idx] = nums[i];
                idx++;
            }
        }
        return idx;

    }
}
