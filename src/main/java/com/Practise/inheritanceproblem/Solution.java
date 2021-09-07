package com.Practise.inheritanceproblem;

public class Solution {
    public static void main(String args[]) {

        /*Bird bird = new Bird();
        bird.walk();
        bird.fly();*/
        //bird.sing();
        // parent refrence cannot call child object but child can call all parent object
        Animal animal = new Animal();
        animal.walk();

        //child refernce cannot hold parent reference
        /*Bird animalb = (Bird) new Animal();
        animalb.fly();*/

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