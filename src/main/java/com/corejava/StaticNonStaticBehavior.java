package com.corejava;

public class StaticNonStaticBehavior {
    static int i;
    int j;
    //https://stackoverflow.com/questions/10594052/overriding-vs-hiding-java-confused
    public static void main(String[] args) {
        StaticNonStaticBehavior p = new StaticNonStaticBehavior();
        StaticNonStaticBehavior p1 = new StaticNonStaticBehavior();
        StaticNonStaticBehavior p2 = new StaticNonStaticBehavior();
        StaticNonStaticBehavior p3 = new StaticNonStaticBehavior();
        StaticNonStaticBehavior p4 = new StaticNonStaticBehavior();

        p.run();
        p1.run1();
        p2.run2();
        p3.run3();
        p4.run4();
    }

     Integer run() {
        i = i+5;
        j = j + 5;
        System.out.println("i-->" +i+ "j-->" + j );
        return 0;
    }
     Integer run1() {
        i = i+5;
         j = j + 5;
        System.out.println("i-->" +i+ "j-->" + j );
        return 0;
    }
     Integer run2() {
        i = i+5;
         j = j + 5;
        System.out.println("i-->" +i+ "j-->" + j );
        return 0;
    }
     Integer run3() {
        i = -3;
         j = -3;
        System.out.println("i-->" +i+ "j-->" + j );
        return 0;
    }
     Integer run4() {
        System.out.println("i-->" +i+ "j-->" + j );
        return 0;
    }
}

class Child extends StaticNonStaticBehavior {
    /*String run()

    {
        return  null;
    } */
}

//Overriding same method name with different return type will give compilation errors


