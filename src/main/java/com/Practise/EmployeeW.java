package com.Practise;

public final class EmployeeW {

    private final String name;
    private final int age;
    private final Department department;

    public EmployeeW(String name, int age, Department department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Department getDepartment() {
        Department deptTemp = new Department(department.getName());
        return deptTemp;
    }
}
