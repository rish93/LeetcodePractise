package com.blind75.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {
    public static void main(String[] args) {
        //System.out.println(threeSumBruteForce(new int[]{-1, 0, 1, 2, -1, -4}));  // [[-1,-1,2],[-1,0,1]]
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    // sort the array so that they are in order and use binary search logic of decresong window
    // with a twist here loop through all elements the target is -i=left+right (a+b+c =0)
    // decrese window after adding them in list
    // now, if its sorted -i>left+right then we decrese right as its sorted max is in right and oppo.
    // avoiding duplicates check i==i+1 increse left and i==i-1 increse right shoterwindow if they match


    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> finalist = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {   //Taking i as fixed element and finiding 2sum from the rest
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) { // to check if i is not duplicate to previous element unnecessary loop since target=i will be same so same subset
                int left = i + 1;
                int right = nums.length - 1;
                while (left <= right) {  //same logic as 2sum
                    if (-nums[i] == nums[left] + nums[right]) {  // since sorted array so we decrese bounaday if we find i+left+right=0   or -i =left+right
                        finalist.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        left++;
                        right--;
                        if(left < right && nums[left]==nums[left+1])left++;   //1|2|245 //if left is duplicate with the next elemnt increase left
                        if(left < right && nums[right]==nums[right-1])right--;  // if right is same as the previous decrese right
                    }
                    else if (-nums[i] > nums[left] + nums[right]) {  // if sum> a+b then reduce right side since sorted array has MAX in right
                        right--;
                    } else {
                        left++;
                    }

                }
            }
        }
        return finalist;

    }

/*    public static List<List<Integer>> threeSumBruteForce(int[] nums) {
        Map<Integer, Integer> occurence = new HashMap<>();
        List<List<Integer>> finalist = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            occurence.put(nums[i], occurence.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            occurence.put(nums[i], occurence.get(nums[i]) - 1);  // changing the occurence so that I dont get duplicate
            for (int j = i + 1; j < nums.length; j++) {
                 // I should not make a list having same element twice
                if (occurence.get(nums[i]) >=0 && occurence.get(nums[j]) >=0 && occurence.containsKey(-(nums[i] + nums[j])))  // a+b+c=0  ; c=-(a+b)   eg:  -(-2+-1) +3 =0
                {
                    occurence.put(nums[j], occurence.get(nums[j]) - 1);
                    List<Integer> output = new ArrayList<>();
                    output.add(nums[j]);
                    output.add(nums[i]);
                    output.add(-(nums[i] + nums[j]));
                    finalist.add(output);
                }
                occurence.put(nums[j], occurence.get(nums[j]) + 1);
            }
            occurence.put(nums[i], occurence.get(nums[i]) + 1);
        }
        return finalist;
    }*/
}
