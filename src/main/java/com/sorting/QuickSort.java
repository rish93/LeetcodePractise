package com.sorting;



public class QuickSort {
    //Pivot and partition
    // we will select last element as pivot(any element can be chosen)
    // place it at its correct position and
    // move small elements to left and large to right of pivot
    public static void main(String[] args) {
        int[] input = {6, 3, 9, 5, 2, 8};

        int n = input.length;
        quicksort(input,0,n-1);
    }

    private static void quicksort(int[] input, int low, int high) {
        if(low<high){
            int pivotIndex = partition(input,low,high);

            quicksort(input,low,pivotIndex-1);
            quicksort(input,pivotIndex+1,high);
        }
    }

    private static int partition(int[] input, int low, int high) {

        int pivot = input[low];
        int i =low;
        int j = high;

    }

    private static void swapp(int i, int j) {
    }

}
