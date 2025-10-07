package com.Practise;

public class LnTInterview {
        //run thread in order
    /*
    * class OrderedPrinter {
    private int turn = 1;

    public synchronized void printA() {
        try {
            while (turn != 1) wait();
            System.out.println("Thread A running");
            turn = 2;
            notifyAll();
        } catch (InterruptedException e) {}
    }

    public synchronized void printB() {
        try {
            while (turn != 2) wait();
            System.out.println("Thread B running");
            turn = 3;
            notifyAll();
        } catch (InterruptedException e) {}
    }

    public synchronized void printC() {
        try {
            while (turn != 3) wait();
            System.out.println("Thread C running");
        } catch (InterruptedException e) {}
    }
}

public class RunInOrderWaitNotify {
    public static void main(String[] args) {
        OrderedPrinter printer = new OrderedPrinter();

        Thread t1 = new Thread(printer::printA);
        Thread t2 = new Thread(printer::printB);
        Thread t3 = new Thread(printer::printC);

        t3.start();
        t2.start();
        t1.start();
    }
}
    * * */
    //Builder design pattern

    //thread join vs wait

    //yield method in thread

    //class not found exception vs class defnnotfound exception

    //spring cloud what is service discovery how handled

    //how to handle hashing collision

    //how hashing works for HashSet

    //why order not maintained in hashset

    //make class like string

    //hibernate cache and it's type

    //hibernate save vs saveOrUpdate

    //how to make project enabling repository what all is needed

    //what are streams/lambda expression

    //how to access inner class variables

    //type of inner class

    //diff between anonymous class and lamba expression

    //what is try with resource from java 7

    //checked vs unchecked exeption

    //custom exception

    //deep cloning shallow cloning

    //when have String s= new String("rishabh") //will it create in string pool

    //return type matters in overloading /overriding

    //oops concept with eg

}
