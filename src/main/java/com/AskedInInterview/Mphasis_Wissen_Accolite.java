package com.AskedInInterview;

import java.util.*;
import java.util.stream.Collectors;

public class Mphasis_Wissen_Accolite {
    public static void main(String[] args) {
        /// us
        int[] arr = {1, 3, 5, 7, 2, 1, 5, 3, 3};   // output -->{3,3,3,1,1,5,5,2,7}   output should be in the sorted order of (Count of occurence of the numbers in array)
        //TODO this code written below is the live code written during interview so feel free to modify it later and practice better approach

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i]) + 1);
            else
                map.put(arr[i], 1);
        }
        System.out.println(map.size());
        //Comparator<Integer> comparator = Comparator.comparing();
        List<Integer> finallist = new ArrayList<>();
        List<Map<Integer, Integer>> sortedMap = (List<Map<Integer, Integer>>) map.entrySet().stream().sorted(Map.Entry.comparingByValue(new myCustomisedComparator())).collect(Collectors.toList());
        sortedMap.size();

        //below part logic is write but didnt work
        /*sortedMap.forEach(a -> a.entrySet().forEach(e -> {
            for (int i = 0; i < e.getValue(); i++) {
                finallist.add(e.getKey());
            }
        }));
        finallist.forEach(elemnet -> System.out.println(elemnet));*/
    }


    static class myCustomisedComparator implements Comparator {

        @Override
        public int compare(Object o, Object o2) {
            Integer ob1 = (Integer) o;
            Integer ob2 = (Integer) o2;
            return ob2.compareTo(ob1);
        }
    }
}


//TODO given an array in natural order find the minimum amongst the missing elements in java 8
//this code gives the minimum elemnent in java 7 modify it to make it correct
/*    int[] arr ={2,4,5,6,9}

for(i=0;i<ar.legth
    int min = Integer.Max;
if(arr[i]+1!=arr[i+1])
    {
        min = Math.min(min,arr[i]+1)
    }
return min;

Arrays.asList(arr).stream().map(()-> i.getValue());*/



/*    null,"krishna"
            null, "pritam"
            null, "pranay"

            Add all of them in hashmap as it is HOW to do??
           */


/*    class A
    {

        a's constructor
        void something()
    }

    class B etends A
    {

        a's constructor
        void something()
    }

    class main
    {
        B b = new B();

        //TODO order of calling

    }*/

//pomgen -> java 8


/*
    class A {
        public void synchronized m1() {

            Thread.sleep(5000);


        }
    }
    A o1 = new A;
    A o2 = new A();

mainClass{
o1.m1();
o2.m1();
}
// What will happen Answer--> both will run as lock is at method level not class level so 2 objects will be created so 2 threads can work simultaneously on m1()

}
}*/



/*    Parent class with 2 methods walk and run. We have a child class which overrides both the methods. Both child class methods just call their respective Super implementation.
    Parent class run method calls walk().
    class Parent
Parent p = new Child();
p.run();
    Tell the order in which each method is called


//TODO need to verify it

child.run();
parent.run();
child.walk(); --> scope is in child
parent.walk();*/


    /*sum of square of odd numbers java 8


    int sum= list.stream().filter(num -> num%2!=0).map(oddNum-> oddNum*oddNum).sum();*/

//TODO first sort by number of appearnce then sort by name and print first sort by number of appearnce then sort by name and print
//
//5   --> number of input check and take all input in scaner and then apply logic
//hackerank
//apple
//google
//yahoo
//hackerrank
//hackerrank
//google


/*String s = new String("Arya);
String s2 = new String ("Arya");
String s3 = "Arya";
String s4 = s3+s2;*/

// how many objects will be created???