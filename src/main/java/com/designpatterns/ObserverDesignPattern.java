package com.designpatterns;

/*
Behaviourial Design pattern , whenever there is change in behaviour update me.

 *  for cases where there is Notifier and observer(which listens) code,
 *  we have observer design pattern
 * */
/*
 *  Use case when we have delivery System, which notifies at each step(to seller, buyer,warehouse)
 *  of Product dispatchment
 *  eg seller-> warehouse-> city warehouse
 *
 * */

import javax.security.auth.Subject;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * whenever there is change in location(ref. In delivery system),
 * It is updated in topic, and topic (notifies) updates all the observers
 *
 */

public class ObserverDesignPattern {
    /*
    * To implement have one Interface Observer (with one method update)
    *  All entities seller/user/warehouse will override this update
    *
    *
    * Have subject Interface with three method definition
    * 1) RegisterObserver 2) UnregisterObserver 3) Notify Observer
    * */

    /*topic register/unregister/notifyobserver for observer
    * Topic/Subject <------->      Observer   ->  has update method that does updation to implemented class
    *       |                    /    |    \
    *Price/Delivery         Seller  Buyer Warehouse
    * */
    public static void main(String[] args) {
        DeliveryData topic =  new DeliveryData();

        Observer sellerObserver =  new Seller();
        Observer userObserver =  new User();
        Observer warehouseObserver =  new DeliveryWarehouse();


        topic.register(sellerObserver);
        topic.register(userObserver);
        topic.register(warehouseObserver);

        topic.locationChanged();

        System.out.println();

        topic.unregister(warehouseObserver);
        topic.locationChanged();

    }
}


interface subject {
    void register(Observer obj);
    void unregister(Observer obj);
    void notifyObservers();
}
interface Observer {
    public void update(String location);
}

//this is topic where change in data happens
class DeliveryData implements subject{
    private List<Observer> observers;
    private String location;

    public DeliveryData(){
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer obj){ //register my observer to observer list
        observers.add(obj);
    }


    @Override
    public void unregister(Observer obj){//unregister my observer to observer list
        observers.remove(obj);
    }

    @Override
    public void notifyObservers() {
        for(Observer obj: observers) {
            obj.update(location);
        }
    }

    public void locationChanged(){
        this.location = getLocation();
        notifyObservers();
    }

    public String getLocation(){
        return "Location"+" at "+System.currentTimeMillis();
    }

}


class Seller implements Observer{
    private String location;
    @Override
    public void update(String location) {
        this.location = location;
        showLocation();
    }
    public void showLocation(){
        System.out.println("Notification at seller - Current Location"+location);
    }
}

class User implements Observer{
    private String location;
    @Override
    public void update(String location) {
        this.location = location;
        showLocation();
    }
    public void showLocation(){
        System.out.println("Notification at user - Current Location"+location);
    }
}

class DeliveryWarehouse implements Observer {
    private String location;
    @Override
    public void update(String location) {
        this.location = location;
        showLocation();
    }
    public void showLocation(){
        System.out.println("DeliveryWarehouse at user - Current Location"+location);
    }
}
