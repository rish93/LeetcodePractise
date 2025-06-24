package com.Practise.jpmorgan;

import java.util.*;
import java.util.stream.Collectors;

public class JPMorgan4 {
    static int count =50;
    static int i=0;
    static int totalThread = 2;
   // static Thread t1;
   //  Thread t2;
    public static void main(String[] args) {

        //thread1 prints {rishabh} thread2 {lastname}, ....50times
//        Thread t1= new Thread1Printer();
//        Thread t2= new Thread2Printer();
//
        JPMorgan4 jpMorgan4 = new JPMorgan4();
      Thread t1= new Thread(()-> jpMorgan4.print("Rishabh",1), "Thread1");
      Thread t2= new Thread(()-> jpMorgan4.print("Mankatala",2), "Thread2");
      t1.start();
      t2.start();


        //String name -"Rishabh" .. how many sub string possible with this character

         String name= "Rishabh Rastogi";
         String name1= "Rishabh";
         char[]charr= name1.toCharArray();
         List<Character> characterList = new ArrayList<Character>();
         for(char c: charr){
             characterList.add(c);
         }


       Character outputChar= characterList.stream().filter(character ->
                Collections.frequency(characterList,character)==1).findFirst().get();
         System.out.println(outputChar);


         //generate subsstring, from string
         String name3= "Rishabh";
        // int dp[] =new int[];

        Map<String, String> hashMap= new HashMap<>();
        hashMap.put("Rishabh","Mankatala");
        hashMap.put("Abhishek","Pandey");
        hashMap.put("Prateek","Mankatala");
        Map<String, String> outputMapForKey=new LinkedHashMap<>();
        Map<String, String> outputMapForValue=new LinkedHashMap<>();
        System.out.println("**"+ hashMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                        .map(stringStringEntry ->outputMapForKey.put(stringStringEntry.getKey(),stringStringEntry.getValue())
                        ).collect(Collectors.toList()));

       // System.out.println("**"+ hashMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList()));

        System.out.println("**"+ hashMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .map(stringStringEntry ->outputMapForValue.put(stringStringEntry.getKey(),stringStringEntry.getValue())
                ).collect(Collectors.toList()));

        System.out.println(outputMapForKey);
        System.out.println(outputMapForValue);

        //using configuration and component both together
        //autowirng on satic field
        //datasource
    }

   static class Thread2Printer extends Thread {
       @Override
       public void run() {
          // print("Rishabh", 1);
       }
   }

    static class Thread1Printer extends Thread{

        @Override
        public void run(){

           // print("Mankatala",2);
        }

    }


    synchronized void print(String name, int threadNum) {

        while (i < count) {
            while (threadNum <= totalThread) {
                try {

                    System.out.println(name + "  --" + threadNum);
                    wait();
                    threadNum++;
                }
                 catch(InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    notifyAll();
                }
            }
            i++;
        }

    }
/*
    static void print(String s, int threadNum{
     while(i<count){
            while(threadNum<=totalThread){
                try {

                Exception in thread "Thread1" Exception in thread "Thread2" java.lang.IllegalMonitorStateException: current thread is not owner
	at java.base/java.lang.Object.wait(Native Method)
	at java.base/java.lang.Object.wait(Object.java:321)
	at com.Practise.jpmorgan.JPMorgan4.print(JPMorgan4.java:90)
	at com.Practise.jpmorgan.JPMorgan4.lambda$main$1(JPMorgan4.java:20)
	at java.base/java.lang.Thread.run(Thread.java:832)
java.lang.IllegalMonitorStateException: current thread is not owner

if static method wat error
                    if (threadNum == 2) { ////second name
                        t1.wait();
                        System.out.println(s);
                        t2.notify();
                    } else if (threadNum == 1) {//first name
                        t2.wait();
                        System.out.println(s);
                        t1.notify();
                    }
                }
                catch (InterruptedException e){
                    System.out.println(e.getMessage());

                }
            }
            i++;
        }


    }
    */

}
