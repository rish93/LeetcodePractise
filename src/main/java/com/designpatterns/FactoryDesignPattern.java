package com.designpatterns;


/*
*Part of creational design pattern
*Used when we have multiple sub classes of a super class
& based on input we have to return one class instance

* It provides abstraction between implementation
and client classes
* Remove the instantiation of client class from client code
 */

//factory class says give me type and
//will return object of that class

/*benefit.
*
* Abstarction between client classes and implementation
*
* */



public class FactoryDesignPattern {
/*
How to Implement?
#. Super class can be interface or abstract class or basic class
#. Factory class has a static method which return the instance of
Sub class based on input.
 */

  public static void main(String[] args) {
    //use case we have super class vehicle and want sub class instance based on input
    //i.e car, bike

    //create factory class of superclass it's subclass instance
    // based on input

      Vehicle car = VehicleFactory.getInstance("car", 4);
      System.out.println(car);
      Vehicle bike = VehicleFactory.getInstance("bike", 2);
      System.out.println(bike);

      // superclass can have many sub classes and hecne factory
      // is convenient to have instance on demand


  }
}

abstract class Vehicle{
  abstract int getWheel();

  public String toString(){
    return "Wheel: "+this.getWheel();
  }
}


class Car extends Vehicle{
  int wheel;

  Car(int wheel){
    this.wheel = wheel;
  }

  @Override
  int getWheel() {
    return wheel;
  }
}

class Bike extends Vehicle{
  int wheel;
  Bike(int wheel){
    this.wheel = wheel;
  }

  @Override
  int getWheel() {
    return wheel;
  }
}


class VehicleFactory{
  public static Vehicle getInstance(String type, int wheel){
    if(type.equals("car"))
      return new Car(wheel);
    else if(type.equals("bike"))
      return new Bike(wheel);

    return null;
  }


}


/*
*Real-time examples
This design pattern has been widely used in JDK, such as
1. getInstance() method of java.util.Calendar, NumberFormat, and ResourceBundle uses factory method design pattern.
2. All the wrapper classes like Integer, Boolean etc, in Java uses this pattern to evaluate the values using valueOf() method.
3. java.nio.charset.Charset.forName(),
* java.sql.DriverManager#getConnection(),
* java.net.URL.openConnection(),
*  java.lang.Class.newInstance(),
*  java.lang.Class.forName() are some of ther
* example where factory method design pattern has been
* used.
*
*  */
