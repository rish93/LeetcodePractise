package com.TopInterview150;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IntersectionOfTwoArrays_349 {

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersection = new HashSet<Integer>();

        for(int i=0;i<nums1.length;i++){
            set.add(nums1[i]);
        }
        for(int i=0;i< nums2.length;i++){
            if(set.contains(nums2[i])){
                intersection.add(nums2[i]);
            }
        }

        int []result = new int[intersection.size()];

        Iterator<Integer> itr= intersection.iterator();
        int k=0;
        while(itr.hasNext()){
            result[k++] = itr.next();
        }

        return result;
    }

    public static void main(String[] args) {
            int nums1[]={2,3,4,5};
            int nums2[]={4,5,6,7};
          System.out.println(intersection(nums1,nums2));

    }
}
