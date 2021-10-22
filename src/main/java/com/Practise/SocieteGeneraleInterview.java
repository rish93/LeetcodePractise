package com.Practise;

import lombok.Getter;
import lombok.Setter;

public class SocieteGeneraleInterview {

   static void method1(Student s)
    {
        s= new Student();
        s.setName("diben");
    }


    public static void main(String[] args) {
       //calling by value java TODO learn online

       Student s = new Student();
         s.setName("anup");
         method1(s);
         System.out.print(s.getName());
    }
    //what design pattern JPA uses

    //what design pattern you have worked on

    //sort the aray even first odd last // [0,2,4,6,1,3,5,79]

    //find element of array which is sum of two input n, m

    //suppose we have sum now, find two element which sums to it

    //oops concept

    //if we have default method in interface will it need to be implemented with implementation classes

    //why interface whn have abstract class

    //is string class thread safe

    //string buffer s1 = new String ("abhi") == new String buffer s2("abhi")  will it be same

    //equals method of object class checks reference or value

    //what is marker interface , functional interface

    //make a setup of spring boot for student table crud operations

    //worked on servlet


    //difference between for loop vs foreach loop and complexity
    //microservicedeisgn pattern
    //system design pattern
    //hysterix use
    //how to handle circuit breaker
    //how do you lock object
    //difference between spring and spring boot
    //aggregator(has a r/n) vs composiiton (is part of)
    //which API gateway you used. (nginx)
    //volatile keyword
    //orchestration design in microservice
    //what is ttransaction in spring boot, how you create transaction in spring boot

}

@Getter
@Setter
class Student{
   private String name;


}


/**  StudCourse
 *
 *  studId | CourseId
 *   A   |    1
 *   A   |    2
 *
 *
 * Stuent
 * id |  courseId | name | class
 * A   | 1    | Dib  | 12th
 * B   | 1   | Rish | 12th
 * C   | 2   | Dib  | 12th
 *
 *
 * Course
 * id | name     | studentId |
 * 1  | Physics |  A
 * 2  | Chemistry| B
 * Student table many to many mapping
 * a b c d
 * Course table many to many
 * 12345
 *
 *
 * select s.name, c.name from Student s, Course c where
 *select c.coursename,s.studnetName  from Student as s join Mapping as m on s.id =m.sid join
 * Course as c on m.cid = c.id where c.coursename = "computer"
 *
 *
 *  *select c.coursename,s.studnetName  from Student as s join StudCourse as m on s.id =m.sid in (
 *  * Course as c on m.cid = c.id where c.coursename = "computer")
 *
 *
 *  SELECT * FROM Meals
 * CROSS JOIN Drinks
 * OPTION (MERGE  JOIN )
 *
 * GO
 *
 * SELECT * FROM Meals
 * CROSS JOIN Drinks
 * OPTION (HASH  JOIN )
 *
 *
 *  namelist=empLits.stream().filter(e->e.getSalary()or Employee::emp.salary >5000)
 * .sort(Comparator.comparing(Employee:name))
 * .map(e-> e.getName())
 * .collect(Collectors.toList());
 */

