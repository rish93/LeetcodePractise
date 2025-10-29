package com.javatopics.streams;

import com.corejava.Employee;

import java.util.*;
import java.util.function.Function;
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

        /*Frequently Asked Stream Programs */

        //find even number from List
        System.out.println("find even number from List > "+List.of(2,3,5,7,8,9,0)
                .stream()
                .filter(n-> n%2==0)
                .collect(Collectors.toList()));


        //Find numbers starting with 1
        System.out.println("find number starting with 1 > "+List.of(12,31,15,70,8,19,20)
                .stream()
                .map(String::valueOf)
                .filter(n-> n.startsWith("1"))
                .collect(Collectors.toList()));


        //Find duplicates in a list
        System.out.println("Find duplicates in a list > "+List.of(12,31,15,70,8,19,19,20,20)
                .stream()
                .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()))
                        .entrySet()
                        .stream()
                        .filter(n-> n.getValue()>1)
                        .map(entry-> entry.getKey())
                        .collect(Collectors.toList()));


        //Find first element of list
        System.out.println("Find first element of list > "+ List.of(12, 31, 15, 70, 8, 19, 20)
                .stream()
                .findFirst().orElse(null));


        //	Count elements greater than X
        System.out.println("Count elements greater than 10 > "+ List.of(12, 31, 15, 70, 8, 19, 20)
                .stream()
                .filter(s-> s>10)
                    .count());


        //Sort list in descending order
        System.out.println("Sort list in descending order > "+ List.of(12, 31, 15, 70, 8, 19, 20)
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList())
        );


        //Find frequency of each character
        String name="Rishabh Mankatala";
        System.out.println(name.chars()
            .mapToObj(c -> (char) c)
            .collect(
            Collectors.groupingBy(Function.identity(),Collectors.counting())
                 )
        );



        //Find first non repeated characters
        String name1="Rishabh Mankatala";
        System.out.println("Find first non repeated characters > "+name.chars()
                .mapToObj(c -> (char) c)
                .collect(
                        Collectors.groupingBy(Function.identity()
                                ,LinkedHashMap::new //to preserve order, without i hashmap not store order and rtesult in blank o/p
                                ,Collectors.counting())
                ).entrySet().stream()
                .filter(characterLongEntry -> characterLongEntry.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(null));

          //	Reverse each word in a sentence
          System.out.println("\tReverse each word in a sentence > "+
                Arrays.stream(name.split(" "))
                .map(word -> new StringBuilder(word).reverse().toString())
                        .collect(Collectors.joining(" "))
                );



            //find maximum and minimum
            System.out.println("Find  minimum > "+ List.of(12, 31, 15, 70, 8, 19, 20)
                            .stream()
                            .min(Comparator.naturalOrder())
                            .stream().findFirst()
                     );
            System.out.println("Find  maximum > "+ List.of(12, 31, 15, 70, 8, 19, 20)
                    .stream()
                    .max(Comparator.comparingInt(value -> value.intValue()))
            );


            //sum all elements
        System.out.println("sum all elements > "+ List.of(12, 31, 15, 70, 8, 19, 20)
                .stream()
                .mapToInt(value -> value).sum());


        //average all ewlements
        System.out.println("average all elements > "+ List.of(12, 31, 15, 70, 8, 19, 20)
                .stream()
                .mapToInt(value -> value).average());

        //square and filter>100
        System.out.println("square and filter>100 > "+ List.of(12, 31, 15, 70, 8, 19, 20)
                .stream()
                .map(value -> value*value).filter(ele->ele>100).collect(Collectors.toList()));


        //Highest paid employee
        class Employee {
            String name;
            String dept;
            double salary;

            Employee(String name,String dept, Integer salary){
                this.name=name;
                this.dept=dept;
                this.salary=salary;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDept() {
                return dept;
            }

            public void setDept(String dept) {
                this.dept = dept;
            }

            public double getSalary() {
                return salary;
            }

            public void setSalary(double salary) {
                this.salary = salary;
            }

            @Override
            public String toString() {
                return "Employee{" +
                        "name='" + name + '\'' +
                        ", dept='" + dept + '\'' +
                        ", salary=" + salary +
                        '}';
            }
        }

        List<Employee> employees =List.of(
                new Employee("Rishabh","ITDA",40),
                new Employee("Chris", "ITDA", 29),
                new Employee("Maria", "BCA", 20));

        System.out.println("Highest paid employee > "+ employees
                .stream()
                .max(Comparator.comparing((e1)-> e1.salary))
                .map(value -> value.name)
                .stream().findFirst());


        //group employee by department
        System.out.println("group employee by department > "+ employees
                .stream()
                .collect(
                        Collectors.groupingBy(Employee::getDept))
                        .keySet()

                );



        //Average salary per department
        System.out.println("Average salary per department > "+ employees
                .stream()
                .collect(
                        Collectors.groupingBy(Employee::getDept,
                        Collectors.averagingDouble(Employee::getSalary))
                ));



        //Find department with max employees
        System.out.println("Find department with max employees > "+ employees
                .stream()
                .collect(
                        Collectors.groupingBy(Employee::getDept,
                       Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .get()
            );




            //	List employee names as comma-separated string
            System.out.println("List employee names as comma-separated string > "+ employees
                    .stream()
                    .map(employee -> employee.name)
                    .collect(Collectors.joining(","))

            );


        //Sort employees by salary then name
         System.out.println("Sort employees by salary then name > "+ employees
                .stream()
                .sorted(Comparator.comparing(Employee::getSalary)
                        .thenComparing(Employee::getName))
                .collect(Collectors.toList())
         );

         List<List<Employee>> listoflist= new ArrayList<>();
         listoflist.add(employees);
         listoflist.add(employees);
         listoflist.add(employees);
        //Flatten a list of lists
        System.out.println("Flatten a list of lists > "+ listoflist
                .stream()
                .flatMap(employees1 -> employees1.stream())
                .collect(Collectors.toList())
        );



        //Find 2nd highest number
        System.out.println("Find 2nd highest number > "+ List.of(12, 31, 15, 70, 8, 19, 20)
                .stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()

        );


        //Find duplicate words in a sentence
        System.out.println("Find duplicate words in a sentence > "+
                Arrays.stream("Rishabh Rishabh Rishabh Mankatala".split(" "))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream().filter(stringLongEntry -> stringLongEntry.getValue()>1L)
                .collect(Collectors.toList())
        );



        //Partition numbers into even and odd
        System.out.println("Partition numbers into even and odd > "+
                List.of(12, 31, 15, 70, 8, 19, 20).stream()
                        .collect(Collectors.partitioningBy(inte-> inte%2==0))
        );

      }
    }
