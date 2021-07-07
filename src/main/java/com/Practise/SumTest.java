package com.Practise;

public class SumTest {

    public static void main(String arg[]){
        int arr[] = new int[]{2,4,6,-2,5};
        int n=3;
        findPair(arr, n);

    }


    static void  findPair(int temp[],int n){
        for(int i=0;i<temp.length; i++){
            for(int j=i+1;j<temp.length;j++){

                if(i!=j && n==(temp[i]+temp[j])){
                    System.out.println(i+""+j);
                }

            }
        }

    }
}
