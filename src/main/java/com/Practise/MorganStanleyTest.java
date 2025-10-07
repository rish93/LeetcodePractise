package com.Practise;


import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MorganStanleyTest extends Thread {
    private static int x;

    public synchronized void todoThings() {
        int current = x;
        current++;
        x = current;
        System.out.println(MorganStanleyTest.x);
    }

    public void run() {
        todoThings();
    }

    public static void main(String[] args) throws Exception {

       /*
       * Group list of employees by department and print highest paid employees in each department*/

//sort().reverseOrder().findFirst()
//      List<Departmnent> lsdepartmenr= lsEmployee.stream().map(empl=> employee.getDepartment()).max(emp=>emp.salary())
//        .findFirst().collect(Coollectors.toList());


        /*Through Xoriant  oct6/2025
        * Pass same value across service
        * RestController vs Controller
        * @Value vs @ConfigurationProperties
        * Group List of employees by department & print highest paid employee in each department
        *
        *  System.out.println(listEmployeeeWithSalary.stream()
                        .max(Comparator.comparing(Employee::getSalary)).stream()
                        .collect(Collectors.groupingBy(employee -> employee.getDepartment())));
        *
        * */































         new MorganStanleyTest().start();


         /*sum of last 10 n node of link list*/
        com.Practise.ListNode elem11 = new com.Practise.ListNode(1);
        com.Practise.ListNode elem10 = new com.Practise.ListNode(1, elem11);
        com.Practise.ListNode elem9 = new com.Practise.ListNode(1, elem10);
        com.Practise.ListNode elem8 = new com.Practise.ListNode(1, elem9);
        com.Practise.ListNode elem7 = new com.Practise.ListNode(1, elem8);
        com.Practise.ListNode elem6 = new com.Practise.ListNode(1, elem7);
        com.Practise.ListNode elem5 = new com.Practise.ListNode(1, elem6);
        com.Practise.ListNode elem4 = new com.Practise.ListNode(1, elem5);
        com.Practise.ListNode elem3 = new com.Practise.ListNode(1, elem4);
        com.Practise.ListNode elem2 = new com.Practise.ListNode(1, elem3);
        com.Practise.ListNode elem1 = new com.Practise.ListNode(1, elem2);
        findSumOFLast10Node(elem1, 10);


        //https://knpcode.com/java-programs/producer-consumer-problem-java-program/

        //implementation using wait notify blocking queue (producer & consumer)
        LinkedList<Integer> list = new LinkedList<Integer>();
        Thread t1 = new Thread(new ProducerWaitNotify(list), "Producer");
        Thread t2 = new Thread(new ConsumerWaitNotify(list), "Consumer");
        t1.start();
        t2.start();


        //implementation of custom blocking queue (producer & consumer)
        BlockingQueue.blockingQueue();


        //Producer consumer implementation of blocking queue (producer & consumer)
        java.util.concurrent.BlockingQueue sharedQueue = new LinkedBlockingDeque();
        Thread prodThread = new Thread(new Producer(sharedQueue));
        Thread consThread = new Thread(new Consumer(sharedQueue));

        //Starting producer and Consumer thread
        prodThread.start();
        consThread.start();

        //Print even and odd in sequence in multithreading
        Printer printer = new Printer();
        Thread printOddThread = new Thread(new PrintOddTask(printer, 10), "Odd");
        Thread printEvenThread = new Thread(new PrintEvenTask(printer, 10), "Even");
        printOddThread.start();
        printEvenThread.start();


//        /design vending machine
//        https://medium.com/swlh/vending-machine-design-a-state-design-pattern-approach-5b7e1a026cd2

        //Intersction node of two link list
        //refer blind 75 leetcode question

        // print the number in english words for ex;4563 should be printed as "four thousand six hundred three.
//print the number in english words for ex;4563 should be printed as "four thousand six hundred three.

        //how linked hash map maintaine order
        //https://www.baeldung.com/java-linked-hashmap
        /*
        * It modifies Map.Entry to have nextand  previous pointer
        * */


    }

     private static void findSumOFLast10Node(com.Practise.ListNode head, int n){
      //make fast to iterate til n nodes
      //make slow to iterate till fast is at null
      //sum using slow till null

        ListNode slow = head;
        ListNode fast = head;
        int i=0;
        while (i<10){
            fast =fast.next;
            i++;
        }
        while(fast!=null){
            slow =slow.next;
            fast= fast.next;
        }
        int sum=0;
        while(slow!=null){
            sum+=slow.val;
             slow =slow.next;
         }
        System.out.println(sum);
     }



}

@Getter
@Setter
class NodeForQueue{
        private int value;
        private NodeForQueue nextNode;

    NodeForQueue(int value){
        this.value = value;
    }
}

class BlockingQueue{
    //https://stackoverflow.com/questions/20110013/implement-your-own-blocking-queue-in-java

    /*A queue implementation has two pointers as front
    and rear which points to front and rear of the queue
    respectively and this is the reason the time complexity
    for enQueue and deQueue process is O(1). We also have a
    capacity count of the blocking queue.

    During the put() and take() operation, this capacity is checked.
    In case, the capacity is reached or the queue is empty the thread
    accessing the queue gets blocked.*/

    private NodeForQueue front;
    private NodeForQueue rear;
    private int length;

    public synchronized void put(int data) throws InterruptedException {
        System.out.println("put method called...");
        if(this.length > 9){
            System.out.println("Maximum capacity reached. Hence waiting for take() operation");
            wait();
        }
        NodeForQueue nodeForQueue = new NodeForQueue(data);
        if(isEmpty())
            front = nodeForQueue;
        else
            rear.setNextNode(nodeForQueue);
        // Q1 <->  Q2 <-> Q3
        // R<->F
        // nodeForQueue(rear.setNextNode(nodeForQueue);) < - >  nodeForQueue(front = nodeForQueue;)
        rear = nodeForQueue;
        length++;
        System.out.println("Data "+data+" added in the queue. Going to notify the observers.");
        notifyAll();
    }

    public synchronized int take() throws InterruptedException {
        System.out.println("take() method called");
        int data;

        if(isEmpty()){
            System.out.println("No data found in the queue. take()() method execution paused.");
            wait();
        }
        System.out.println("Data became available. take() method resumed.");
        data = front.getValue();
        front = front.getNextNode();
        length--;
        return data;
    }

    public boolean isEmpty(){
        return length == 0;
    }


    public static void blockingQueue(){
        /*
        It is a queue implementation inside java.util.concurrent package that
        additionally supports operations that wait for the queue to become non-empty
        when retrieving an element, and wait for space to become available in the queue
         when storing an element. BlockingQueue implementations are designed to be used
         primarily for producer-consumer queues but additionally support the Collection
         interface.
         */
        BlockingQueue queue = new BlockingQueue();
        new Thread(() -> {
            try {
               while(true) {
                   System.out.print(queue.take());
               }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
             while(true){
                  queue.put(new Random().nextInt());
              }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

}


/* class Base {
 *//*PriorityQueue<String>  pq = new PriorityQueue<>();
        pq.add("C");
        pq.add("A");
        pq.add("B");
        System.out.println(pq.poll()+":"+pq.peek());*//*

    Base() {
        this("1");
    }

    Base(String s)
    {
        System.out.println("super-"+s);
    }
}*/
/*Object[] myObject ={new Integer(12),
                new String("foo"),
                new Integer(5),
                new Boolean(true)};
        Arrays.sort(myObject);
        for(int  i=0; i<myObject.length;i++)
        {

            System.out.println(myObject[i]);
            System.out.println(" ");
        }*/


/* BlockingDeque<Integer> deque = new LinkedBlockingDeque<>();
        deque.offer(10,5, TimeUnit.SECONDS);
        System.out.println(deque.pollLast(5, TimeUnit.SECONDS)+" ");
        System.out.println(deque.pollFirst(5, TimeUnit.SECONDS)+" ");*/


class ListNode {
    int val;
    com.Practise.ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, com.Practise.ListNode next) {
        this.val = val;
        this.next = next;
    }
}


//Consumer Class in Java
class Consumer implements Runnable{

    private final java.util.concurrent.BlockingQueue sharedQueue;

    public Consumer (java.util.concurrent.BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while(true){
            try {
                System.out.println("Consumed: "+ sharedQueue.take());
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


}

//Producer Class in java
class Producer implements Runnable {

    private final java.util.concurrent.BlockingQueue sharedQueue;

    public Producer(java.util.concurrent.BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            try {
                System.out.println("Produced: " + i);
                sharedQueue.put(i);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}



// Producer task
class ProducerWaitNotify implements Runnable{
    LinkedList<Integer> list;
    ProducerWaitNotify(LinkedList<Integer> list){
        this.list = list;
    }
    @Override
    public void run() {
        for(int i = 1; i <= 5; i++){
            synchronized(list) {
                // If there is already an element in the list wait
                while(list.size() >= 1){
                    System.out.println("Waiting as queue is full..");
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Adding to queue- " + Thread.currentThread().getName() + " " + i);
                list.add(i);
                list.notify();
            }
        }
    }
}
//Consumer task
class ConsumerWaitNotify implements Runnable{
    LinkedList<Integer> list;
    ConsumerWaitNotify(LinkedList<Integer> list){
        this.list = list;
    }
    @Override
    public void run() {
        for(int i = 1; i <= 5; i++){
            synchronized(list) {
                // if there is no element in the list wait
                while(list.size() < 1){
                    System.out.println("Waiting as queue is empty..");
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // if there is element in the list then retrieve it
                System.out.println("Consuming from queue- " + Thread.currentThread().getName() + " " + list.remove());
                list.notify();
            }
        }
    }
}


//print odd even usinf multithread
class PrintEvenTask implements Runnable{
    Printer printer;
    int max;
    PrintEvenTask(Printer printer, int max){
        this.printer = printer;
        this.max = max;
    }
    @Override
    public void run() {
        for(int i = 2; i <= max; i+=2){
            printer.printEven(i);
        }
    }
}

class PrintOddTask implements Runnable {
    Printer printer;
    int max;
    PrintOddTask(Printer printer, int max){
        this.printer = printer;
        this.max = max;
    }
    @Override
    public void run() {
        for(int i = 1; i <= max; i+=2){
            printer.printOdd(i);
        }
    }
}


 class Printer {
    boolean evenFlag = false;

    //Prints even numbers
    public void printEven(int num) {
        synchronized (this) {
            while (!evenFlag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Thread Interrupted" + e.getMessage());
                }
            }
            System.out.println(Thread.currentThread().getName() + " - " + num);
            evenFlag = false;
            // notify thread waiting for this object's lock
            notify();
        }
    }

    //Prints odd numbers
    public void printOdd(int num) {
        synchronized (this) {
            while (evenFlag) {
                try {
                    //make thread to wait
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Thread Interrupted" + e.getMessage());
                }
            }
            System.out.println(Thread.currentThread().getName() + " - " + num);
            evenFlag = true;
            // notify thread waiting for this object's lock
            notify();
        }
    }
}

// array of string group of anagram  google
// container with most water
// hld lift design (100 story building ,  engaged )

//max sub array kadane algo

