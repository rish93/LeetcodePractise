package com.Practise;

public class TestAbstractClass {

    Foo f = new Foo(20) {
        @Override
        void iphone() {

        }
    };
//because there is an abstract method which has nothing so you can call that abstract method too.
// If we will create an object of the abstract class and calls the method having no body(as the method is pure virtual)
// it will give an error.
}


//  in particular in the try block of a try-with-resources statement and the compiler-generated finally block which closes the resource. In these situations, only one of the thrown exceptions can be propagated. In the try-with-resources statement, when there are two such exceptions, the exception originating from the try block is propagated and the exception from the finally block is added to the list of exceptions suppressed by the exception from the try block. As an exception unwinds the stack, it can accumulate multiple suppressed exceptions.


 abstract class Foo {

    Foo(int a){
        a=a+1;
    }
    abstract void iphone();
}
