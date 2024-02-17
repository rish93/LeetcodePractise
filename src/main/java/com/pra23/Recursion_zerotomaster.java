package com.pra23;

public class Recursion_zerotomaster {
    private static int total=1;

    public static void main(String[] args) {
        int fatorialNum= 5;
        System.out.println(findFactorialWithRecursion(fatorialNum));
        System.out.println(findFactorialWithIteration(fatorialNum));

        System.out.println(findFibonacciWithRecursion(8)); //O2^n for long numbers
        System.out.println(findFibonacciWithIteration(fatorialNum));
        //0,1,1,2,3,5,8,13,21,34,55...

    }

   static int findFactorialWithRecursion(int factNum){
        if(factNum==2)
            return factNum;

        return factNum * findFactorialWithRecursion(factNum-1);
    }

    static int findFactorialWithIteration(int factNum){
        for(int i=factNum;i>1;i--){
            total=total*i;
        }
        return total;
    }

    static int findFibonacciWithRecursion(int num){

        if(num <2){
            return num;
        }

        return findFibonacciWithRecursion(num-1) +findFibonacciWithRecursion(num-2);

    }

    static int findFibonacciWithIteration(int factorialNum){

        return 0;
    }
}
