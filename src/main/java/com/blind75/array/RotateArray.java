package com.blind75.array;


// Java program to rotate an array by
// d elements

class RotateArray {
    /*Function to left rotate arr[] of size n by d*/
    void leftRotate(int arr[], int d, int n)
    {
        for (int i = 0; i < d; i++)
            leftRotatebyOne(arr, n);
    }

    void leftRotatebyOne(int arr[], int n) {
        int i, temp;
        temp = arr[0];
        for (i = 0; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[n-1] = temp;
    }

    /* utility function to print an array */
    void printArray(int arr[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {
        RotateArray rotate = new RotateArray();
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        rotate.leftRotate(arr, 2, 7);
        rotate.printArray(arr, 7);
    }
}


/* O(n)
//if rotation is 2 times.
*Initialize a temporary array(temp[n]) of length same as the original array
*Initialize an integer(k) to keep a track of the current index
*Store the elements from the position d to n-1 in the temporary array
*Now, store 0 to d-1 elements of the original array in the temporary array
*Lastly, copy back the temporary array to the original array


import java.io.*;

class GFG {


    // Function to rotate array
    static void Rotate(int arr[], int d, int n)
    {
        // Storing rotated version of array
        int temp[] = new int[n];

        // Keeping track of the current index
        // of temp[]
        int k = 0;

        // Storing the n - d elements of
        // array arr[] to the front of temp[]
        for (int i = d; i < n; i++) {
            temp[k] = arr[i];
            k++;
        }

        // Storing the first d elements of array arr[]
        // into temp
        for (int i = 0; i < d; i++) {
            temp[k] = arr[i];
            k++;
        }

        // Copying the elements of temp[] in arr[]
        // to get the final rotated array
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }


    static void PrintTheArray(int arr[], int n)
    {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static void main (String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        int N = arr.length;
        int d = 2;


        Rotate(arr, d, N);
        PrintTheArray(arr, N);
    }
}
 */