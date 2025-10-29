package com.javatopics.multithreading;

/*
* Thread lifecycle
        New       When a new thread is created, it is in the new state.
                  The thread has not yet started to run when thread is in this state.
        Runnable  A thread that is ready to run is moved to runnable state. In this state,
                  a thread might actually be running or it might be ready run at any
                  instant of time. It is the responsibility of the thread scheduler to give the thread,
        Blocked  when a thread is waiting for I/O to complete, it lies in the
                 blocked state. It’s the responsibility
                 of the thread scheduler to reactivate and schedule a blocked/waiting thread.
        Waiting   A thread lies in timed waiting state when it calls a method with a time out parameter. A thread lies in this
                  state until the timeout is completed or until a notification is received.
        Timed Waiting   A thread terminates because of either of the following reasons:
                        Because it exists normally. This happens when the code of
                        thread has entirely executed by the program.
        Terminated    A thread terminates because of either of the following reasons:
                        Because it exists normally. This happens when the code of
                        * thread has entirely executed by the program.
*
* */

/*About Java.lang.Thread.class
*
* /*TODO interrupt()  Refer JavaInterruptExp1 class
* The interrupt() method of thread class is used to interrupt the thread.
* If any thread is in sleeping or waiting
* state (i.e. sleep() or wait() is invoked) then using the interrupt() method,
* we can interrupt the thread execution by throwing InterruptedException.
*
*  If the thread is not in the sleeping or waiting state then calling the
*  interrupt() method performs a normal behavior and doesn't interrupt the
* thread but sets the interrupt flag to true.
*
* /*TODO isDaemon()  Refer DaemonThread
    Tests if this thread is a daemon thread
 */
/*
* TODO JOIN() Refer TestJoinMethod1
* The join() method waits for a thread to die. In other words, it causes the currently running threads to stop executing until the thread it joins with completes its task.
*
* TODO RUN()
* The run() method of thread class is called if the thread was constructed using a separate Runnable object otherwise this method does nothing
* and returns. When the run() method calls, the code specified in the run() method is executed. You can call the run() method multiple times.
*
*TODO YIELD()   Refer YieldExample
* Yield is a Static method and Native too.
Yield tells the currently executing thread to give a chance to the threads that have equal priority in the Thread Pool.
There is no guarantee that Yield will make the currently executing thread to runnable state immediately.
It can only make a thread from Running State to Runnable State, not in wait or blocked state
* */

/*From object class
*
* equals() Method
finalize() Method
getClass() Method
hashCode() Method
notify() Method
notifyAll() Method
toString() Method
wait() Method
* */



//*Question:
//Q.Can we run thread twice
//        A java Thread cannot be run twice. Once
//        it has been started and finished its work, it
//        cannot be started again (calling method start will fail). So you'll have to create a new instance
//        of Thread (using the same Runnable) and start it.
//
// */


class Display{
    int turn=1;
    int times=5;
    /*
    * Question: “What happens if we remove synchronized in a wait/notify program?”

Answer:
wait() and notify() require the calling thread to own the monitor lock.
Without synchronization, the JVM throws IllegalMonitorStateException.
Also, shared data (like turn) can be modified concurrently, leading to race conditions and unpredictable output.
 */
    synchronized void print(String name, int thread) throws InterruptedException {
        for(int i=0;i< times;i++){
            while(turn!=thread) {
                wait();
            }
            System.out.println(name);
            turn =turn %3+1;
            notifyAll();
        }
    }
}
/*
*Instead of sycnronized, wait notify use lock
*
*
* class Display {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private int turn = 1;
    private final int times = 5;

    public void print(String name, int thread) throws InterruptedException {
        for (int i = 0; i < times; i++) {
            lock.lock();
            try {
                while (turn != thread) {
                    condition.await();
                }

                System.out.println(name);

                // Move turn to next thread
                turn = turn % 3 + 1;

                // Signal all waiting threads to re-check condition
                condition.signalAll();

            } finally {
                lock.unlock();
            }
        }
    }
}
* * *
*
* */
public class ThreadBasicsAndLifecycle {

    Data data = new Data();
    public static void main(String[] args) throws InterruptedException {
        //------------------------------------------------------
            //print in order 5 time for eg Mr   Rishabh Mankatala * 5 times from each thread
            Display display = new Display();
            Thread firstThread= new Thread(){
                @Override
                public void run() {
                    try {
                        display.print("Mr", 1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            Thread secondThread= new Thread(){
                @Override
                public void run() {
                    try {
                        display.print("Rishabh", 2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            Thread thirdThread= new Thread(){
                @Override
                public void run() {
                    try {
                        display.print("Mankatala", 3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            firstThread.start();
            secondThread.start();
            thirdThread.start();



        //------------------------------------------------------

        Thread t1= new Thread(); //NEW
        System.out.println("1 "+ t1.getState().name());
        t1.start();             //RUNNABLE
        System.out.println("2 "+ t1.getState().name());//Running

        t1.sleep(2000);  //timedwaiting/waiting

        t1.stop(); //terminated
        System.out.println("4 "+ t1.getState().name());

        //ways to create thread
        MyThreadWIthClass myThreadWIthClass = new MyThreadWIthClass();
        myThreadWIthClass.start();

        MyThreadRunnable myThreadRunnable = new MyThreadRunnable();
        Thread thread = new Thread(myThreadRunnable);
        thread.start();

       System.out.println( Data.i);
       }
}

class MyThreadWIthClass extends Thread {
    @Override
    public void run() {
        System.out.println("from Thread");
        Data.i++;
    }
}



class MyThreadRunnable implements  Runnable,Cloneable{
    @Override
    public void run() {
        System.out.println("from Runnable");
        Data.i--;
    }



/*
A thread is closely related to state and mechanisms managed
 within the jvm, perhaps even also resources tied to the underlying
 implementation of the operating system.

And so cloning a Thread's state without going through the normal thread
 startup / shutdown mechanisms would give unpredictable results at best,
 or a fatal jvm crash at worst.*/
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        Thread t3= new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
//
//
//        return super.clone();
//
//
//    }
}


class Data{
  static int i=2;

}


 class JavaInterruptExp1 extends Thread
{
    public void run()
    {
        try
        {
            Thread.sleep(1000);
            System.out.println("javatpoint");
        }catch(InterruptedException e){
            throw new RuntimeException("Thread interrupted..."+e);

        }
    }
    public static void main(String args[])
    {
        JavaInterruptExp1 t1=new JavaInterruptExp1();
        t1.start();
        try
        {
            t1.interrupt();
        }catch(Exception e){System.out.println("Exception handled "+e);}
    }
}


 class DaemonThread extends Thread
{
    public DaemonThread(String name){
        super(name);
    }

    public void run()
    {
        // Checking whether the thread is Daemon or not
        if(Thread.currentThread().isDaemon())
        {
            System.out.println(getName() + " is Daemon thread");
        }

        else
        {
            System.out.println(getName() + " is User thread");
        }
    }

    public static void main(String[] args)
    {

        DaemonThread t1 = new DaemonThread("t1");
        DaemonThread t2 = new DaemonThread("t2");
        DaemonThread t3 = new DaemonThread("t3");

        // Setting user thread t1 to Daemon
        t1.setDaemon(true);

        // starting first 2 threads
        t1.start();
        t2.start();

        // Setting user thread t3 to Daemon
        t3.setDaemon(true);
        t3.start();
    }
}


class TestJoinMethod1 extends Thread{
    public void run(){
        for(int i=1;i<=5;i++){
            try{
                Thread.sleep(500);
            }catch(Exception e){System.out.println(e);}
            System.out.println(i);
        }
    }
    public static void main(String args[]){
        TestJoinMethod1 t1=new TestJoinMethod1();
        TestJoinMethod1 t2=new TestJoinMethod1();
        TestJoinMethod1 t3=new TestJoinMethod1();
        t1.start();
        try{
            t1.join();
        }catch(Exception e){System.out.println(e);}

        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t3.start();
    }

    /*O/p
    Output:1
           2
           3
           4
           5
           1
           1
           2
           2
           3
           3
           4
           4
           5
           5
    *
    * */
}


 class YieldExample
{
    /*n below example program, I have created two threads named producer and consumer
     for no specific reason. Producer is set to minimum priority and consumer is set to maximum priority.
     I will run below code with/without commenting the line Thread.yield().

      Without yield(), though the output
      changes sometimes, but usually first all consumer lines are printed and then all producer lines.

With using yield() method, both prints one line at a time and pass the chance to another thread,
 almost all the time.*/
    public static void main(String[] args)
    {
        Thread producer = new Producer();
        Thread consumer = new Consumer();

        producer.setPriority(Thread.MIN_PRIORITY); //Min Priority
        consumer.setPriority(Thread.MAX_PRIORITY); //Max Priority

        producer.start();
        consumer.start();
    }
}

class Producer extends Thread
{
    public void run()
    {
        for (int i = 0; i < 5; i++)
        {
            System.out.println("I am Producer : Produced Item " + i);
            Thread.yield();
        }
    }
}

class Consumer extends Thread
{
    public void run()
    {
        for (int i = 0; i < 5; i++)
        {
            System.out.println("I am Consumer : Consumed Item " + i);
            Thread.yield();
        }
    }
}
