package com.Practise;

import java.util.*;

public class MorganInterview {

    public static void main(String[] args) {


//        int arr[] = new int []{7,3,4,5};
//        System.out.print(Arrays.stream(arr).sorted().skip(2).findFirst());

//12,3,4,5,7,8,9,11   //12345     23451
        int arr[] = new int []{4,5,7,8,3};

        int left = 0;
        int right = arr.length - 1;

//        while (left <= right) {
//            int midpoint = left + (right - left) / 2;
//
//            if (arr[midpoint] == target)
//                return nums[midpoint];
//
//            else if (target < nums[midpoint]) {
//                right = midpoint - 1;
//            } else {
//                left = midpoint + 1;
//            }
//
//        }



//            int mid =3;



        }



//        Solution solution= new Solution();
//        solution.save(2);
//        System.out.println(  solution.get());
//        solution.remove(2);
//        solution.save(4);
//        solution.save(5);
//        solution.save(6);
//        solution.save(7);
//        System.out.println(  solution.get());
//        System.out.println(  solution.get());
//        System.out.println(  solution.get());

    }

class Solution{

    private Integer value;
    List<Integer> list = new ArrayList<>();

//    List<Integer> index = new ArrayList<>();
Map<Integer, Integer> tracker = new HashMap<>();
    public void save(Integer value ){
        this.value = value;
//        list.add(value);
        tracker.put(value,value);

    }

    public void remove(Integer value ){

//        int index= tracker.get(value);
//        list.remove(value);
        tracker.remove(value);
    }


    public Integer get(){
//        Integer value = list.get(new Random(list.size()).nextInt());
        return tracker.get(value);
//        return  list.get(new Random(list.size()).nextInt());
//       return tracker.keySet().stream().findAny().get();
    }



}


