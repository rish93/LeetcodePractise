package com.Practise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Nagarro {


    public static void main(String[] args) {


        List<List<Employee1>> empLs=new ArrayList<>();

       List<Employee1> result= empLs.stream().
               flatMap(employee1s -> employee1s.stream())
               .collect(Collectors.toList());
        //every empl of each dep  (use groupBy)
        Map<String ,List<String>> resMap= new HashMap<>();
        List<String> employeesList= new ArrayList<>();

//        Map<String, List<Employee1>> employeesByDept = employeesList.stream()
//                .collect(Collectors.groupingBy(Employee1::getDepartmentName));

        //        result.stream().map(employee1 -> resMap.put(employee1.getDepartmentName(),
//                    employeesList.add(employee1.getName()))).collect(Collectors.toList())
//                .collect(Collectors.toList());




//
//        fetc eager lay diff
//    cascading effect

    }

}


class Employee1{
    private String name;
    private String departmentName;
    private int age;
    private Double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
//one jvm multipod, for spng how many instance will be created

//how to stop actuator endpoint to be exposed
//stream vs forloop benefit