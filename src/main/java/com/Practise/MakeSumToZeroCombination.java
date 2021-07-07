package com.Practise;

import java.util.Scanner;


import java.util.*;
class sequencer
{
    int n;                                    //for no of terms
    int b=1,c=1,d=1,e=1,f=1,g=1,h=1;          //for different combinations
    int[] a=new int[10];                      //for saving all values
    Scanner in=new Scanner(System.in);
    public void combinations() {
        System.out.print("Enter Number of Terms (N<=9):");
        n=in.nextInt();

        for(int i=0;i<n;i++)
        {
            a[i]=i+1;                     //assigning values
        }
        double s=Math.pow(2,n-1);             //total combinations
        int k=1;
        System.out.println("Combinations are:");
        while(k<=s)
        {  int sum=a[0];

            for(int i=1;i<n;i++)
            {
                sum=sum+a[i];                   //checking sum
            }
            if(sum==0)
            {
                for(int i=0;i<n;i++)
                    System.out.print(a[i]+" ");
                System.out.println(" =0");
            }
            change(a);
            k++;
        }
    }
    public void change(int[] a)
    {
        a[n-1]=-a[n-1];
        if(n==2) return;
        if(b==2)
        {
            a[n-2]=-a[n-2];
            b=1;
        }
        else
        {
            b++;
        }
        if(n==3) return;
        if(c==4)
        {
            a[n-3]=-a[n-3];
            c=1;
        }
        else
        {
            c++;
        }
        if(n==4) return;
        if(d==8)
        {
            a[n-4]=-a[n-4];
            d=1;
        }
        else
        {
            d++;
        }
        if(n==5) return;
        if(e==16)
        {
            a[n-5]=-a[n-5];
            e=1;
        }
        else
        {
            e++;
        }
        if(n==6) return;
        if(f==32)
        {
            a[n-6]=-a[n-6];
            f=1;
        }
        else
        {
            f++;
        }
        if(n==7) return;
        if(g==64)
        {
            a[n-7]=-a[n-7];
            g=1;
        }
        else
        {
            g++;
        }
        if(n==8) return;
        if(h==128)
        {
            a[n-8]=-a[n-8];
            h=1;
        }
        else
        {
            h++;
        }
        if(n==9) return;
    }
}
public class MakeSumToZeroCombination {
    public static void main(String [] nt)
    {
        sequencer ob=new sequencer();
        ob.combinations();
    }
}
