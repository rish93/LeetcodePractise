package com.corejava.executorapi;

import java.util.concurrent.Future;

public class MainCallingFutureMultithreading {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        SquareCalculator squareCalculator = new SquareCalculator();
        Future<Integer> future2 = squareCalculator.calculate(5000);
        Future<Integer> future1 = squareCalculator.calculate(1000000000);

        while (!(future1.isDone() && future2.isDone())) {
            System.out.println(
                    String.format(
                            "future1 is %s and future2 is %s",
                            future1.isDone() ? "done" : "not done",
                            future2.isDone() ? "done" : "not done"
                    )
            );
            Thread.sleep(300);
        }
        System.out.println("TIME TAKEN -->" + String.valueOf(System.currentTimeMillis() - startTime));

       /* Integer result1 = future1.get();
        Integer result2 = future2.get();*/

        //System.out.println(result1 + " and " + result2);

    }
}


//TODO both threads run simultaneously so both should be finised in equal time just change the thread to single thread and see the differnce

// op for single thread
/*
future1 is not done and future2 is not done
        future1 is not done and future2 is not done
        future1 is not done and future2 is not done
        future1 is not done and future2 is not done
        future1 is not done and future2 is done
        future1 is not done and future2 is done
        future1 is not done and future2 is done*/
