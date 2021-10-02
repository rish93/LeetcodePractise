package com.Practise.overriding;

public class MainClas {
    public static void main(String[] args) {
        ClassA a = new ClassB();
        System.out.println(a.doSomething());
        /*System.out.println(a.doSomethingInB());*/  //PARENT CLASS object/reference cannot call the child method
        System.out.println(a.doSomethingInA());

        ClassB b = new ClassB();          // Child can call parent as well as child
        /*ClassB c = new ClassA();*/    // Child's object cannot hold parent Class Baap bete se bada nahi hota

       /// dont even think of overriding a final method you would get compile time error.


    }

}
