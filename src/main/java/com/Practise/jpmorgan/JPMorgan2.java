package com.Practise.jpmorgan;


//import com.Practise.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



/* TABLE
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

/*
 🔍 Issues in the Current Design

1. ❌ Student is used as a key in a HashMap without equals() and hashCode()

By default, Java uses object identity for hashing and equality unless you override equals() and hashCode().

Since Student lacks those, this will lead to unexpected behavior:

Student s1 = new Student("John", "NY");
Student s2 = new Student("John", "NY");

map.get(s2); // returns null, even if s1 was inserted with same name/location

🛠️ Fix: Override equals() and hashCode() in Student (based on meaningful fields like name and location).

2. ❌ No encapsulation of behavior or relationships

The association between students and schools is stored in an external Map<Student,
List<School>>, but that relationship logically belongs to Student or School.

This is a procedural-style design, not object-oriented.

🛠️ Suggestion:
	•	Move the relationship logic into either Student (e.g. List<School> schools)
	    or use a proper association class like Enrollment if you need richer context.

3. ❌ Method addStudent(Student, School) has misleading name

It seems to mean “associate this school with a student”, but the name suggests you’re creating a new student.

🛠️ Suggestion: Rename it to something like:

void assignSchoolToStudent(Student student, School school)


4. ❌ No constructor, immutability, or validation

Both Student and School are missing:
	•	Constructors
	•	final fields for immutability
	•	Input validation (e.g. no null names)

This makes the classes error-prone and hard to use safely.

🛠️ Suggestion:

class Student {
    private final String name;
    private final String location;

    public Student(String name, String location) {
        this.name = Objects.requireNonNull(name);
        this.location = Objects.requireNonNull(location);
    }

    // equals and hashCode here
}

✅ Alternative: Better Object-Oriented Model

Instead of maintaining the relationship in a Map, let’s model it more naturally:

class Student {
    private final String name;
    private final String location;
    private final List<School> schools = new ArrayList<>();

    public void enroll(School school) {
        schools.add(school);
    }

    public List<School> getSchools() {
        return Collections.unmodifiableList(schools);
    }
}

Now each student “owns” their school list. You avoid map maintenance and gain encapsulation.


✅ When to Use Map<Student, List<School>>

It’s still valid if:
	•	You don’t control the Student class (e.g., third-party library)
	•	You need fast lookup and don’t need object modeling
	•	It’s a temporary structure in a service layer

But even then, you must override equals() and hashCode() on Student.



  */
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


/*
Thanks for sharing your class hierarchy! You’re trying to model an organizational structure with:
	•	An abstract AbsEmployee base class extended by Employee
	•	A Department hierarchy: Department → Roles → Pm / SeniorPm
	•	And in the client code, you want to fetch an AbsEmployee by employee ID.

⸻

✅ Let’s clarify and correct your design with best practices:

⸻

🏗 Your Class Structure (Refined)
public abstract class AbsEmployee {
    protected String name;
    protected String empId;

    public AbsEmployee(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public String getEmpId() {
        return empId;
    }
}
public class Employee extends AbsEmployee {
    private String email;
    private boolean hybrid;

    public Employee(String empId) {
        super(empId);
    }

    public Employee(String email, boolean hybrid) {
        super(null); // you can derive empId or add a setter
        this.email = email;
        this.hybrid = hybrid;
    }

    public String getEmail() {
        return email;
    }

    public boolean isHybrid() {
        return hybrid;
    }
}

public abstract class Department {
    protected String name;
    protected String departmentId;

    public String getDepartmentId() {
        return departmentId;
    }
}

public class Roles extends Department {
    // Additional role-related fields
}

import java.util.List;

public class Pm extends Roles {
    private List<Employee> employeeList;

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}

import java.util.List;

public class SeniorPm extends Roles {
    private List<Employee> employeeList;

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}

public class ClientApp {
    public static void main(String[] args) {
        // Fetching an employee by ID
        AbsEmployee employee = new Employee("2342");

        // Now you can call methods declared in AbsEmployee or overridden
        System.out.println("Employee ID: " + employee.getEmpId());
    }
}🔍 Notes & Design Improvements

✅ Use AbsEmployee employee = new Employee("2342");:
	•	This is polymorphism in action.
	•	You can access any method defined in AbsEmployee (like getEmpId() or getName()).

⸻

✅ Use Factory or Service to Get Employee (Optional, for real-world)
AbsEmployee emp = EmployeeService.getById("2342");

✅ Avoid Redundant empId in Both AbsEmployee and Employee
	•	It’s already in the base class — remove duplicate field in Employee.

⸻

🔁 If You Need to Search Employees by ID (e.g., from Roles or Department):

public Employee findEmployeeById(List<Employee> list, String empId) {
    for (Employee e : list) {
        if (e.getEmpId().equals(empId)) return e;
    }
    return null;
}

✅ Summary
Goal                          Approach
Use base class reference   AbsEmployee emp = new Employee("id");
Store hierarchy cleanly    Use composition or inheritance as needed
Access employee data       Through base class or polymorphic methods
Avoid field duplication    Keep empId only in AbsEmployee
Better creation logic      Use a factory or service layer for lookup



*/












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



/*
To allow the client app to retrieve all employees from a department without
modifying internal structures, you should follow the encapsulation and information
hiding principles — and expose behavior via an interface or inheritance.


✅ Problem Summary:
	•	You have two independent classes: Department and Employee.
	•	You want to let the client retrieve List<Employee> from a Department.
	•	But you don’t want to expose internal fields, or change internal structures.

⸻

✅ Recommended Design

Use an abstraction layer, like an interface or a base class (Loader), which declares a contract for loading employees.

📦 Step-by-Step Plan:

⸻

🔶 1. Define a Loader Interface or Abstract Class
public abstract class Loader {
    public abstract List<Employee> getEmployees();
}
Or if you prefer interfaces:

public interface Loader {
    List<Employee> getEmployees();
}

🔷 2. Department extends Loader and internally manages employees

public class Department extends Loader {
    private String name;
    private String location;

    // Internal storage (can be DB call, static list, or injected service)
    private final List<Employee> employeeList = new ArrayList<>();

    public Department(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return Collections.unmodifiableList(employeeList);
    }
}

🔶 3. Employee class (untouched)
public class Employee {
    private final String name;
    private final String location;

    public Employee(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return name + " from " + location;
    }
}

🚀 4. Client Usage (No internal knowledge required)

public class ClientApp {
    public static void main(String[] args) {
        Department dept = new Department("Engineering", "NY");

        dept.addEmployee(new Employee("Alice", "NY"));
        dept.addEmployee(new Employee("Bob", "SF"));

        Loader loader = dept; // Polymorphism in action!

        for (Employee e : loader.getEmployees()) {
            System.out.println(e);
        }
    }
}

✅ Benefits
Principle                  Application
Encapsulation            Client sees only what Loader exposes
Polymorphism             Client uses Loader, not concrete Department
Open/Closed Principle    You can swap in a different implementation of Loader later
No structural changes    Employee remains untouched, and Department just implements a contract

*/

    }
}
