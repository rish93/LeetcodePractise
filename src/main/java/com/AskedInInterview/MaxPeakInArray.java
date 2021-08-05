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
