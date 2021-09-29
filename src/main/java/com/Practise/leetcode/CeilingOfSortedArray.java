package com.Practise.leetcode;


//given a sorted array and a target, find the number from array which is = or (lowest maximum from of the target)

// sorted Array --> think Binary search
// else is it possible to sort and apply binary search think that

//Similar Questions // TODO find smallest number > target eg: ["c","f","j"] target ="a";  output should be C  same just character array and compare
public class CeilingOfSortedArray {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 14, 16};
        int target = 6;
        System.out.println(ceilingOfNumber(arr, target));
        System.out.println(flooringOfNumber(arr, target));


    }

    // implement binary serach fiest then think when I am getting the element which is the next greater element than target??
// just the next element is > next element obviously
// todo whenever the condition start<end is violated we get the number dont return -1 just return the end  WHY???  start target end  --> Initially but when loop breaks  end tartget start
    private static int ceilingOfNumber(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        if (arr.length == 0 || target > arr[end])  // case where target > last element
            return -1;
        while (start <= end) {
            int midpoint = start + (end - start) / 2;
            if (target > arr[midpoint])
                start = midpoint + 1;
            else if (target < arr[midpoint])
                end = midpoint - 1;
            else
                return arr[midpoint];
        }
        return arr[start];
    }

    private static int flooringOfNumber(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        if (arr.length == 0 || target < arr[start])  // case where target > last element
            return -1;

        while (start <= end) {
            int midpoint = start + (end - start) / 2;
            if (target > arr[midpoint])
                start = midpoint + 1;
            else if (target < arr[midpoint])
                end = midpoint - 1;
            else
                return arr[midpoint];
        }
        return arr[end];
    }
}
