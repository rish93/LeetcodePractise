package com.AskedInInterview;

import com.corejava.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cognizant {

    public static void main(String[] args) {
        //what is auth Gaurd
        //default and static method use in interface
        ///fucntioanl interface ad inner class
        ///get brean of same class, wiill get same or different bean
        //ngonchange vs ngDoCheck
        //*ngDoCheck() Detect and act upon changes that Angular can't or won't detect on its own. */
        //construcor in componentn in angular
        //pure impure pipes
        //


        //how jwt token is signed::
        // https://dev.to/kimmaida/signing-and-validating-json-web-tokens-jwt-for-everyone-25fb
       // https://dev.to/kimmaida/signing-and-validating-json-web-tokens-jwt-for-everyone-25fb

        //how authentication is done in jwt

        //@componentn in place of @repository
        // @service
        //*Readable
        //*Upgrade specific to component will be within each annotation
        //* Log intenral are segregated and easily maintained else difficult to find


        //@lazy/eacger loafding in angular
        /*
        Module loaded with application, or loadind lazily related to specific page like with children
        * */

            //what is cyclomatic :  https://www.geeksforgeeks.org/cyclomatic-complexity/

        //fucntional interface vs normal interface
        //how to create
/*
 Functional interface which has only one abstract method can be referenced in
        lambda funcitons
        eg2.
        public interface MyFunctionalInterface {
            public void execute();
        }


        MyFunctionalInterface interfaceTest = () -> {
            System.out.println("Executing...");
        }
 */


        //@componentscan, @enableautoconfiguraton @configuration usage
//The @EnableAutoConfiguration annotation enables Spring Boot to
// auto-configure the application context. Therefore, it automatically
// creates and registers beans based on both the included jar files
// in the classpath and the beans defined by us

        /*
        * class employee{
        *   name
        *  department
        *  salary*
        *  }
        *   //Map<> ofemply for employee list with name and department of highest salary
        *
        * */
        emp emp1= new emp("rishabh","BIETC",20000);
        emp emp2= new emp("prateek","Analytics",21000);
        emp emp3= new emp("prn","BCA",10000);
        emp emp4= new emp("dhw","ACD",200);
        emp emp5= new emp("dhw","DS",2120);


        List<emp> empList= new ArrayList<>();
        empList.add(emp1);
        empList.add(emp2);
        empList.add(emp3);
        empList.add(emp4);
        empList.add(emp5);

       Map<String,String> map= empList.stream()
               .max(Comparator.comparingInt(p -> p.salary))
               .stream()
               .collect(Collectors.toMap(emp -> emp.name, emp -> emp.department));


//        Map<String,String> map= empList.stream()
//                .max((p1, p2) -> Integer.compare(p1.salary, p2.salary))
//                .stream()
//                .collect(Collectors.toMap(emp -> emp.name, emp -> emp.department));
        System.out.println(map);
        //microservice disadvantage/bbenfit
        //spring boot benefit

    }
    static class emp{
        emp(String name, String department,Integer salary){
            this.department = department;
            this.name = name;
            this.salary = salary;

        }
        String name;
        String department;
        Integer salary;
    }
}
