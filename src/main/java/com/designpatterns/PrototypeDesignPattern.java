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
    System.out.println(deutscheBahn.getSubsidiaryCompanies()); //Infraview, DB Systel
    System.out.println(deutscheBahnCloned.getSubsidiaryCompanies());// Infraview, DB systel, DB India


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
    public Object clone() throws CloneNotSupportedException {

//        List<String> tempList = this.getSubsidiaryCompanies();
//        this will get same list and addd to asme list


//        List<String> tempList = new ArrayList<>();
        //deep copying
//        for(String company:this.getSubsidiaryCompanies()){
//            tempList.add(company);
//        }
//or
//        List<String> tempList = new ArrayList<>(this.getSubsidiaryCompanies());
//        return new DB(tempList);

        //above snipper still return deep clone dobject, even if cloneabla interfae
        //ius removed, reasojn, it is manual deep clioning

        //correct way

        DB copy = (DB) super.clone();  // performs shallow copy
        copy.subsidiaryCompanies = new ArrayList<>(this.subsidiaryCompanies); // deep copy
        return copy;


    }
}

