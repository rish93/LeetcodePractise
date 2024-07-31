package com.javatopics.oops;


/* *
* *  Talking about Multiple inheritance is when a child class is inherits the
* *  properties from more than one parents and the methods for the parents are same
* *  (Method name and parameters are exactly the same) then child gets
* *  confused about which method will be called. This problem in Java is called the Diamond problem.
* * */

// Java Program to demonstrate
// Diamond Problem
import java.io.*;

// Parent Class1
class Parent1 {
    void fun() { System.out.println("Parent1"); }
}

// Parent Class2
class Parent2 {
    void fun() { System.out.println("Parent2"); }
}

// Inherting the Properties from
// Both the classes
class DiamondProblem extends Parent1/*extends Parent1, Parent2 this is not allowed in java*/{
    // main function
    public static void main(String[] args)
    {
        DiamondProblem t = new DiamondProblem();
        t.fun();
    }
}


///*****solution to diamond problem



interface Parent11 {
    void fun();
}

// Interfaces Declared
interface Parent22 {
    void fun();
}

// Inheritance using Interfaces
class test implements Parent11, Parent22 {
    public void fun()
    {
        System.out.println("fun function");
    }
}

// Driver Class
class test1 {
    // main function
    public static void main(String[] args)
    {
        test t = new test();
        t.fun();
    }
}
