package com.Practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Altimetrix {
    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 2, 8, 9};
        int target = 13;  //(5+8=13  13-5 =8)
        List<Integer> a = new ArrayList(Arrays.asList(arr));
        //List a = Arrays.asList(arr);
      /*  for (int i = 0; i < arr.length; i++) {
            a.add(arr[i]);
        }*/


        for (int i = 0; i < arr.length; i++) {
            if (a.contains(target - arr[i])) {
                System.out.println(a.indexOf(target - arr[i]));
                System.out.println(i);
            }
        }

    }
}
