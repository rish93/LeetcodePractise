package com.Practise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

public class Epsilon {

    static class QueueTest{

        QueueTest(Queue queue){

            this.queue=queue;
        }
        Queue queue =new LinkedList();

        int length1=queue.size();
        Queue queue2 =new LinkedList();
        //List lstst= new ArrayList();
        void push(String s){
            queue.add(s);
        }



        Object pop(){
                Object result = null;
            while(!queue.isEmpty()) {

               // queue2.add(queue.poll());
                if(queue.size()  ==1){
                    result= queue.poll();

                }else{

                    queue2.add(queue.poll());

                   // queue.remove();
                }

            }

            queue=queue2;
            return result;
        }





        List<Object> updateList(List<Object> list1){
           List<Object> ls2= new ArrayList<Object>();
            for(int i=1;i<list1.size();i++){
                ls2.add(list1.get(i));

            }
            return ls2;
        }


        //1 ,2 ,3, 5
        List<Object> ls= new ArrayList<Object>();
        Object deque(){
            Object s= ls.get(0);
            ls= updateList(ls);

          return s;

        }

        void enque(String s){
            ls.add(s);
        }

    }


   static void customQueue(){
        Queue queue =new LinkedList();
        queue.add("One");
        queue.add("two");
        queue.add("three");
        System.out.println(new QueueTest(queue).pop());
        System.out.println(new QueueTest(queue).pop());
        System.out.println(new QueueTest(queue).pop());
        System.out.println(new QueueTest(queue).pop());

    }
    public static void main(String[] args) {
      customQueue();

      completableTask();
        int n=0;
        String[] strArr= new String[]{"one","two","three","four"};
         Thread t1= new Thread(new Runnable() {
            @Override
            public void run() {
                for(String s: strArr){
                   // synchronized (this) {
                        System.out.println(s + "  from thread 1");
                  //  }

                }
            }
        });

        Thread t2= new Thread(new Runnable() {
            @Override
            public void run() {
                for(String s: strArr) {
                 //   synchronized (this) {
                        System.out.println(s + "  from thread 2");
                 //   }
                }
            }
        });

      System.out.println( SingletonTest.getSingletonTest());
        t1.start();
        t2.start();


        TestFuntion testFuntion =( s, m) -> s + m;
        testFuntion.sumCalculator(23,23);
    }



    public static void completableTask(){
        ExecutorService executor = Executors.newFixedThreadPool(1);

        Callable c1= new Callable() {
            @Override
            public Object call() throws Exception {
                return "Job1 ";
            }
        };

        Callable c2= new Callable() {
            @Override
            public Object call() throws Exception {
                return "Job2 ";
            }
        };


        Future future1= executor.submit(c1);
        Future future2= executor.submit(c2);


//        if(future2.isDone() && future1.isDone()){
            try {
                String s1 =(String) future2.get();
                String s2 = (String)future2.get();

                System.out.println(s1+" -- "+s2);
            }
            catch (Exception e){
                e.printStackTrace();

            }
//        }
    }
}

interface TestFuntion{
    Integer sumCalculator(int n, int m );
}
 class Mac{

    String type;
    String version;
    String chip;
    Integer price;

    private Mac(){

    }

     private Mac(String type, String version, String chip, Integer price) {
         this.type = type;
         this.version = version;
         this.chip = chip;
         this.price = price;
     }

     class MacBuilder{
        String type;
        String version;
        String chip;
        Integer price;

        public MacBuilder( String version, String chip, Integer price) {
            this.version = version;
            this.chip = chip;
            this.price = price;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Mac build(){
            return new Mac(type,version,chip, price);

        }
    }






}



class SingletonTest{
    private static SingletonTest singletonTest;

    private SingletonTest(){
    }

    public static SingletonTest getSingletonTest(){
        synchronized (SingletonTest.class){
            if(singletonTest==null) {
                singletonTest = new SingletonTest();
            }
        }
        return singletonTest;
    }

}

//static and default method



/*
* You should read this: https://www.geeksforgeeks.org/producer-consumer-solution-using-threads-java/

And the Java sample they have there should help with some modifications for your scenario.

// Java program to implement solution of producer
// consumer problem.
import java.util.LinkedList;

public class Threadexample
{
    public static void main(String[] args)
                        throws InterruptedException
    {
        // Object of a class that has both produce()
        // and consume() methods
        final PC pc = new PC();

        // Create producer thread
        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    pc.produce();
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });

        // Create consumer thread
        Thread t2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    pc.consume();
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });

        // Start both threads
        t1.start();
        t2.start();

        // t1 finishes before t2
        t1.join();
        t2.join();
    }

    // This class has a list, producer (adds items to list
    // and consumber (removes items).
    public static class PC
    {
        // Create a list shared by producer and consumer
        // Size of list is 2.
        LinkedList<Integer> list = new LinkedList<>();
        int capacity = 2;

        // Function called by producer thread
        public void produce() throws InterruptedException
        {
            int value = 0;
            while (true)
            {
                synchronized (this)
                {
                    // producer thread waits while list
                    // is full
                    while (list.size()==capacity)
                        wait();

                    System.out.println("Producer produced-"
                                                  + value);

                    // to insert the jobs in the list
                    list.add(value++);

                    // notifies the consumer thread that
                    // now it can start consuming
                    notify();

                    // makes the working of program easier
                    // to  understand
                    Thread.sleep(1000);
                }
            }
        }

        // Function called by consumer thread
        public void consume() throws InterruptedException
        {
            while (true)
            {
                synchronized (this)
                {
                    // consumer thread waits while list
                    // is empty
                    while (list.size()==0)
                        wait();

                    //to retrive the ifrst job in the list
                    int val = list.removeFirst();

                    System.out.println("Consumer consumed-"
                                                    + val);

                    // Wake up producer thread
                    notify();

                    // and sleep
                    Thread.sleep(1000);
                }
            }
        }
    }
}
}
*
*
* * * * */
