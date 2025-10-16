package com.javatopics.streams;

import com.corejava.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EverythingStreams {


    //https://medium.com/@basecs101/java-8-frequently-used-stream-methods-latest-interview-questions-126a7d370cfd
        //findings:
    /* https://yogeshbali.medium.com/important-considerations-for-integer-value-comparison-in-java-d90b25bf29bb
     For values within the range of -128 to 127, Java uses a cache for
     Integer objects to optimize memory usage. When comparing two Integer
     objects within this range, the “==” operator will return true if they
     have the same value, as they are referring to the same cached object.
     However, for values outside this range, Java creates separate Integer
     objects for each value. When comparing two Integer objects outside the
     range of -128 to 127 using the “==” operator, it will return false, even
     if they have the same
     value. This is because they are distinct objects in memory.
     To compare two Integer values in Java, it is recommended to use the equals()
     method or the intValue() method of the Integer class.



    Predicate:
    Predicate is a functional interface in Java that accepts exactly one
     input and can return a boolean value. Before going into it, we first
     need to understand the Functional Interface.

    *
    */
    public static void main(String[] args) {
        /*frequent methods*/
        //filter(), map(), skip(), count(), collect() and sum().
        //reduce(), max(), min(), peek(), sorted(), count(), dropWhile(),
        // distinct(), dropWhile(), limit(),

        List<Employee> listEmployeeeWithSalary = List.of(new Employee("Rishabh",32,
                "Bangalore", 310000, "ITDA"),

                new Employee("Prateek",36,
                        "Lucknow", 410000, "Workforce")

                ,new Employee("Sebastian",12,
                        "Seattle", 910000, "BCA"));


        //filter()
       List<Integer> listOfIntegers= List.of(34,2,3,4,5,6,23,324,5456);
       List<Integer> valList= listOfIntegers
               .stream()
               .filter(ls-> ls==5456 || ls.equals(2))
               .collect(Collectors.toList());
       System.out.println(valList);

       /* *
       --map()
       * The Stream API’s map() function returns a stream consisting of
       * the results of applying the given function to the elements of the
       * source stream.
       * */

        List<Integer> listOfIntegers1= List.of(34,2,3,4,5,6,23,324,5456);
        List<Integer> valList1= listOfIntegers
                .stream()
                .map(integer -> integer-1)
                .collect(Collectors.toList());
        System.out.print(valList1);
        System.out.println( listOfIntegers1
                .stream()
                .mapToDouble(integer -> integer)
                .boxed()//You could use boxed(). This maps a DoubleStream (Stream of primitive doubles, as returned by mapToDouble) to a Stream<Double>.
                .collect(Collectors.toList()));


       //
        String joined = List.of(21,8,1993).stream()
                .map(Object::toString)
                .collect(Collectors.joining("/ "));
        System.out.println(joined);



        int total = List.of(1,1,1).stream().mapToInt(value -> value).sum();
        System.out.println(total);
        int total1 =  List.of(1,1,1).stream()
                .collect(Collectors.summingInt(value -> value));
        System.out.println(total1);

        Map<Integer,List<Integer>> total2
                =  List.of(1,2,3,3).stream()
                .collect(Collectors.groupingBy(o -> o));
        System.out.println(total2+" total2");


        // Partition integer based on odd and even
        /*{false=[1, 3], true=[2]}*/
        Map<Boolean, List<Integer>> passingFailing
                =  List.of(1,2,3).stream()
                .collect(Collectors.partitioningBy(s -> s%2==0));

        System.out.println(passingFailing);


        /***************************************************************/
        //skip()
        System.out.println( List.of(1,2,3).stream()
                .map(integer ->
                    integer
                )
                .skip(1) //skips first ans [2,3]
                .collect(Collectors.toList()));

        //sorted
        //get second highest number
        System.out.println( List.of(45,43,21,54,4,56,6,1,2,3).stream()
                    .sorted((o1, o2) -> o2.compareTo(o1))
                    .skip(1)
                    .findFirst());


        //count()
        System.out.println( List.of(45,43,21,54,4,56,6,1,2,3).stream()
                        .filter(integer -> (integer>40 && integer<60))
                        .count());//or
                                  //.collect(Collectors.counting())

        //max salary group by department
        System.out.println(listEmployeeeWithSalary.stream()
                .max(Comparator.comparingInt(Employee::getSalary)).map(employee ->
                        employee.getDepartment()).get());

        System.out.println(listEmployeeeWithSalary.stream()
                        .max(Comparator.comparing(Employee::getSalary)).stream()
                        .collect(Collectors.groupingBy(employee -> employee.getDepartment())));



        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, new String( "Alice"));
        map1.put(2, new String("Bob"));

        Map<Integer, String> map2 = new HashMap<>();
        map2.put(3, new String( "Charlie"));
        map2.put(4, new String( "David"));


        // Merge maps
        Map<Integer, String> mergedMap = Stream.of(map1, map2)
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1, v2) -> v1));
        System.out.println(mergedMap);


    }



}
