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


/*
* public class Animal {
    public static void foo() {
        System.out.println("Animal");
    }
}

public class Cat extends Animal {
    public static void foo() {  // hides Animal.foo()
        System.out.println("Cat");
    }
}
Here, Cat.foo() is said to hide Animal.foo(). Hiding does not work like overriding, because static methods are not polymorphic. So the following will happen:

Animal.foo(); // prints Animal
Cat.foo(); // prints Cat

Animal a = new Animal();
Animal b = new Cat();
Cat c = new Cat();
Animal d = null;

a.foo(); // should not be done. Prints Animal because the declared type of a is Animal
b.foo(); // should not be done. Prints Animal because the declared type of b is Animal
c.foo(); // should not be done. Prints Cat because the declared type of c is Cat
d.foo(); // should not be done. Prints Animal because the declared type of d is Animal
Calling static methods on instances rather than classes is a very bad practice, and should never be done.

Compare this with instance methods, which are polymorphic and are thus overridden. The method called depends on the concrete, runtime type of the object:

public class Animal {
    public void foo() {
        System.out.println("Animal");
    }
}

public class Cat extends Animal {
    public void foo() { // overrides Animal.foo()
        System.out.println("Cat");
    }
}
Then the following will happen:

Animal a = new Animal();
Animal b = new Cat();
Cat c = new Cat();
Animal d = null;

a.foo(); // prints Animal
b.foo(); // prints Cat
c.foo(); // prints Cat
d.foo(): // throws NullPointerException
* * */


}
