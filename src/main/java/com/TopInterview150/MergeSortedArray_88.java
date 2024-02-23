package com.TopInterview150;

import java.util.Arrays;

public class MergeSortedArray_88 {

/*
*
* You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

* Merge nums1 and nums2 into a single array sorted in non-decreasing order.

* The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
* To accommodate this, nums1 has a length of m + n, where the first m elements
*  denote the elements that should be merged, and the last n elements are set to
*  0 and should be ignored. nums2 has a length of n.



Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.


      Constraints:

      nums1.length == m + n
      nums2.length == n
      0 <= m, n <= 200
      1 <= m + n <= 200
     -109 <= nums1[i], nums2[j] <= 109


     Follow up: Can you come up with an algorithm that runs in O(m + n) time?


    *
    * */
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,0,0,0};
        int[] arr2 = {2,5,6};
        int m = 3;
        int n = 3;
        mergeSortedArrayWithExtraSpace(arr1, arr2, m , n);

        mergeSortedArrayWithoutExtraSpace(arr1, arr2, m , n);
        int []arr11= {0};
        int []arr22= {1};
        m= 0;
        n = 1;
        mergeSortedArrayWithoutExtraSpace(arr11, arr22, m , n);
    }

    private static void mergeSortedArrayWithExtraSpace(int []arr1, int[] arr2, int m , int n){
        // {1,2,3,0,0,0}
        // {2,5,6}
        // {}

        //with using extra space from front
        int res1 []= new int[m+n];
        int j = 0;
        int k = 0;
        for (int i =0;i< res1.length;i++) {
            if (arr1[j] < arr2[k]){ // first array using its pointer if  is less, then take that element
                res1[i] = arr1[j];
                j++;
            } else if(arr1[j] > arr2[k]){ // second array using its pointer if is less, then take that element
                res1[i] = arr2[k];
                k++;
            } else {
                res1[i] = arr1[j]; // if both array equal using its pointer if  is less, then take that element from first arr and increase j
                j++;
            }
        }
        //for remaining element iterate second array and populate from last in result array
        for(int i=k;i<arr2.length;i++){
            res1[(res1.length) - (arr2.length-i)] = arr2[i];
        }
        System.out.println(Arrays.toString(res1));

    }


    private static void mergeSortedArrayWithoutExtraSpace(int []nums1, int[] nums2, int m, int n) {

        //variables to work as pointers
        int i=m-1; // will point at m-1 index of nums1 array
        int j=n-1; // will point at n-1 index of nums2 array
        int k=nums1.length-1; //will point at the last position of the nums1 array

        // Now traversing the nums2 array
        while(j>=0){
            // If element at i index of nums1 > element at j index of nums2
            // then it is largest among two arrays and will be stored at k position of nums1
            // using i>=0 to make sure we have elements to compare in nums1 array
            if(i>=0 && nums1[i]>nums2[j]){
                nums1[k]=nums1[i];
                k--;
                i--; //updating pointer for further comparisons
            }else{
                // element at j index of nums2 array is greater than the element at i index of nums1 array
                // or there is no element left to compare with the nums1 array
                // and we just have to push the elements of nums2 array in the nums1 array.
                nums1[k] = nums2[j];
                k--;
                j--; //updating pointer for further comparisons

                // int x = m-1;
                // int y = n-1;
                // // {1,2,3,0,0,0}
                // // {2,5,6}
                // // {}

                // //from back compare larges eement and populate
                // for(int i=nums1.length-1;i>0;i--) {
                //     if (nums1[x] > nums2[y]){ //
                //         nums1[i] = nums1[x];
                //         x--;
                //     } else if(nums1[x] < nums2[y]){ //
                //         nums1[i] = nums2[y];
                //         y--;
                //     } else {
                //         nums1[i] = nums1[x]; //
                //         x--;
                //     }
            }
        }

        System.out.println(Arrays.toString(nums1));


//        //variables to work as pointers
//        int i=m-1; // will point at m-1 index of nums1 array
//        int j=n-1; // will point at n-1 index of nums2 array
//        int k=nums1.length-1; //will point at the last position of the nums1 array
//
//        // Now traversing the nums2 array
//        while(j>=0){
//            // If element at i index of nums1 > element at j index of nums2
//            // then it is largest among two arrays and will be stored at k position of nums1
//            // using i>=0 to make sure we have elements to compare in nums1 array
//            if(i>=0 && nums1[i]>nums2[j]){
//                nums1[k]=nums1[i];
//                k--;
//                i--; //updating pointer for further comparisons
//            }else {
//                // element at j index of nums2 array is greater than the element at i index of nums1 array
//                // or there is no element left to compare with the nums1 array
//                // and we just have to push the elements of nums2 array in the nums1 array.
//                nums1[k] = nums2[j];
//                k--;
//                j--; //updating pointer for further comparisons
//            }
//        }
//


            }
}
