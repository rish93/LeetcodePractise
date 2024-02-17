package com.pra23;

import java.util.*;

public class Deloitte {


    /*
    HELLO
    H-1, E-1 L-2, O-1
    * */
    public static void main(String[] args) {
//        String inp="HELLO";
        String inp="NAVIGATE";
        Map<Character,Integer> res= new TreeMap<>();

        char[] cr= inp.toCharArray();
        int count=0;
//        List<Character> ls = new ArrayList<Character>();

        for(int i=0;i< inp.length();i++)
        {

            if(res.get(cr[i])!=null )
               res.put(cr[i],  res.get(cr[i])+1);
            else
              res.put(cr[i], 1);

        }

//select SUBSTRING(empName,1,4) from emplpyee;
//
//Depar>>emp( 2nd highest)

//       Select salary from Depart (select salary , empname from Department where  max() group BY departmnt
//        Second hishest slaary from each dpartment
//       select empName, sal from Department where name IN (select EmpName from Department);
        //Restcontroller vs controller
        /*@Controller is used to declare common web controllers which can return HTTP
        response but @RestController is used to create controllers for
        REST APIs which can return JSON*/

//        for(int i=0;i<cr.length;i++){
//
//            for(int j=0;j<cr.length;j++){
//                if(cr[j] == cr[i]) {
//                    count++;
//                    res.put(cr[i], count);
//
//                }
//            }
//
//        }
        System.out.println(res);
    }

    //authentication in spring boot
    //hash map >> same hashcode different key what will happen
    //opring multithrwead with even and odd in alternate eg 1,2,3 ,4,5,
    //return from fnally and in try :::>>>> finally one will override return

   /* The output is always 2, as we are returning 2 from the finally block. Remember
    the finally always executes whether there is a exception or not. So when the finally
    block runs it will override the return value of
    others. Writing return statements in finally block is not required, in fact you should not write it.




    can we override static method: no
    Static methods can not be overridden because they are not part of the
     object's state. Rather, they belongs to the class (i.e they are class methods).
      It is ok to overload static (and final) methods.
    */

}
