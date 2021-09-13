package com.designpatterns;


import java.util.ArrayList;
import java.util.List;

/*
* # Creational Design pattern
* # Used when you want to avoid multiple
*   Object creation of same instance; instead you copy the
*   new Object & then we can modify as per need
* */
public class PrototypeDesignPattern {
  // how to achieve
  /* object which we're copying should provide copying feature by
  implementing cloneable interface.

  we can override clone method to implement as per our need
  */

  public static void main(String[] args) throws CloneNotSupportedException {
    DB deutscheBahn = new DB();
    deutscheBahn.insertNewAquiredCompany();

    DB deutscheBahnCloned = (DB)deutscheBahn.clone();
    List<String> list = deutscheBahnCloned.getSubsidiaryCompanies();
    list.add("DB India");

//    System.out.println(list);
    System.out.println(deutscheBahn.getSubsidiaryCompanies());
    System.out.println(deutscheBahnCloned.getSubsidiaryCompanies());


  }
}

class DB implements Cloneable{
    /*Below program explains that If you will try to Clone an object
     which doesn’t implement the Cloneable interface,
     it will CloneNotSupportedException, which you may want to handle
      & make the Object.clone() method legal*/

    //original object is still intact and can modify new object

    private List<String> subsidiaryCompanies;

    public DB(){
        subsidiaryCompanies = new ArrayList<>();
    }

    public DB(List<String> list){
        this.subsidiaryCompanies = list;
    }

    public void insertNewAquiredCompany(){
        subsidiaryCompanies.add("Infraview");
        subsidiaryCompanies.add("DB Systel");
    }

    public List<String> getSubsidiaryCompanies() {
        return subsidiaryCompanies;
    }

    @Override
    public Object clone() {
        List<String> tempList = new ArrayList<>();
        //deep copying
        for(String company:this.getSubsidiaryCompanies()){
            tempList.add(company);
        }

        return new DB(tempList);
    }
}

