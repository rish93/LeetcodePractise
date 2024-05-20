package com.AskedInInterview;

public class ArmstrongNumber {

    public static void main(String[] args) {
        //153 = 1^3 + 5^3 + 3^3;
        int n1= 153;
        int sum =0;
        int n= n1;
        while(n!=0){
            int mod = n%10;

            sum +=Math.pow(mod,3);

            n = n/10;
        }

        System.out.println("Armstrong: "+n1);
        System.out.println(sum == n1);
    }
}
