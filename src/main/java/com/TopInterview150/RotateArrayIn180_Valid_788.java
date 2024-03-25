package com.TopInterview150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RotateArrayIn180_Valid_788 {
    public static void main(String[] args) {
        System.out.println(brutteForceRotatedDigits(20));
        System.out.println(generateConfusingNumber(20));
    }

    public static int brutteForceRotatedDigits(int N) {
        int ret = 0;
        for (int i = 1; i <= N; i++) {
            if (isValid(i)) ret++;
        }

        return ret;
    }

    private static boolean isValid(int num) {
        boolean valid = false;
        while (num > 0) {
            int d = num % 10;
            if (d == 3 || d == 4 || d == 7) return false;
            if (d == 2 || d == 5 || d == 6 || d == 9) valid = true;
            num = num / 10;
        }

        return valid;
    }



    private static List<Integer> generateConfusingNumber(int n){
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);
        List<Integer> result = new ArrayList<>();
        backtrack(result, 0, n, map);
        return result;
    }

    private static void backtrack(List<Integer> result, int curr, int n, HashMap<Integer, Integer> map){
        if(isConfusingNumber(curr, map)){
            result.add(curr);
        }
        for(int digit: map.keySet()){
            if(curr==0 && digit==0){
                continue;
            }
            int next = curr*10+digit;
            if(next<=n)
                backtrack(result, next, n, map);
        }
    }

    private static boolean isConfusingNumber(int n, HashMap<Integer, Integer> map){
        int copy = n;
        int newNum = 0;
        while(copy!=0){
            int digit = copy%10;
            if(!map.containsKey(digit)){
                return false;
            }
            newNum = newNum*10+map.get(digit);
            copy=copy/10;
        }
        return newNum!=n;
    }
}
