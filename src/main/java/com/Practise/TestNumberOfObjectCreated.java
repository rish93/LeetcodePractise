package com.Practise;

public class TestNumberOfObjectCreated {


    public static void main(String[] args) {
        Rishabh r = null;
        for(int i=0;i<5;i++){
            r= new Rishabh();
        }
      System.out.println(  r.toString());
    }

}


class Rishabh{
    static int i;
    Rishabh (){
        i++;
    }
    /*
    int i;
    As instance variables are declared in a class, these
    variables are created when an object of the class is created and destroyed when the object is destroyed.*/
    @Override
    public String toString(){
        return String.valueOf(i);
    }

}
