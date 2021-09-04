package com.Practise;

public class TestMultithreading {

    public static void main(String[] args) {
        GFG_T g = new GFG_T(); // creating thread
        g.start(); // starting thread


        // create an object of Runnable target
        GFG_R gfg = new GFG_R();
        // pass the runnable reference to Thread
        Thread t = new Thread(gfg, "gfg");
        // start the thread
        t.start();
        // get the name of the thread
        System.out.println(t.getName());
    }
}

class GFG_T extends Thread {
    @Override
    public void run()
    {
        System.out.print("Welcome to GeeksforGeeks.");
    }
}
class GFG_R implements Runnable {
    @Override public void run()
    {
        System.out.println("Inside run method");
    }
}
