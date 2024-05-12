package com.TopInterview150.hackerearthtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
* Hacker is bored in the lockdown. He decided to play a game with rocks. Hacker has a collection of rocks and each rock weight is positive.
*
* *The game rule is simple, Hackers choose any two rocks and smash them. Suppose the rocks have weights A and B with A <= B. The result of the smash is: --> If A == B, both rocks are totally destroyed. --> If A !=B, the rock of weight A is totally destroyed, and the rock of weight B, has new weight B-A.
*
* In the last, there will be only one rock left. Hacker wants the smallest possible weight of the rock.
* Note:- The weight is 0 if there are no rocks left
* *
* * > The first line contains an array representing a weight of rocks.
* * > Print the smallest possible weight of the rock.
* *
* * 2<=number of rocks<=1000
    1<= Weight of rocks <=100</p>
* * */


public class HackerRocks {
    public static void main(String args[] ) throws Exception {
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println(name);

        calculateRockWeightLeft(name);

    }

    private static void calculateRockWeightLeft(String name) {
        String str[]= name.split("");
        int s=0;
        for(int i=0;i<str.length;i++){
           int n= Integer.parseInt(str[i]);
           s-=n;

        }
        System.out.println(s);

    }
}
