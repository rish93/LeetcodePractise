package com.Practise.jpmorgan;


//import com.Practise.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



/*TABLE
* department
*    dpcode(pk), name , location,
*
* dep -> One to many with employe *
* many Empl -> one department   *
*
* Employee
*     code (pk),  dpcode (fk) , name , location,
*
*
*
* */
/* i/n
* select dep.name  from department dep, Employee emp   where  emp.dpCode!=dep.dpcode  ;
*
*     select   dep.name  from department dep,  Employee emp
*           *  where depcode==emp.depcode and  emp.id not in (select emp.id from Employee emp)
*
*
* * */


class Student1{
    private String name;
    private String location;
    /**
     * get set const
     */
}

class SchoolStudent{
//    Map<Student, List<School>> map= new HashMap<>(); //correct
//    void addStudent(Student student, School school){ //correct
//
//    }
//    List<School> getSchools(Student student){
//
//        return null;
//    }
}

class School{
    private String name;
    /**
     * get set const
     */
}


public class JPMorgan2 {

    public static void main(String[] args) {

        // r is pm


        /*
        * abstract class AbsEmployee
        *                name
         *               empId*
         *      |>   class Employee extends AbsEmployee{
        *                   email
        *                       employeeId*
        *                hybrid;
        *
        *           Employe(employeId) {
        *
        *             }
        *  Employe(email) {
         * * }*
        *                   *
        *               *
        *        * * }
        *
        * abstract class Department
        *           name
         *              departmentId**
         *      |>   class Roles extends Department{
         *
         *        }*
     *                      class Pm  extends Role{
         * *                        List<Employee> empyeList;
         *                 * }
         *                    class Senior Pm  extends Role{
         *                          List<Employee> empyeList;*
         * *                }
         *        * * *
        *
        *           AbsEmployee employee = new employee("2342");
        *           employee.name()
        *               *
    *
    *
        * */















//have two classes, design such that client app can consume and get all employees from department

        //suggestion 2
        //abstract class loader{
        //  nameLoder(name){
        //  }
        //  location(name){
        //        //  }
        // }

        //class department extend loader //suggestion 2
             /*   -> name
                  -> location

                  1) default method //suggestion 1
             */
        //class employee {
             /*   -> name
                  -> location
             */

        //sugestion 1
           /*   class EmpBuilder{
                      Department   department;

           }

            */
     //   }
        //class EmpDepaprt extends department{
        //
        //
        // }
    }
}
