package com.Practise.overriding;

public class ClassB extends ClassA {
    /*int doSomething()   //TODO Golden Rule:   we cannot override a STATIC method and make it non static
                                                and we cannot overide a normal method and make it static
    {
        return 2;
    }*/
     int doSomething()   //TODO cannot overirde a static method
    {
        return 2;
    }
    int doSomethingInB()   //TODO cannot overirde a static method
    {
        return 4;
    }

}
