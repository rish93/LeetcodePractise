package com.javatopics.oops;

/* *
* * Polymorphism is the ability by which, we can create functions or
* * reference variables that behave differently
* * in a different programmatic context. It is often referred
* * to as one name with many forms.
* *
* * For example, in most programming languages, '+' operator is
* * used for adding two numbers and concatenating two strings.
* * Based on the type of variables, the operator changes its behavior.
* * It is known as operator overloading.
* * In Java, polymorphism is essentially considered into two types:
* *
* */
public class Polymorphism {

    /*
    * Compile time polymorphism
    *
    * * 2.4.1. Compile-time Polymorphism
    * * In compile-time polymorphism, the compiler can bind the appropriate methods to the
    * * respective objects at compile time because it has all the necessary information and
    * * knows which method to call during program compilation.
    * * It is often referred to as static binding or early binding.

    In Java, it is achieved with the use of method overloading.
    * *  In method overloading, the method parameters can vary with a number, order, or type of parameter.

    class PlusOperator {

           int sum(int x, int y) {
                 return x + y;
           }

           double sum(double x, double y) {
                 return x + y;
           }

           String sum(String s1, String s2) {
                 return s1.concat(s2);
           }
    }

   * * * */


    /*
    *
    * *Runtime Polymorphism

In runtime polymorphism, the call to an overridden method is resolved
* * dynamically at runtime. The object, on which the method will be executed,
* * is determined at runtime – generally depending on user-driven context.

It is often referred to as dynamic binding or method overriding. We may have
* * heard it with the name dynamic method dispatch.

In runtime polymorphism, we generally have a parent class and a minimum of
* * one child class. In a class, we write a statement to execute a method
* * present in the parent and child classes.

The method call is given using the variable of the type of parent class.
* * The actual instance of the class is determined at runtime because a parent
* * class type variable can store the reference to the instance of the parent
* * class as well as child class also.
*
* * * *
    * class Animal {
       public void sound() {
             System.out.println("Some sound");
       }
    }

class Lion extends Animal {
   public void sound() {
         System.out.println("Roar");
   }
}

class Main {
   public static void main(String[] args)    {

        //Parent class reference is pointing to a parent object
        Animal animal = new Animal();
        animal.sound(); //Some sound

        //Parent class reference is pointing to a child object
        Animal animal = new Lion();
        animal.sound(); //Roar
   }
}

    *
    * * * */

}
