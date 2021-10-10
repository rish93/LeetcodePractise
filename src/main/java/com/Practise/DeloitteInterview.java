package com.Practise;

import java.util.Scanner;

public class DeloitteInterview {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number 1 ");
        long i= sc.nextLong();
        System.out.print("Enter number 2 ");
        long j= sc.nextLong();

        try {
            long k = i / j;
            System.out.print("DIVISION OUTPUT IS "+k);

        }catch (ArithmeticException e)
        {
            e.printStackTrace();
        }

    //different type of autowiring  {by name, by type}
    //different type of dependency injection {setter,constructor, variable}

    }


}
