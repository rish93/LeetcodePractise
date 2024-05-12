package com.designpatterns;

import com.Practise.Department;
import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;

/* *
*  We must implement Cloneable interface.
*  We must override clone() method from Object class.(It is weird. clone() method should have been in Cloneable interface.)
*  */
public class CloningExamples {
    public CloningExamples() throws CloneNotSupportedException {
    }

    //shallow cloning
    //refer below employee department
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee emp1= new Employee("rish",873874939,new Organization("DB","MG road"));
        Employee emp2 = (Employee) emp1.clone();
        System.out.println(emp1);
        System.out.println(emp2);

        emp2.setContact(23232);
        System.out.println(emp1.getContact()); //primitive type only clone contact changed which is correct
        System.out.println(emp2.getContact());

        emp2.getOrg().name="GE";
        System.out.println(emp1.getOrg().name); //both name got changed tp GE not correct
        System.out.println(emp2.getOrg().name);





        //deep cloning

        School school = new School("Modern","Aliganj",new Students("Rish","12th"));
        School school1= (School) school.clone();
        school1.getStudents().name="Harsh";

        System.out.println(school.getStudents().name); //both student name will not changed
        System.out.println(school1.getStudents().name);
    }



}


class Employee implements Cloneable{
    private String name;
    private Integer contact;
    private Organization org;
    Employee(String name, Integer contact, Organization org){
        this.contact = contact;
        this.name = name;
        this.org = org;
       }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

    public Organization getOrg() {
        return org;
    }

    public void setOrg(Organization org) {
        this.org = org;
    }
}
class Organization{
    String name;
    String address;
    Organization(String name, String address){
        this.address = address;
        this.name = name;

    }
}


//for deep cloning
class School implements Cloneable{
    String name;
    String address;
    Students students;
    School(String name, String address, Students students){
        this.name = name;
        this.address = address;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        School school = (School) super.clone();
        school.setStudents((Students) school.getStudents().clone());
        return school;
    }
}
class Students implements Cloneable{
    String name;
    String inClass;

    Students (String name, String inClass){
        this.inClass = inClass;
        this.name= name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}



