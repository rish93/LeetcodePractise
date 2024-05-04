package com.sorting;

public class MergeSort {

    //divide 1st then merge
// 1) concetrate on left in recursive manner [Do not forget the base case as it is when you RETURN from recurision and concentrate on next task]
//2) then on right  in recursive manner [Do not forget to start from next of mid other wise its an infinite loop no use of coding]
//3) merge each of the sorted individual array and add it to a list till all elements are adeed [consider mergng 2 set of arrays and use pointer low mid and high to imagine them ]


    //divide the array into 2 parts
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
         mergeSort(arr, 0, arr.length-1);
         for(int i =0; i<arr.length;i++){
             System.out.print(arr[i]+" ");
         }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low>=high) {  // base condition
            return;
        }
        int mid = (low + high) / 2;

        mergeSort(arr, low, mid); // left side divide
        mergeSort(arr, mid + 1, high); // right side divide
        mergeConquer(arr, low, mid, high);



    }

    public static void mergeConquer(int[] arr, int low, int mid, int high) {

        int left = low;
        int right = mid + 1;
        int [] merged = new int [high-low+1];
        int x = 0;
        while (left <= mid && right <= high) {

            if (arr[left] <= arr[right]) {
                merged[x++]=arr[left++];

            } else {
                merged[x++]=arr[right++];
            }

        }
//remaining elements check and add as all are sorted we are taking left 1st

        while (left <= mid) {
            merged[x++]=arr[left++];
        }
        while (right <= high) {
            merged[x++]=arr[right++];
        }

        for(int i =0,j =0; i<merged.length;i++,j++){
            arr[j] = merged[i];
        }

    }
}
