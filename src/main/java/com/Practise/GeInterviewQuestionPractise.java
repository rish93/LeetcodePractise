package com.Practise;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class GeInterviewQuestionPractise {

  public static void main(String[] args) throws InterruptedException {

      /* JOin method overview.



I started to do research to find out why the word "join" is used for the Thread.join() method. In fact,
it waits for the thread to end on which it is called and
pauses the main thread to wait for it so, there is nothing to join.
 So, its name should be something like:

    Thread.pauseCaller();
    Thread.freezeCaller();
    Thread.focusThread();
    Thread.runBefore();

      I found one simple sentence after too much research which says that:
      Thread.join(); name comes from the concept of the calling thread waiting until
      the specified thread joins it.

     I am totally unable to get this above sentence into my mind and failed
     to understand the background context of using the word join for this method.
     What does the word "join" represent in this context? There is nothing to
     join anything else; instead, it just pauses the calling thread to wait for the
     thread followed by the join(). So, can anyone tell the context of using the join
     word for this method?

The word "join" comes from the Fork–Join model, where "fork" means to split the
 thread into multiple threads for parallel processing, and "join" means
to wait for the parallel threads to complete their part, before continuing in a single thread.

      *
      *
      *
      * */


      /* How to find the 3rd element from end in linked list in Java (Java Program to find the Nth Node from
        tail in linked list)*/
        findThirdElementFromEndLinkedList(3);

        /* Write producer consumer problem?*/
   //       producerConsumerProblemWithBlockingQueue();
        /* Write producer consumer problem without blocking queue?*/
  //        producerConsumerProblemWithoutBlockingQueue();

          /*find max occurring char from a char array?*/
       System.out.println(findMaxOccuranceOfCharacter("RISHABHH"));
      System.out.println(findMaxOccuranceOfCharacterUsingMap("RISHABHH"));
  }

    private static Integer findMaxOccuranceOfCharacterUsingMap(String input) {
        Map<String, Integer> map = new HashMap<>();
        Integer max = null;
        char[] charArr =  input.toCharArray();
        for (char c : charArr) {

            if (map.get(Character.toString(c)) != null) {
                map.put(Character.toString(c), map.get(Character.toString(c))+ 1);
            } else {
                map.put(Character.toString(c), 1);
            }

           // System.out.println(map);

             max=map.entrySet().stream().max((o1, o2) -> o1.getValue().compareTo(o2.getValue())).get().getValue();
        }

    return max;
  }

    private static String findMaxOccuranceOfCharacter(String input){

        final int ASCII=256;
        char[] arr = new char[ASCII];

        for(char c: input.toCharArray()){
            arr[c]++;
        }
        int max= Integer.MIN_VALUE;
        char result = ' ';
        for(int i=0;i<input.length();i++){
            if(max<arr[input.charAt(i)])
            {
                max=arr[input.charAt(i)];
                result = input.charAt(i);
            }
        }
        return result+" "+max+" times";
    }

   private  static void findThirdElementFromEndLinkedList(int n){

       // head/slow/fast
       // ^
       // |
       //1->2->3->4->5->6
                //n
      Node head= new Node(6);
      for(int i=5;i>0;i--){
          head = new Node(head,i);
      }

      Node fast =head,slow=head;

       System.out.println("Find "+n+"th node from end for linkedlist");
       while(head!=null) {
           System.out.print(head.value+" ->");
           head= head.next;
       }
      int i=0;
     //make fast node till nth node from beginning
      while(i<n){
          fast = fast.next;
          i++;
      }

      //increase both slow and fast one by one untill fast
      // has null as next node, slow will be pointing to nth now from end
      while(fast!=null){
          fast=fast.next;
          slow =slow.next;
      }
      /*
      to remove nth node from behind
         while(fast != null){
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        if(prev == null){
            return head.next;
        }
        prev.next = slow.next;
        return head;
       */

       System.out.println("Nth node from end is"+" "+slow.value);
   }


    private static void producerConsumerProblemWithBlockingQueue(){
        //lock allow to restrict access to share resource
      //1  //locks are simila to Synchronized but
        //lock are explicit co we have to create variable for it but npt for synchronized block which are
        //implicit
       //2  //in locks can be acquired in any order and released in any order (can have multiple lock as well)
            //but synchronized block are acquired with starting braces and released in closing braces


        BlockingQueue  blockingQueue = new ArrayBlockingQueue(20);
       Thread producer = new Thread(new Runnable() {
              @Override
              public void run() {
                for (int i = 1; i <= 4; i++) {
                  try {
                //    int numb = new Random().nextInt();
                    blockingQueue.put(i);
                    System.out.println("Produced " + i);
                  } catch (InterruptedException e) {
                    e.printStackTrace();
                  }
                }
              }
            });

        Thread consumer= new Thread(new Runnable() {
            @Override
            public void run() {
                while (true)
                    try {
                        System.out.println("Consumed " +   blockingQueue.take());
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        });
        producer.start();
        consumer.start();
        /*
        * o/p
        * Produced 1
          Consumed 1
          Produced 2
          Consumed 2
          Produced 3
          Consumed 3
          Consumed 4
          Produced 4
        * */
    }


    private static void producerConsumerProblemWithoutBlockingQueue() throws InterruptedException {
        Buffer buffer = new Buffer(2);

        Thread producerThread = new Thread(() -> {
            try {
                int value = 0;
                while (true) {
                    buffer.add(value);
                    System.out.println("Produced " + value);
                    value ++;
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                while (true) {
                    int value = buffer.poll();
                    System.out.println("Consume " + value);
                    Thread.sleep(1000);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();
        /*
            Produced 0
            Consume 0
            Produced 1
            Consume 1
            Produced 2
            Consume 2
            Produced 3
            Consume 3
            Produced 4
            Consume 4
            Produced 5
            Consume 5
            Produced 6
            Consume 6
         */
    }


}

 class Buffer {
    private Queue<Integer> list;
    private int size;

    public Buffer(int size) {
        this.list = new LinkedList<>();
        this.size = size;
    }

    public void add(int value) throws InterruptedException {
        synchronized (this) {
            while (list.size() >= size) {
                wait();
            }
            list.add(value);
            notify();
        }
    }

    public int poll() throws InterruptedException {
        synchronized (this) {
            while (list.size() == 0) {
                wait();
            }
            int value = list.poll();
            notify();
            return value;
        }
    }
}


class Node{
     Node next;
     int value;

    Node(int value){
        this.value = value;
    }
    Node(Node next, int value){
        this.next = next;
        this.value = value;
    }
}


