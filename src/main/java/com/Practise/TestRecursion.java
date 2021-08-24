package com.Practise;

public class TestRecursion {

  public static void main(String[] args) {
      RecursivePrint recursivePrint = new RecursivePrint();
      recursivePrint.printRecursion(1);
  }
  }

  class RecursivePrint{

    protected void printRecursion(int i){
        if (i <= 10) {
            System.out.println(i);
            printRecursion(i + 1);
        }

    }

  }
