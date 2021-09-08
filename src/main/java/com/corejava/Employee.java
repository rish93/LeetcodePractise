package com.corejava;

import java.util.Random;

public class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                name.equals(employee.name);
    }*/

    //TODo if the equal method is not overiden it calls the object class equal method and if we create a new Employee() then it treats as a new entry to map
    // else if we just assign Employee e.setName("Diffent name or same name") it updates the existing object

/*    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }*/
/*    @Override
    public int hashCode() {
        return 1;
    }*/   //TODO IF hash code is differnet for 2 equal objects then the value of the object is lost. we dont get the value

    @Override
    public int hashCode() {
        return 1;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
