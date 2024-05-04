package com.Searching;

public class LinearSearch {

    /*
    Every element is considered as a potential match for the key and checked for the same.
    If any element is found equal to the key, the search is successful and the index of that element is returned.
    If no element is found equal to the key, the search yields “No match found”.


    *  Best Case: In the best case, the key might be present at the first index. So the best case complexity is O(1)
       Worst Case: In the worst case, the key might be present at the last index i.e., opposite to the end from which the search has started in the list. So the worst-case complexity is O(N) where N is the size of the list.
       Average Case: O(N)
    * */

    public static void main(String[] args) {
        int nums[]= {3,76,8,9,0,-1,3};
        System.out.println(  linearSearch(nums, 23 ));
        System.out.println( linearSearch(nums, 9 ));
        System.out.println(  linearSearch(nums, 8 ));
        System.out.println( linearSearch(nums, 0 ));
        System.out.println(  linearSearch(nums, 1 ));
    }

   static String  linearSearch(int[]arr, int num){

        for(int i=0;i<arr.length;i++){
                if(num == arr[i]){
                    return "Found "+num;
                }
        }

        return "Not found";
    }
}
