package com.sorting;

import java.util.Arrays;

public class QuickSort {
//https://www.youtube.com/watch?v=QN9hnmAgmOc
//https://www.youtube.com/watch?v=Vtckgz38QHs

   //average case O(nLogn)
   // Worst case O n2
    public static void main(String[] args) {
        int arr[]={23,3,4,5,1,66,54,3};
        int start=0;
        int last = arr.length-1;
        quickSort(arr, start, last);
    }


    private static void quickSort(int []arr, int lb, int ub){

        if(lb<ub){
            int loc= partition(arr, lb, ub);
            quickSort(arr, 0, loc-1);
            quickSort(arr, loc+1, ub);
        }
        System.out.println(Arrays.toString(arr));
    }

//    private static void quickSort(int[] array, int start, int end) {
//
//        if(end <= start) return; //base case
//
//        int pivot = partition(array, start, end);
//        quickSort(array, start, pivot - 1);
//        quickSort(array, pivot + 1, end);
//    }
//    private static int partition(int[] array, int start, int end) {
//
//        int pivot = array[end];
//        int i = start - 1;
//
//        for(int j = start; j <= end; j++) {
//            if(array[j] < pivot) {
//                i++;
//                int temp = array[i];
//                array[i] = array[j];
//                array[j] = temp;
//            }
//        }
//        i++;
//        int temp = array[i];
//        array[i] = array[end];
//        array[end] = temp;
//
//        return i;
//    }

    private static int partition(int []arr, int start, int end){
        int pivot = arr[start];
        while(start<end){
            while(arr[start]<= pivot )
                start++;
//            else
//                {
//                    int temp = arr[start];
//                    arr[start] = arr[end];
//                    arr[end] = temp;
//                }

            while(arr[end] >pivot)
                end--;
//            else {
//                int temp = arr[start];
//                arr[start] = arr[end];
//                arr[end] = temp;
//            }
            if(start< end){
                int temp = arr[end];
                arr[start] = temp;
                arr[end] = pivot;
            }
        }
        int temp = arr[end];
        arr[start] = temp;
        arr[end] = pivot;

        return end;
    }
}
