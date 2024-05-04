package com.Searching;

public class BinarySearch {
        /*
        *  used in a sorted array by repeatedly dividing
        *  the search interval in half. The idea of binary
        *  search is to use the information that the array
        *  is sorted and reduce the time complexity to O(log N).
        * */

    /*
    Steps:

    Divide the search space into two halves by finding the middle index “mid”.
    Compare the middle element of the search space with the key.
    If the key is found at middle element, the process is terminated.
    If the key is not found at middle element, choose which half will be used as the next search space.
    If the key is smaller than the middle element, then the left side is used for next search.
    If the key is larger than the middle element, then the right side is used for next search.
    This process is continued until the key is found or the total search space is exhausted.
    * */
    public static void main(String[] args) {

        int searchElement =21;
        int arr[] = {2,5,9,15,18,21};
        int high = arr.length-1;
        int low = 0;
        System.out.println(binarySearch( low, high, arr,21));
        System.out.println(binarySearch( low, high, arr,5));
        System.out.println(binarySearch( low, high, arr,7));
    }
       //Time Complexity: O(log n)
    private static int binarySearch(int low, int high, int[] arr, int searchElement) {

     /* *  int mid=(high-low)/2; this will calculate mid same everythime thats why low+(high-low)/2
        *
        *  It fails for large values of low and high. Specifically, it fails if the sum of
        *  low and high is greater than the maximum positive value of int data type (i.e., 231 – 1).
        *  The sum overflows to a negative value, and
        *  the value stays negative when divided by two. This causes an array
        *  index out of bounds with unpredictable results.
        * */
        int mid=low+(high-low)/2;
        if (high >= low && low <= arr.length - 1) { //to prevent overflow of indices

            if (arr[mid] == searchElement) {
                return searchElement;
            }
            if (arr[mid] < searchElement) {
                low = mid + 1;
                return binarySearch(low, high, arr, searchElement);
            }
            if (arr[mid] > searchElement) {
                high = mid - 1;
                return binarySearch(low, high, arr, searchElement);
            }
        }
        return -1;
    }
}
