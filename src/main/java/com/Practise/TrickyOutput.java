//package com.Practise;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
//
////https://java2blog.com/java-interview-questions-for-5-years-experience/
//public class TrickyOutput {
//
//    public static void main(String[] args) {
//        Parent parent=new Child();
//        //parent.m2();  compilation error Cannot resolve method 'm2' in 'A'
//    /*There will be compile-time error. Even though we are assigning B’s
//     object to A’s reference we can call only methods which are in A
//     from A’s reference.*/
//
//        Parent1 parent1=new Child1();
//        parent1.m1();
//        /*A. In m1 B
//         This will work fine as ArrayIndexOutOfBoundsException and
//         IndexOutOfBoundsException are Runtime exceptions and there is
//         no rule for runtime exceptions while method overriding.*/
//
//
//        Parent3 parent3=new Child3();
//        try {
//            parent3.m1();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        /* Compile-time error
//        As IOException and Exception are checked exception,
//        so you can not broaden the scope of Exception while method overriding.*/
//    }
//}
//
//
////Q1
//class Parent
//{
//    void m1()
//    {
//        System.out.println("In m1 Parent");
//    }
//}
//class Child extends Parent
//{
//    void m1()
//    {
//        System.out.println("In m1 Child");
//    }
//    void m2()
//    {
//        System.out.println("In m2 Child");
//    }
//}
//
////Q2
//class Parent1
//{
//    void m1() throws ArrayIndexOutOfBoundsException
//    {
//        System.out.println("In m1 Parent1");
//    }
//}
//class Child1 extends Parent1
//{
//    void m1() throws IndexOutOfBoundsException
//    {
//        System.out.println("In m1 Child1");
//    }
//}
//
//
////Q3
//class Parent3
//{
//    void m1() throws IOException
//    {
//        System.out.println("In m1 A");
//    }
//}
//class Child3 extends Parent3
//{
//    void m1() throws Exception
//    {
//        System.out.println("In m1 B");
//    }
//}
//
//
////Q3
//
//class Parent4
//{
//    synchronized void m1()
//    {
//        System.out.println("In m1 A");
//    }
//    void m2()
//    {
//        System.out.println("In m2 A");
//    }
//
//}
//// There are two threads T1 and T2.
//// T1 is accessing m1 method. Will T2 be able
//// to access m2 method on the same instance at the same time?
//
////A
///*Yes, T2 will be able to access m2 as it does
//*  not require a lock to access m2 method.*/
//
//
//
////Q
//class Parent5
//{
//    synchronized void m1()
//    {
//        System.out.println("In m1 A");
//    }
//    synchronized void m2()
//    {
//        System.out.println("In m2 A");
//    }
//}
//
//  //  There are two threads T1 and T2
////  . T1 is accessing m1 method. Will T2 be
////  able to access m2 method on the same instance at the same time?
//
///*        No, T2 will not be able to access m2 as
//        it requires lock to access m2 method which
//         is already taken by T1 thread.
//*/
//
//
//
////Q6
//
//
//class Parent6
//{
//    synchronized static void m1()
//    {
//        System.out.println("In m1 A");
//    }
//    synchronized void m2()
//    {
//        System.out.println("In m2 A");
//    }
//}
//
//  /*  There are two threads T1 and T2. T1 is accessing m1 method. Will T2 be able to access
//      m2 method on the same instance at the same time?
//      Yes, T2 will be able to access m2 as it requires object level lock to access m2 method and
//      T1 thread has taken class level lock.You can read more about
//*/
//
//
//  //Q7
//
// class CustomerTestHashSet {
//
//    String name;
//    int age;
//
//     CustomerTestHashSet(String name,int age)
//    {
//        this.name=name;
//        this.age=age;
//    }
//    public static void main(String[] args) {
//
//        Customer c1= new Customer("John",20);
//        Customer c2= new Customer("John",20);
//
//        HashSet<Customer> customerSet=new HashSet<>();
//        customerSet.add(c1);
//        customerSet.add(c2);
//        System.out.println(customerSet.size());
//    }
//    //Output will be 2 as we did not implement hashcode and equals method in Customer class.
//    // getters and setters
//}
//
//
//
//public class Employee {
//    String name;
//    int age;
//
//    public Employee(String name,int age)
//    {
//        this.name=name;
//        this.age=age;
//    }
//
//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + age;
//        result = prime * result + ((name == null) ? 0 : name.hashCode());
//        return result;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj)
//            return true;
//        if (obj == null)
//            return false;
//        if (getClass() != obj.getClass())
//            return false;
//        Employee other = (Employee) obj;
//        if (age != other.age)
//            return false;
//        if (name == null) {
//            if (other.name != null)
//                return false;
//        } else if (!name.equals(other.name))
//            return false;
//        return true;
//    }
//
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public int getAge() {
//        return age;
//    }
//    public void setAge(int age) {
//        this.age = age;
//    }
//}
//
//public class HashMapMain {
//
//    public static void main(String[] args) {
//        Employee emp1=new Employee("Martin",27);
//        Map<Employee,String> hm=new HashMap<>();
//        hm.put(emp1, "Verified");
//        emp1.setName("John");
//        System.out.println(hm.get(emp1));
//    }
//}
///*Output will be null.
//We have implemented Employee’s hashcode and equals method using name and age attributes, so when you put emp1 as key in hashmap, it will use hashcode and equals method and will be put in HashMap.
//After putting emp1 in HashMop, we have changed name of the employee, so when you will try to retrieve element from HashMap using hm.get(emp1), you won’t be able to get object which we have put earlier and it will return null.
//*/
//
//
////Q
//
///*What is difference between Collection.synchronizedMap(map) and ConcurrentHashMap?
//
//When you make map thread safe by using Collection.synchronizedMap(map), it locks whole map object, but ConcurrentHashMap does not lock the whole map, it just locks part of it(Segment).
//
//* */
//
///*
//* public class IterateMapMain {
//
//    public static void main(String args[])
//    {
//        // HashMap with Country as key and capital as value
//        HashMap<String,String> map=new HashMap<String,String>();
//        map.put("India","Delhi");
//        map.put("Japan","Tokyo");
//        map.put("France","Paris");
//        map.put("Russia","Moscow");
//
//        // Iterating java iterator
//        System.out.println("Iterating java Iterator");
//        Iterator<String> countryKeySetIterator=map.keySet().iterator();
//        while(countryKeySetIterator.hasNext()){
//            String countryKey=countryKeySetIterator.next();
//            map.put("Nepal", "KathMandu");
//            System.out.println(countryKey);
//
//        }
//        System.out.println("-----------------------------");
//    }
//
//}
//
//Hide Answers
//You will get below output
//Iterating java IteratorException in thread “main” java.util.ConcurrentModificationException
//at java.base/java.util.HashMap$HashIterator.nextNode(HashMap.java:1489)
//at java.base/java.util.HashMap$KeyIterator.next(HashMap.java:1512)
//at org.arpit.java2blog.IterateMapMain.main(IterateMapMain.java:24)Japan
//Whenever you try to change count of Hashmap while iterating, it will
//* throw java.util.ConcurrentModificationException because we call iterator.next,it
//* checks for modCount and initial count, if it does not match it will throw ConcurrentModificationException.
//* */
//
//
////double check in singleton
///*
//public static Singleton getInstance()
//        {
//        if (_instance == null) { // Single Checked
//synchronized (Singleton.class)
//        {
//        if (_instance == null)// Double checked
//
//        {
//        _instance = new Singleton();
//        }
//        }
//        } return _instance;
//        }
//*/
// //       Let’s say two threads(T1 and T2) checked
////       for null and both reached at synchronized (Singleton.class).
////       T1 gets the lock and create instance of Singleton and return.
////       Now T2 enters in a synchronized block, as we have checked for null again,
////       it will not create object again.
