package com.corejava;

public class Parent {
    static int i;
    int j;

    public static void main(String[] args) {
        Parent p = new Parent();Parent p1 = new Parent();Parent p2 = new Parent();Parent p3 = new Parent();Parent p4 = new Parent();
        
        
        p.run();p1.run1();p2.run2();p3.run3();p4.run4();
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

class Child extends Parent {
    /*String run()

    {
        return  null;
    } */
}

//Overriding same method name with different return type will give compilation errors


