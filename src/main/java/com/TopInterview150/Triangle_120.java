package com.TopInterview150;

import java.util.Collections;
import java.util.List;

/*
* Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below.
* * More formally, if you are on index i on the current row,
* *  you may move to either index i or index i + 1 on the next row.



Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:

Input: triangle = [[-10]]
Output: -10


Constraints:

1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104

*
* * * */
public class Triangle_120 {
    public static void main(String[] args) {


      //test case answ expected 11 //correct current 11
//         List<Integer> ls1= List.of(2);
//        List<Integer> ls2= List.of(3,4);
//        List<Integer> ls3= List.of(6,5,7);
//        List<Integer> ls4= List.of(4,1,8,3);


        //test case answ expected -1 //incorrect //current -2
        List<Integer> ls1= List.of(-1);
        List<Integer> ls2= List.of(2,3);
        List<Integer> ls3= List.of(1,-1,-3);


        List<List<Integer>> triangle=List.of(ls1,ls2,ls3);
        System.out.println(minimumTotal(triangle));//11 correct
    }


    public static int minimumTotal(List<List<Integer>> triangle) {
        int min = Integer.MAX_VALUE;
        int sum =0;
        for(List<Integer> ls:triangle){
            //for(int val: ls){
            //if(val<min){
            min = Collections.min(ls);
            // sum+=min;
            // min =val;
            // }
            // }
            sum+=min;
            // min = Integer.MAX_VALUE;
        }
        return sum;
    }

}
