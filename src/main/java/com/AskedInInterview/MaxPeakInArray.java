package com.AskedInInterview;

//McAfee
public class MaxPeakInArray {
    public static void main(String arg[]){
        int arr[] = new int[]{2,4,6,-2,5};
//        int n=3;[ 1, 3, 5, -2, 7, 6] [1 , 3, 5, 7, 4]
        maxPeak(arr);

    }

    static void maxPeak(int arr[]){

            for(int i=0;i<arr.length;i++){

            for(int j=i; j<i+3;j++) {

            if(!(arr.length -3 == j))
                    return;

                if ( arr[j + 1] > arr[j] && (arr[j + 1] > arr[j+ 2])) {
                } else
                    continue;
//                    if((i+1) > (i+2)+(i) ){
//                        System.out.println( i);
//                    }
            }


            }

     }

}

class PeakElement {
    // A binary search based function
    // that returns index of a peak element
    static int findPeakUtil(
            int arr[], int low, int high, int n) {
        // Find index of middle element
        // (low + high)/2
        int mid = low + (high - low) / 2;

        // Compare middle element with its
        // neighbours (if neighbours exist)
        if ((mid == 0 || arr[mid - 1] <= arr[mid])
                && (mid == n - 1 || arr[mid + 1] <= arr[mid]))
            return mid;

            // If middle element is not peak
            // and its left neighbor is
            // greater than it, then left half
            // must have a peak element
        else if (mid > 0 && arr[mid - 1] > arr[mid])
            return findPeakUtil(arr, low, (mid - 1), n);

            // If middle element is not peak
            // and its right neighbor
            // is greater than it, then right
            // half must have a peak
            // element
        else
            return findPeakUtil(
                    arr, (mid + 1), high, n);
    }

    // A wrapper over recursive function
    // findPeakUtil()
    static int findPeak(int arr[], int n) {
        return findPeakUtil(arr, 0, n - 1, n);
    }
}

class GFG{

    // Find the peak element in the array
    static int findPeak(int arr[], int n)
    {

        // First or last element is peak element
        if (n == 1)
            return 0;
        if (arr[0] >= arr[1])
            return 0;
        if (arr[n - 1] >= arr[n - 2])
            return n - 1;

        // Check for every other element
        for(int i = 1; i < n - 1; i++)
        {

            // Check if the neighbors are smaller
            if (arr[i] >= arr[i - 1] &&
                    arr[i] >= arr[i + 1])
                return i;
        }
        return 0;
    }
}
