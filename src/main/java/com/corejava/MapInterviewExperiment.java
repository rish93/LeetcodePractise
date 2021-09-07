package com.corejava;

import java.util.HashMap;
import java.util.Map;

public class MapInterviewExperiment {
    public static void main(String[] args) {
        Map<Employee, String> map = new HashMap<>();
        Employee e = new Employee("shiva", 22);
        Employee e1 = new Employee("ram", 25);
        Employee e2 = new Employee("rahim", 25);
        Employee e3 = new Employee("parvati", 25);
        Employee e4 = new Employee("lax", 25);

        map.put(e, "India");
        map.put(e1, "UK");
        map.put(e2, "BNG");
        map.put(e3, "AUS");
        map.put(e4, "USA");
        e2 = new Employee("rahim", 25);
        map.put(e2, "BNG");
        System.out.println(e.hashCode()+""+e1.hashCode()+""+e2.hashCode());
        System.out.println(map.get(e2));
        System.out.println(String.valueOf(map.size()));
/*        int[] elements = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String a = "India is mi countri";
        System.out.printf(String.valueOf(Arrays.asList(a.toCharArray()).stream().filter(elem-> elem.equals("i")).count()));*/

        // System.out.printf(String.valueOf(map.size()));
    }
}
