package com.Practise;

public class GenericsTest {

/*
    Q. what is generic in java
    Generics allow types Integer, String, or even user-defined types
    to be passed as a parameter to
     classes,
     methods,
     or interfaces.
    Generics are mostly used by classes like HashSet or HashMap.

*/
    public static void main(String[] args) {
        // initialize the class with Integer data
        DemoGenericClass demo = new DemoGenericClass();

        // generics method working with String
        demo.<String>genericsMethod("232");

        // generics method working with integer
        demo.<Integer>genericsMethod(25);
    }
}


class DemoGenericClass {

    // creae a generics method
    public <T> void genericsMethod(T data) {
        System.out.println("Generics Method:");
        System.out.println("Data Passed: " + data);
    }
}


/*
* Advantages of Java Generics
1. Code Reusability
With the help of generics in Java, we can write code that will work with different types of data. For example,

public <T> void genericsMethod(T data) {...}
Here, we have created a generics method. This same method can be used to perform operations on integer data, string data, and so on.

2. Compile-time Type Checking
The type parameter of generics provides information about the type of data used in the generics code. For example,

// using Generics
GenericsClass<Integer> list = new GenericsClass<>();
Here, we know that GenericsClass is working with Integer data only.

Now, if we try to pass data other than Integer to this class, the program will generate an error at compile time.

3. Used with Collections
The collections framework uses the concept of generics in Java. For example,

// creating a string type ArrayList
ArrayList<String> list1 = new ArrayList<>();

// creating a integer type ArrayList
ArrayList<Integer> list2 = new ArrayList<>();
In the above example, we have used the same ArrayList class to work with different types of data.

Similar to ArrayList, other collections (LinkedList, Queue, Maps, and so on) are also generic in Java.*/
