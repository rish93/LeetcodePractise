package com.Practise;

import lombok.Data;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class VisaTest {

    public static void main(String[] args) {

//* class without public how it is different*/
        //I have noticed that if don't write public before a class
        // its works same as like a public class.
        //No it doesn't. Unless it's public, the class won't be
        // visible to other code which isn't in the same package.
        // The default accessibility (which can't be specified explicitly)
        // is that a class (or other member) is only visible to other code
        // within the same package.

        //private class
        //only if it is inner class

        //protected class
        //not possible

        //how much is traffic in your application

        //transactional usage
    }

















    /*
    * Round 1:
Q1) how to add time taken by an endpoint without adding calculation logic in every controller method.
Q2) what is the n+1 problem in hibernate? how is it resolved?
Q3) 1 coding question: https://www.geeksforgeeks.org/find-maximum-meetings-in-one-room/
Q4) Design a Youtube
Answer Question
Round 3:
Q1) Count the number of occurrences (or frequency) of a number in a sorted array.
Solution: https://www.geeksforgeeks.org/count-number-of-occurrences-or-frequency-in-a-sorted-array/
Q2) Design a TinyUrl System
Answer Question
Round 5:
This was an offline round. 3 question were shared on mail and had to revert with a solution.

1. Algo question:

· N people, M restaurants, on a one-dimensional street. All the people are to meet at one restaurant, find the restaurant, where total travel distance from all people to that restaurant is the shortest among all restaurants.

· The problem can be solved with brutal force with O(n*m) complexity. The question is how to solve it faster than brutal force.

· Describe the algorithm, and why it is better than brutal force. Coding is not required

2. Coding question:

· Binary tree in memory (not sorted, not balanced), write code to serialize the binary tree to disk, then deserialize from disk and re-construct in memory.

· Runnable code is required. You may use any language you like. You may also decide the format on disk.

3. System design:

· 1 million backend server that serves search traffic (think it as search service by google).

· 10k frontend servers – the FE servers intend to act as load balance the incoming traffic to the BE servers.

· Incoming traffic to the 10k FE servers are not balanced: there can be cold FE servers and hot FE servers

· Design the system/algorithm, where the traffic to BE servers are balanced.

· The design should be within today’s computer architecture, ideally without centralized components.
    *
    * Finding the longest palindromic substring in a given string
    *
    *
    * Round 1
==========
1. Count minimum number of fountains to be activated to cover the entire garden
2. Minimum possible sum of array elements after performing the given operation

Round 2
================
1.Reverse an Integer
2.Implement LRU cache
3.How can you reduce shuffling in spark
4. What are the various standards for Micro Service ?
5.Difference between REST and SOAP?


Round 2
=================
1.Implement HashMap
2. Find nearest Cofee Machine
3.Explain structure of parquet file
4.What is run length encoding in parquet file
5.Which compression technique you use
6.What is the advantage of splittable in hadoop
7.What information does memory of namenode carry
8.What mechanism does spark use to communicate between Driver and Executor ?

Round 3
===========================
1.Find Max Depth of Binary Tree
2.Coin Change
3.How HA is achieved in Hadoop
4.What is the function of Zookeeper
5..Have you used Spark Streaming

Round 4
==============
Design Youtube
    *
    * >Design Need for Speed
>Design HeatMap
    * */
}


 class Test1910 {

    public static void main(String[] args) throws FileNotFoundException {
        List<Student> studList = new ArrayList<>();
        Student s1 = new Student(101, "Pass", 35);
        Student s2 = new Student(101, "Max", 95);
        Student s3 = new Student(101, "Second Highest", 89);
        Student s4 = new Student(101, "Fail", 22);
        studList.add(s1);
        studList.add(s2);
        studList.add(s3);
        studList.add(s4);
        System.out.println("Data:" + studList);


//serialize & deserialize  a class
        /*
        *       Person person = new Person();
                person.setAge(20);
                person.setName("Joe");

                FileOutputStream fileOutputStream
                  = new FileOutputStream("yourfile.txt");
                ObjectOutputStream objectOutputStream
                  = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(person);
                objectOutputStream.flush();
                objectOutputStream.close();

                FileInputStream fileInputStream
                  = new FileInputStream("yourfile.txt");
                ObjectInputStream objectInputStream
                  = new ObjectInputStream(fileInputStream);
                Person p2 = (Person) objectInputStream.readObject();
                objectInputStream.close();

                assertTrue(p2.getAge() == person.getAge());
                assertTrue(p2.getName().equals(person.getName()));*/



//        File file = new File("C:\\de\\ede");
//        OutputStream stream = new FileOutputStream(file);
//
//        Files.write(file.getPath(),Student.);
//
// Student //marks
//  select st.name, mr.value  from   Student st Marks mr  where st.id = mr.studentId and mr.value  = (select  mr.value LIMIT 1 DESC)

//        studList.stream().sorted(Comparator.reverseOrder()).limit(2).skip(1).findFirst();
//        System.out.println(  studList.stream().sorted(Comparator.reverseOrder().thenComparing((o1, o2) -> o1.compareTo(o2))).skip(1).findFirst();
//        studList.stream().
    }








    @Data
    public static class Student implements Serializable {
        private int sno;
        private String sname;
        private int marks;
        public Student(int sno, String sname, int marks) {
            this.sname = sname;
            this.sno = sno;
            this.marks = marks;
        }




        public int getSno() {
            return sno;
        }




        public void setSno(int sno) {




            this.sno = sno;




        }




        public String getSname() {




            return sname;




        }




        public void setSname(String sname) {
            this.sname = sname;
        }




        public int getMarks() {
            return marks;
        }




        public void setMarks(int marks) {




            this.marks = marks;




        }

        @Override
        public String toString() {




            return "Student [sno=" + sno + ", sname=" + sname + ", marks=" + marks + "]";




        }
    }
}



class Diagram{
    public void area(){
        System.out.print("FROM DIAGRAM");
    }
}

class Square extends Diagram{
    public void area(){
        System.out.print("FROM SQUARE");
    }
}

class Triangle  extends Diagram {
    public void area(){
        System.out.print("FROM TRIANGLE");
    }
}


class Circle  extends Diagram {
    public void area(){
        System.out.print("FROM CIRCLE");
    }
}

//cryptogram
//tokenization
