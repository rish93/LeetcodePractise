package com.AskedInInterview;

import com.corejava.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cognizant {

    public static void main(String[] args) {
        //how jwt token is signed
        //how authentication is done in jwt

        //@componentn in place of @repository@service
        //@lazy/eacger loafding in angular
            //what is cyclomatic :  https://www.geeksforgeeks.org/cyclomatic-complexity/

        //fucntional interface vs normal interface
        //how to create

        //@componentscan, @enableautoconfiguraton @configuration usage

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
