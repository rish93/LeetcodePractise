package com.Oct1Week;

/*Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.*/

//https://www.youtube.com/watch?v=yFfv03AE_vA&feature=youtu.be&t=0

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

 public static void main(String []args) {

     int [] canditates= new int[]{2,3,6,7};
     int target=7;


     Solution solution = new Solution();
    System.out.println( solution.combinationSum(canditates,target));
 }
}

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result= new ArrayList<>();
        backTrack(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void backTrack(int[] cand, int start, int target, List<Integer> list, List<List<Integer>> result){

        if(target < 0 )
            return;

        if(target ==0){
            result.add(new ArrayList<>(list));
        }

        for(int i= start; i< cand.length;i++){
            list.add(cand[i]);
            backTrack(cand, i, target - cand[i], list, result);

           list.remove(list.size()-1); //for backtracking

        }


    }
}
