package com.Practise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CAE {

    public static void main(String[] args) {
      
     // List< List >ls= List.of(1,2,3,4,5,6,7,8,9,10);
       // ls.iterator();

        //ls.stream().//.collect(Collectors.toList());
        //ls.stream().flatMap(ls ->ls.stream).collect(Collectors.toList());

        //what is supplier in stream..//we get stream already openend, how that happen how to prevent
        //difference between jpa and hibernate annotation which to use
        //which exception occurs when autowiring two bean in variable (when qualifie r is not used)
        //create your iterator, implement concurrent modififcation exception
        // show Jpa relation departent and employee. (values used in )
        //how you will get to know how muh memry needed in applictaion (heap size), which part uses more
        //how to make sure multithreading env works smooth
        //which design pattern you created

    }

    class icustomIterator{

        icustomIterator(List<Integer> ls){
          //  lsCopy=  List.copyOf(ls);

        }
        int i=0;
        List<Integer> lsCopy= new ArrayList<>();

       Integer next(){


            if( lsCopy.get(i)%2 ==0)
                return i;

            i++;

            return null;
        }
       boolean hasNext(){
            return lsCopy.size()!=0;
        }

    }

    /*
    * class Department{
    *  @Id
    * privat Integer id*
    *
    * * *
    *   @OneTOMany
    *   List<Employee>;
    *
    *
    *
    * * * * }
    *
    * class Employee{
    *
    *   @manyToOne(name ="department_name", )
    *   Dparment dep
    *
    * * * * * }
    * * * * */



}
