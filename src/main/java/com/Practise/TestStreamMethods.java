package com.Practise;

import java.util.*;
import java.util.stream.Collectors;

public class TestStreamMethods {

    public static void main(String[] args) {
        //get duplicate from streams
        ArrayList<Integer> numbersList
                = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8));

        List<Integer> listWithoutDuplicates = numbersList.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(Arrays.asList(listWithoutDuplicates).toString());

        //.Get set of cities for array of employees using stream API.
        List<Employee> employees = new ArrayList<>();
        Employee emp1 = new Employee(1,"Lucknow");
        Employee emp2 = new Employee(2,"Kolkata");
        Employee emp3 = new Employee(3,"Bangalore");

        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);


       Set<String> cities= employees.stream().map(Employee::getCity).collect(Collectors.toSet());
        System.out.println(cities);


    }
}

class Employee{
    private int id;
    private String city;

    public Employee(int id, String city) {
        this.id = id;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
