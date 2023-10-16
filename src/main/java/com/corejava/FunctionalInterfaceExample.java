package com.corejava;

  /*
   They can have only one functionality to exhibit.
   A functional interface is an interface that contains only one abstract method.
  */
  /*
    Java 8 onwards, lambda expressions can be used to represent the instance
     of a functional interface. A functional interface
    can have any number of default methods. Runnable, ActionListener
    , Comparable are some of the examples of functional interfaces.
  */
public class FunctionalInterfaceExample {
  /* @FunctionalInterface Annotation
  TODO  @FunctionalInterface annotation is used to ensure that the functional
   interface can’t have more than one abstract method.
  In case more than one abstract methods are present, the compiler
  flags an ‘Unexpected @FunctionalInterface annotation’ message. */

  public static void main(String[] args) {
    //
      int a = 5;

      // lambda expression to define the calculate method
      ITR s = (int x, int y)->x*x;

      // parameter passed and return type must be
      // same as defined in the prototype
      int ans = s.submitItr(a,3);
      System.out.println(ans);
  }
}


@FunctionalInterface
interface ITR
{
//    int getItr(int yearlyDebit, int yearlyCredit); (Multiple non-overriding abstract methods found in interface com.corejava.ITR)
    int submitItr(int yearlyDebit, int yearlyCredit);
}
