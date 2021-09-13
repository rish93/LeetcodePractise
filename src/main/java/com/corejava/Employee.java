package com.corejava;

import java.util.Objects;

public class Employee {
    private String name;
    private int age;
    private String city;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }

    public Employee(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Objects.equals(name, employee.name) &&
                Objects.equals(city, employee.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, city);
    }

//TODo if the equal method is not overiden it calls the object class equal method and if we create a new Employee() then it treats as a new entry to map
    // else if we just assign Employee e.setName("Diffent name or same name") it updates the existing object


/*    @Override
    public int hashCode() {
        return 1;
    }*/   //TODO IF hash code is differnet for 2 equal objects then the value of the object is lost. we dont get the value

  /*  @Override
    public int hashCode() {
        return 1;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
