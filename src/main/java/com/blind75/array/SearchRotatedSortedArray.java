package com.blind75.array;

public class SearchRotatedSortedArray {


    //012|3|456   ar[mid]>ar[mid-1] ar[mid+1]>ar[mid]  --> binary search

    //456|7|012  target = 6  --> ar[left]<=target and a[mid]>=target   ar[right]>=target and ar[mid]<=target
    //456|7|012  target = 1


    // just divide the array check if mid has left side sorted or right, go to sorted side find mid point lies between
    // between left to mid or right to mid if yes > reduce the left right margin towards midpoint and keep doing to find it
    public static void main(String[] args) {

        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 6));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 1));
        System.out.println(search(new int[]{1}, 0));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int midpoint = left + (right - left) / 2;
            if (target == nums[midpoint])
                return midpoint;
// TODO if left side of mid is sorted?? --> if true check if target exists in left side --> decrese right index to mid-1
            if (nums[left] <= nums[midpoint]) {
                if (nums[left] <= target && target <= nums[midpoint]) {   //check if the target lies between left and mid if yes the make right as mid
                    right = midpoint - 1;
                } else {
                    left = midpoint + 1;  //if not then make left as mid
                }

            } else // TODO we know right is sorted as left failed to be sorted
            {
                if (nums[midpoint] <= target && target <= nums[right]) {
                    left = midpoint + 1;
                } else right = midpoint - 1;
            }
        }
        return -1;
    }
}
