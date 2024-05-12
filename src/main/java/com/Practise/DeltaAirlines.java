package com.Practise;

import java.util.Arrays;

public class DeltaAirlines {

    public static void main(String[] args) {
        //magnets with its intensity in array
        //find max group of magnets whose diff greater than k, Mettl test

        //ref. https://stackoverflow.com/questions/71267722/find-minimum-group-of-array-with-difference-less-than-k
        int arr[] = {3,6,12,4,5,1,7,17};
        //grp1 {3,6,12,17}
        //grp2 {
        // }
        int k =3;
        int n=8;
        System.out.println(findMaxGroupFromMagnets(n, k, arr));
    }

    public static int findMaxGroupFromMagnets(int totalN, int diffK, int []arr){

       // Arrays.sort( arr);  // this line is updated.
        int start = 0;
        if(arr.length == 0) return 0;
        // If arr has some value then at least can form 1 group
        int count = 1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] - arr[start] > diffK) {
                count++;
                start = i;
            }
        }
        return count;


    }
}
