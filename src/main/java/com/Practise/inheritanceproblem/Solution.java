package com.Practise.inheritanceproblem;

public class Solution {
    public static void main(String args[]) {
        Animal mal= (Animal)new Bird(); //child can be casted to parent



        /*Bird bird = new Bird();
        bird.walk();
        bird.fly();*/
        //bird.sing();
        // parent refrence cannot call child object but child can call all parent object
        Animal animal = new Animal();
        animal.walk();

        //child refernce cannot hold parent reference
//        Bird animalb = (Bird) new Animal();  ////Parent cant be casted to child
//        animalb.fly();
        /*Exception in thread "main" java.lang.ClassCastException: class com.Practise.inheritanceproblem.Animal cannot be cast to class com.Practise.inheritanceproblem.Bird (com.Practise.inheritanceproblem.Animal and com.Practise.inheritanceproblem.Bird are in unnamed module of loader 'app')
            at com.Practise.inheritanceproblem.Solution.main(Solution.java:15)
        */

    }
}

class Animal {
    void walk() {
        System.out.println("I am walking");
    }
}

class Bird extends Animal {
    void fly() {
        System.out.println("I am flying");
    }

    void walk() {
        System.out.println("I am Bird walking");
    }
}

class Cat extends Animal {
    void fly() {
        System.out.println("I am flying");
    }

    void sing() {
        System.out.println("I am singing");
    }

    void walk() {
        System.out.println("I am Cat walking");
    }
}