package com.corejava;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MapInterviewExperiment {
    public static void main(String[] args) {
        Map<Employee, String> map = new HashMap<>();
        Employee e = new Employee("shiva", 22, "kol");
        Employee e1 = new Employee("ram", 25, "chennai");
        Employee e2 = new Employee("rahim", 25, "mumbai");
        Employee e3 = new Employee("parvati", 25, "delhi");
        Employee e4 = new Employee("lax", 25, "lucknow");

        map.put(e, "India");
        map.put(e1, "UK");
        map.put(e2, "CANADA");
        map.put(e3, "AUS");
        map.put(e4, "USA");
        System.out.println( e2.hashCode());

//        if(map.containsKey("shiv"))

        e2 = new Employee("rahim", 25, "pune");
        map.put(e2, "BNG");
        System.out.println(e.hashCode() + "  " + e1.hashCode() + "  " + e2.hashCode());
        System.out.println(map.get(e2));
        System.out.println(String.valueOf(map.size()));

/*        int[] elements = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String a = "India is mi countri";
        System.out.printf(String.valueOf(Arrays.asList(a.toCharArray()).stream().filter(elem-> elem.equals("i")).count()));*/

        // System.out.printf(String.valueOf(map.size()));

        // given an employee object I need to sort them based on city descending and names in caps print it
        String s = null;
        if (s == "6")
            System.out.println(s);
        List<Employee> emplist = new ArrayList<>();
        emplist.add(e);
        emplist.add(e1);
        emplist.add(e2);
        emplist.add(e3);
        emplist.add(e4);
        emplist.stream().sorted(Comparator.comparing(Employee::getCity).reversed()).map(employee -> employee.getName().toUpperCase()).forEach(m -> System.out.println(m));

    }
}
