package com.javatopics.oops;


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
