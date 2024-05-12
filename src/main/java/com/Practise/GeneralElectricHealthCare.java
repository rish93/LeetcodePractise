package com.Practise;

import java.util.ArrayList;
import java.util.List;

public class GeneralElectricHealthCare {

    /* * * *
    *  referring Asked questions from internet
    *
    *  Q1. Binary search, Merg sorting algorithm, Minimum n maximum number in an array list Core java
    *       question Oops tricky code snippets Architecture questions about restful and Microservices
    *  Q2. Deep copy and shallow copy Interviewer test your problem solving attitude and response not the perfect output
    *  Q3. Array in descending order code
    *  Q4. Comparator and comparable interface
    *
    * * * * * */


    public static void main(String[] args) {

        // Minimum n maximum number in an array list
        List<Integer> list= List.of(2,3,7,1,8,4);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(Integer i: list){
            if(i<min){
                min = i;
            }else if(i>max){
                max = i;
            }
        }
        System.out.println("min: "+ min+"  max: "+max);

        //binary search
        int target=2;
        int arr[] = {2,4,6,8,9,10};
        int l=0;
        int r = arr.length-1;
        while(l<=r){
            int mid= l+ (r-l)/2;
            if(arr[mid] == target)
            {
                System.out.println(target+" found");
                return;
            }

            if(target<arr[mid]){
                r = mid-1 ;
            }else
            {
                l = mid+1;
            }
        }
        System.out.println(-1+" not found");






    }
}
