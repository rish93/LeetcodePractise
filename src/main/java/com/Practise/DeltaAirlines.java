package com.Practise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeltaAirlines {

    public static void main(String[] args) {
        //magnets with its intensity in array
        //find max group of magnets whose diff greater than k, Mettl test

        //ref. https://stackoverflow.com/questions/71267722/find-minimum-group-of-array-with-difference-less-than-k
        //if k =3
        int arr[] = {3,6,12,4,5,1,7,17};
        //grp1 {3,6,12,17}
        //grp2 {3,17,12, }
        int k =3;
        int n=8;
        int arr1[] = {3,6,12,4,5,1,7,17,42,8,59,100,2};
        System.out.println(findMaxGroupFromMagnets(n, k, arr));
        System.out.println(findMaxAllGroupFromMagnets(n, k, arr));


        System.out.println("Answer for max group of magnet subset: "+Arrays.toString(arr)+" => "+findMaxFromMagnetsDPApproach(n, k, arr));

        //wrong answer expected 6, found 7
        System.out.println("Answer for max group of magnet subset: "+Arrays.toString(arr1)+" => "+findMaxFromMagnetsDPApproach(arr1.length, k, arr1));

            //find max probability of winning match for player /*see line 103*/
            int scoreArr[][] =  new int[][]{{1,0,1,1},{2,0,2,1},{0,0,0,2}, {0,0,0,0}};
            int result []= findMaxProbability(scoreArr);
            System.out.println(Arrays.toString(result));
        }

         private static int findMaxFromMagnetsDPApproach(int arrSize, int magnetDiff, int[] magnetArr) {
                  // int arr[] = {3,6,12,4,5,1,7,17};
                  // magnetDiff 3
                  // createDiff array


                  int dp[][] = new int[arrSize+1][magnetDiff+1];
                  //since for 0 diff, for all intensity diff value will be 0
                  // and for 0 intensity for all diff  , diff will be 0
                  //marking all 0 row and alll 0 columns as 0
                  for(int row=0;row<dp.length;row++) {
                    for(int column=0;column<dp[0].length;column++) {
                        if(row==0 || column==0){
                            dp[row][column] = 0;
                        }
                    }
                 }
              //  print2Dmatrix(dp);

             int [] diffArray= new int [magnetDiff+1];
             int count=0;
             for(int i=0;i<diffArray.length;i++){
                 diffArray[i] = count++;
             }
             System.out.println("diff array for  "+magnetDiff+" "+Arrays.toString(diffArray));
             for(int row=1;row<dp.length;row++) {
                 for(int column=1;column<dp[row].length;column++) {
                     if(magnetArr[row-1] - diffArray[column]>column) {
                         dp[row][column] = magnetArr[row-1];
                     } else {
                         dp[row][column] = -1;
                     }
                 }
             }
             print2Dmatrix(dp);

                int result= 0;
                for(int row=1;row<dp.length;row++) {
                 //for(int column=diffArray.length-1;column<=dp[row].length;column++) {

                     if(dp[row][diffArray.length-1]>0 ){
                         result++;
                     }

                // }
             }


                 return result;
         }


         private static void print2Dmatrix(int[][]dp){
             for(int row=0;row<dp.length;row++){
                 for(int column=0;column<dp[row].length;column++) {
                      System.out.print(dp[row][column]+", ");
                 }

                 System.out.println();
             }
         }


    private static int[] findMaxProbability(int[][] scoreArr) {
        int result[]= new int[scoreArr.length];
        int n=-1;
        Map<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<scoreArr.length;i++){
            for(int j=0;j<scoreArr[i].length;j++){
                map.put(i, map.get(i)!=null ? map.get(i)+1  : 0);
                n= Math.max(n, map.get(i));
            }
        }

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){

            result[entry.getKey()] = entry.getValue()<n?0:1;
        }

        return result;
    }

    private static int findMaxAllGroupFromMagnets(int totalN, int diffK, int[] arr) {
        //not all test case  will be passed
        int count=0;
        int start=0;
        Arrays.sort(arr);
        Map<Integer, List<Integer>> map= new HashMap<>();
        for(int i=1;i<arr.length;i++ ){
            if(Math.abs(arr[i]-arr[start])>diffK) {

                    count++;
                    start = i;


            }
        }

        System.out.println(Arrays.toString(arr));

        return count;
    }

    public static int findMaxGroupFromMagnets(int totalN, int diffK, int []arr){
            //not all test case  will be passed
//        Arrays.sort( arr);  // this line is updated.
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


    //Design an app like Practo


    /*
    * 1. Sum of even & odd
    You are given an integer 'n'. Calculate the sum of even and odd digits of 'n', represented in decimals.
    Even and odd do not refer to the position of the digit but to the polarity of the digit.
    Return the answer in the form of an array of size 2, such that the 0th index represents the even sum and the 1st index represents the odd sum.
    Example:
    Input: 'n' = 1986.
    Output: [14, 10]
    Explanation: Even digits are 8 & 6, and odd digits are 1 & 9. The sum of even digits = 14, and the sum of odd digits = 10.
    *
    *
    *
    *
    * --------------------------* * * *
    *
    * Q2. Explain SDLC(Software Development Life Cycle)?
    View Answers (1)

    Q3. Name different Software Development Models You know about?
    View Answers (1)

    Q4. Explain Waterfall model.It's advantages and disadvantages?
    View Answers (1)

    Q5. What's Agile methodology and it's advantages over waterfall model?
    View Answers (1)

    Q6. Dicussions about my Project.Explain E-R diagram of your Project?Have you done any Project in C,C++?Which Software Development Model you used?
*
*write an api to accept list of object and process the list in multiple threads.
*
* Explain a SQL sub-select.

* *
* * * * * *
    * */

    /*
        1 Mean won
        0 mean lost
        2 mean Match yet to be played
      return array [] with 1 and 0 such that 1 denote probability of win
      0 with no probability

      all with 1 have high probability and eg 3 (1 won 2 shceduled || 2 won 1 scheduled || 3 scheduled
      but for 0,0 it may have less probability than 3 like player 1, 2,3)
      eg [1,1,1,0,0]
                 Match 1  Match2 Match3 Match4 Match5
    *  Player 1    0          2       1   1       0        prob 3
    *  Player 2    1          2       1   0       0        prob 3
    *  Player 3    1          1       1   0       0        prob 3
    *  Player 4    0          1        0   0       0        prob 1
    *  Player 5    2           2       0   0       0        prob 2
    *  Player 6    1           0        0   0      0

    [1,1,1,0,0]  o/p as plyer 1,2,3, have high prbability
    *
    * */
}
