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

    @Override
    public String toString(){
        return String.valueOf(i);
    }

}
