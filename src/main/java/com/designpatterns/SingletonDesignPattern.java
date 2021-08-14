package com.designpatterns;

//Desc:
//it is a creational design patterm
//only one instance of class should exists
//other classes should be able to get instance of singleton class
//Used in logging, cache Session , Drivers

/*
How to achieve:
Constructor should be private
Public method for returning instance
Instance type -private static
*/

public class SingletonDesignPattern {

  public static void main(String[] args) {

    //eagerInitialization
    SingletonEager inst= SingletonEager.getInstance();
    System.out.println(inst);
    SingletonEager inst1= SingletonEager.getInstance();
    System.out.println(inst1);

    //lazy inistialization
    SingletonLazy inst2= SingletonLazy.getInstance();
    System.out.println(inst2);
    SingletonLazy inst3= SingletonLazy.getInstance();
    System.out.println(inst3);

    //now if two thread try to get the instance
    //so both can access it finding instance is null
    //so make getInstance as synchronized and one thread access att a time
    //making other afinding as initialized
    SingletonSynchronized si= SingletonSynchronized.getInstance();
    System.out.println(si);

   //advance sychronized
    //why to make complete ethod synchronized
    //instead just block
    //block of write operation is made synchronized
    AdvanceSingletonSynchronized advanceSingletonSynchronized= AdvanceSingletonSynchronized.getInstance();
    System.out.println(advanceSingletonSynchronized);



    //Logger example
    CustomLogger customLogger = CustomLogger.getLogger("Hello");
    System.out.println(customLogger);


  }
}

class SingletonEager{
  //eagerly declaring and initializing
  private static SingletonEager instance=new SingletonEager();
  private SingletonEager(){}
  public static SingletonEager getInstance(){
    return instance;
  }
}

class SingletonLazy{
  //eagerly declaring and initializing
  private static SingletonLazy instance;
  private SingletonLazy(){}
  public static SingletonLazy getInstance(){
    if (instance == null) {
      instance = new SingletonLazy();
    }
    return instance;
  }
}


class SingletonSynchronized{
  private SingletonSynchronized(){}
  private static SingletonSynchronized instance=null;
  //make method as synchronized so one thread access at time
  public static synchronized SingletonSynchronized getInstance(){
    if(instance == null)
      instance = new SingletonSynchronized();
    return instance;
  }
}

class AdvanceSingletonSynchronized{
  private static AdvanceSingletonSynchronized instance;

  private AdvanceSingletonSynchronized(){}
  public static AdvanceSingletonSynchronized getInstance(){
    //only making object creation synchronized not complete method
    if(instance == null){
      synchronized (AdvanceSingletonSynchronized.class){
        if(instance ==null){
          instance = new AdvanceSingletonSynchronized();
        }
      }
    }
    return instance;
  }




}

class CustomLogger {
  private String msg;
  private static CustomLogger instance;
  private CustomLogger(String msg){
    this.msg=msg;
  }
  public static synchronized CustomLogger getLogger(String msg){
    if(instance ==null){
      instance = new CustomLogger(msg);
    }
    return instance;
  }

}
