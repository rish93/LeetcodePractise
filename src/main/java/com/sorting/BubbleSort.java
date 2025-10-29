package com.sorting;

import java.util.Arrays;

public class      BubbleSort {
    public static void main(String[] args) {

            //compare adjacent elemnt and shift large to last
            //bubble of sorted part will eventually increase and unsorted will decrease
/*time cmplexity*/
        //worst case O(n2)
        //average case case O(n2)
        //best case O(n)
/*space complexity*/
        //O(1) //not using extra space

        int [] arr = {3,1,6,4,8,2};

        for(int i=0; i< arr.length-1; i++){
            for(int j=0;j< arr.length-i-1;j++){
                if(arr[j]>arr[j+1]) {
                    int temp=arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }

            }
        }
        System.out.print(Arrays.toString(arr));
        BubbleSort b=new BubbleSort();
        b.sort();
    }



    void sort(){
        int [] arr = {3,1,6,4,8,2};
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1;j++){
                if(arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
        /*
        * 🧩 Why arr.length - 1 - i?

            Let’s say the array has N elements.
                1.	First pass (i = 0)
                •	The largest element moves to the last index (N - 1).
                •	So we need to compare up to j = N - 2, hence j < N - 1.
                2.	Second pass (i = 1)
                •	The second-largest element moves to index N - 2.
                •	The last element is already sorted, so we don’t need to check it again.
                •	So now we go only till j < N - 2.
                3.	Third pass (i = 2)
                •	Next largest element goes to index N - 3.
                •	So now j < N - 3.

            👉 In general, after i passes, the last i elements are already in correct position —
            no need to compare them again.

            So the inner loop runs till:


             j < arr.length - 1 - i
             *
             *
             * ⚙️ Correct (j < arr.length - 1)
                N × (N-1)
                Works but repeats last element passes
                Slower
                ✅ Optimized (j < arr.length - 1 - i)
                N × (N-1)/2
                Fewer unnecessary comparisons
                Efficient Bubble Sort
* * *
            */
}
