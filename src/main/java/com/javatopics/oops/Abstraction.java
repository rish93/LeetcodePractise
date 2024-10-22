package com.javatopics.oops;
//*
// An IS-A relationship is inheritance. The classes which inherit are known as sub classes or child classes. On the other hand, HAS-A relationship is composition.
//
//In OOP, IS-A relationship is completely inheritance. This means, that the child class is a type of parent class. For example, an apple is a fruit. So you will extend fruit to get apple.
//
//class Apple extends Fruit {
//
//}
//On the other hand, composition means creating instances which have references to other objects. For example, a room has a table. So you will create a class room and then in that class create an instance of type table.
//
//class Room {
//
//    Table table = new Table();
//
//}
//A HAS-A relationship is dynamic (run time) binding while inheritance is a static (compile time) binding.
// If you just want to reuse the code and you know that the two are not of same kind use composition. For example, you cannot inherit an oven from a kitchen.
// A kitchen HAS-A oven. When you feel there is a natural relationship like Apple is a Fruit use inheritance.
// *//



// provides security by hiding the internal implementation of a class
// and only exposing the details necessary in the context.

/*Defn: Abstraction captures only those details about a
 Java object that are relevant to the current perspective.

For example, a HashMap stores key-value pairs.
 It provides you two methods get() and put() methods
 to store and retrieve key-value pairs from map. It is,
 in fact, the only information you will need if you want
 to use the map in your application. How it works inside,
 you are not required to know it to use it. This is very
 much example of abstraction in Java
 */

/* * *
Type of extraction
*
*

2.1.1. Data Abstraction

>>>>>Data abstraction is the way to create complex data types from multiple smaller
 data types – which is more close to real-life entities. e.g.,
 An Employee class can be a complex object that has various small associations.

public class Employee
{
    private Department department;
    private Address address;
    private Education education;
    //So on...
}

So, if you want to fetch information about an employee, you ask from Employee object – as you do in real life, ask the person himself.

2.1.2. Control Abstraction

>>>> Control abstraction is achieved by hiding the sequence of actions for a complex task – inside a simple method call-
so the logic to perform the task can be hidden from the client and could
 be changed without impacting the client code.

public class EmployeeManager
{
    public Address getPrefferedAddress(Employee e)
    {
        //Get all addresses from database
        //Apply logic to determine which address is preferred
        //Return address
    }
}
* * * */
public class Abstraction {

    public static void main(String[] args) {
        Car carAudi = new Audi();
        Car carMercedez = new Mercedes();

        carAudi.defineCar("AUDI A90");

        carMercedez.defineCar("MERCEDES GT67");
    }

}

 class  Mercedes extends Car{
    String name;
    @Override
    void defineCar(String name) {
        this.name = name;
        System.out.println("This is Mercedez "+ name);
    }


    /*
      ** If we are making object of  class (Has a ) whose parent is abstract then
         it becomes anonymous class and overrride of abstract method(of parent class) is compulsory
    Mercedes mercedes = new Mercedes() {
        @Override
        void defineCar(String name) {

        }
    };

    ** If we are making object of abstract class (Has a ) then
       it becomes anonymous class and overrride of abstract method is compulsory
    Car car = new Car() {
        String name;
        @Override
        void defineCar(String name) {
            this.name = name;
        }
    };
*/
}

class Audi extends Car {
    String name;
    @Override
    void defineCar(String name) {
        this.name = name;
        System.out.println("This is Audi "+ name);
    }

//    Car car = new Car() {
//        String name;
//        @Override
//        void defineCar(String name) {
//            this.name = name;
//        }
//    };

}

abstract  class Car{
//    String name;
//    Mercedes(String name){
//        this.name=name;
//    }
  abstract void defineCar(String name);

}






/*it is mandatory to provide implementation of all super classes
* abstarct methods
*
* for abstract sub class (here cycle) it is not mandtory to provide
* implementation of superclass */
class HeroCycle extends Cycle{
    @Override
    void cycling() {
    }

    @Override
    void run() {
    }
}
abstract class Cycle extends Vehicle{
    abstract void cycling();
}
abstract class Vehicle{
    abstract void run();
}
