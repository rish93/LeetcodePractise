package com.Practise;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.List;

public class AltemetrikInterview {

    public static void main(String[] args) {
        /*
        * int[] arr1={7,5,6,1,4,2};
        Second largest element in the array : 6*/
        int arr[]= new int[]{7,5,6,1,4,2};
        int max= Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
           max= Math.max(max, arr[i]);
        }
        int secondMax =Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=max)
                secondMax= Math.max(secondMax, arr[i]);
        }

        System.out.println(secondMax);

        List<EmployeeTemp> empList = new ArrayList<>();
        EmployeeTemp employeeTemp = new EmployeeTemp();
        employeeTemp.setAge(31);
        employeeTemp.setSalary(43222);
        employeeTemp.setEmpId(1);
        empList.add(employeeTemp);
        Integer s=  empList.stream().filter(employee ->
              employee.age>30
                && employee.salary>3000)
               .map(EmployeeTemp::getEmpId).findFirst().get();


        /*find out the missing no from given {1,3,4,2} missing no is 5*/

        int arr2[]= new int[]{1,3,4,2};
        int s1= 15;
        for(int i=0;i<arr2.length;i++){
            s1-=arr2[i];
        }
        System.out.println(s1);

//        select emp.salary,emp.name from Employee emp where
//                emmp>( select * from Employee e LIMI 2 DESC)


    }



}

class EmployeeTemp{
    Integer empId;
    Integer salary;
    Integer age;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    /*empId;
salary;
Age;*/

//[7:21 PM] Rohit Subhash Jannawar
//Give the employee having age>30 and salary >30000 and find out first employee and return empid
}



//output
class A
{
    void m1()
    {
        System.out.println("In m1 A");
    }
}
class B extends A
{
    void m1()
    {
        System.out.println("In m1 B");
    }
    void m2()
    {
        System.out.println("In m2 B");
    }
}
 class Test {
    public static void main(String[] args) {
        A a=new B();
//        a.m2();  compilation error Cannot resolve method 'm2' in 'A'
        /*There will be compile-time error. Even though we are assigning B’s object to A’s reference we can call only methods which are in A from A’s reference.*/
    }
}



//*tell output*/
 class Customer {
    String name;
    int age;
    Customer(String name,int age)
    {
        this.name=name;
        this.age=age;
    }
    public static void main(String[] args) {
        Customer c1= new Customer("John",20);
        Customer c2= new Customer("John",20);
        HashSet<Customer> customerSet=new HashSet<>();
        customerSet.add(c1);
        customerSet.add(c2);
        System.out.println(customerSet.size());
        //if we override hashcode and equals it then size wil be 1
    }}

