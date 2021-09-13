package com.designpatterns;

//creational design pattern
//used when we have too many arguments
//& it's hard to maintaine order

//when we dont want to send all
//paraneter in object initialiation

//we send  optional parameters as null
//suppose we haveto make obj with 10 arg
//it's diff to maintain order


public class BuilderDesignPattern {
  // benefit:
  /* 1)
   * no need to maintaine order of arg,
   * builder parttern automaticaly handle order
   *
   *  2)
   * Not all parameter are mandatory
   * to provide and optional parameter are
   * taken care of
   * */

  public static void main(String[] args) {
    // how to create?
      /*
      * => Create static nested class which contains all
      * arg of outer class.
      * => If class is Vehicle builder class should be 'VehicleBuilder' (as per convention)
      * =>Builder class has public constructor with all required parameters
      * => Builder class should have methods for optional paramaters.
      *    method will return builder Object
      *
      * A build() method that will return the final Object.
      *
      * Restriction:
      * ->Main class 'Vehicle' has private construtor so to
      *  create instance only via Builder class.
      * ->Main class only has getters.
      *  */

      OnePlus onePlus5 = new OnePlus
          .OnePlusBuilder("OnePlus 5", "MattBlack")
          .setCamera("12MP")
          .setBluetooth("V1.2")
          .build();

      OnePlus onePlusNord = new OnePlus
              .OnePlusBuilder("OnePlus Nord", "Sepia Green")
              .setCamera("18MP").build();

      OnePlus onePlu6t = new OnePlus
              .OnePlusBuilder("OnePlus 6", "Grey")
                            .build();

      System.out.println(onePlu6t.getName()+" \n "+onePlus5.getName()+" \n "+onePlus5.getName());

  }
}

    class OnePlus{
    //req parameters
        private String color;
        private String name;

     //optional parameters
        private String camera;
        private String bluetoothVersion;

        public String getBluetoothVersion(){return  bluetoothVersion;}
        public String getColor() {
            return color;
        }

        public String getName() {
            return name;
        }

        public String getCamera() {
            return camera;
        }

        //make constrcutor as private so that
        //one need to use builder to intantiate
        private OnePlus(OnePlusBuilder builder){
            this.camera = builder.camera;
            this.color = builder.color;
            this.name = builder.name;
            this.bluetoothVersion = builder.bluetoothVersion;
        }

        public static class OnePlusBuilder{
            private String name;
            private String color;

            //optional
            private String camera;
            private String bluetoothVersion;

            //mandatory field should be through constructor
            public OnePlusBuilder(String name, String color){
                this.color = color;
                this.name = name;
            }

            //make setter for optional parameter
            public OnePlusBuilder setCamera(String camera) {
                this.camera = camera;
                return this;
            }

            public OnePlusBuilder setBluetooth(String bluetoothVersion) {
                this.bluetoothVersion = bluetoothVersion;
                return this;
            }

            public OnePlus build(){
                return new OnePlus(this);
            }


        }

    }

