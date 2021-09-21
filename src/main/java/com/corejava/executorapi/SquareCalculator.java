package com.corejava.executorapi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SquareCalculator {

    private ExecutorService executor = Executors.newFixedThreadPool(2);

    public Future<Integer> calculate(Integer input) {
        return executor.submit(() -> {
            Thread.sleep(1000);
            return input * input;
        });   //submit takes in a callable interface a lambda function(anonymous function) also a runnable interface
             // which returns Future<Integer>= integer if Future<String> then string object
    }
}
// .newCachedThreadPool();  TIME TAKEN -->1219
//.newFixedThreadPool(2);   TIME TAKEN -->1226
//.newSingleThreadExecutor(); TIME TAKEN -->2169


// .execute() has void return type and is also asyncronous in nature.