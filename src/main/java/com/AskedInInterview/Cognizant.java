package com.AskedInInterview;

import com.corejava.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cognizant {

    public static void main(String[] args) {
        //what is auth Gaurd

          /*
          * In Angular, an Auth Guard is a type of route guard that is used to protect routes from unauthorized access. It helps control access to certain parts of your application based on authentication (e.g., whether a user is logged in) or authorization (e.g., whether a user has certain roles or permissions).

⸻

How Auth Guards Work

An Auth Guard is implemented using Angular’s CanActivate interface. When a user tries to navigate to a protected route, the guard runs and decides whether to allow or block the navigation.

⸻

Example Use Case

You want to prevent unauthenticated users from accessing the /dashboard route.

⸻Step-by-Step Example
	1.	Generate the guard:
	* ng generate guard auth
	*
	CanActivate
import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthService } from './auth.service'; // Custom service that handles auth logic

@Injectable({
  providedIn: 'root',
})
export class AuthGuard implements CanActivate {
  constructor(private authService: AuthService, private router: Router) {}

  canActivate(): boolean {
    if (this.authService.isLoggedIn()) {
      return true;
    } else {
      this.router.navigate(['/login']);
      return false;
    }
  }
}

	3.	Apply the guard to routes:
	 const routes: Routes = [
  { path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuard] },
];
Benefits
	•	Ensures unauthorized users can’t access protected views.
	•	Can be extended for role-based access (admin/user).
	•	Centralized route access control.

Would you like a working demo or to see how to use CanActivateChild, CanLoad, or CanDeactivate as well?
* * */

        //default and static method use in interface
     /*
     In Java, interfaces can have default and static methods (since Java 8). Here’s a clear breakdown of their use and purpose:

⸻

✅ Default Methods in Interfaces

📌 Purpose:
	•	To provide a default implementation so classes don’t have to implement it unless they want to override.

📄 Syntax:
interface MyInterface {
    default void defaultMethod() {
        System.out.println("Default method in interface");
    }
}
🧠 Key Points:
	•	Useful for interface evolution without breaking existing implementations.
	•	Classes implementing the interface can override this method.

🧪 Example:
interface MyInterface {
    default void show() {
        System.out.println("Showing from interface");
    }
}

class MyClass implements MyInterface {
    // Inherits show() unless overridden
}

🔗 Static Methods in Interfaces

📌 Purpose:
	•	To define utility methods related to the interface.
	•	Cannot be overridden or inherited.

📄 Syntax:

interface MyInterface {
    static void staticMethod() {
        System.out.println("Static method in interface");
    }
}

🧠 Key Points:
	•	Must be called using the interface name (not through object or class implementing the interface).

🧪 Example:

interface MyInterface {
    static void greet() {
        System.out.println("Hello from interface static method");
    }
}

class Test {
    public static void main(String[] args) {
        MyInterface.greet(); // Valid
    }
}

Feature      Default Method          Static Method
Inheritance  Yes (can be overridden)    No (not inherited)
Usage        Via implementing class     Via interface name
Purpose      Provide optional behavior  Utility/helper methods

      */


        ///fucntioanl interface ad inner class
/*✅ Functional Interface

📌 Definition:

        A functional interface is an interface with exactly one abstract method.

🧠 Key Point:
	•	Can have default and static methods.
	•	Annotated with @FunctionalInterface (optional but recommended).
	•	Enables usage of lambda expressions and method references.

🧪 Example:
@FunctionalInterface
interface Calculator {
    int operate(int a, int b);
}
✅ Usage with Lambda:
public class Main {
    public static void main(String[] args) {
        Calculator add = (a, b) -> a + b;
        System.out.println(add.operate(10, 5)); // Output: 15
    }
}

🔹 Inner Class in Java

An inner class is a class defined inside another class.

🔸 Types of Inner Classes:
	1.	Non-static inner class (regular)
	2.	Static nested class
	3.	Local inner class (inside a method)
	4.	Anonymous inner class

class Outer {
    class Inner {
        void show() {
            System.out.println("Inside inner class");
        }
    }
}
usage
Outer outer = new Outer();
Outer.Inner inner = outer.new Inner();
inner.show();

2. Anonymous Inner Class (commonly used with Functional Interfaces)

Great for implementing functional interfaces on the fly:

Calculator sub = new Calculator() {
    @Override
    public int operate(int a, int b) {
        return a - b;
    }
};
System.out.println(sub.operate(10, 4)); // Output: 6


Concept                 Description                          Example Use Case
Functional Interface     Interface with one abstract method      Runnable, Callable, custom logic
Inner Class              Class inside another class             Group logic, encapsulate helper class
Anonymous Inner Class    One-time use implementation           Callbacks, quick interface impl.


        */

        ///get brean of same class, wiill get same or different bean
/*

        In Spring, whether you get the same or a different bean instance of the same class depends on the scope of the bean.

⸻

✅ By Default: You Get the Same Bean

        Spring beans are singleton by default, which means:
	•	The same instance is returned every time you request the bean from the container.

⸻

🧪 Example:
@Component
public class MyService {
}

@Autowired
private ApplicationContext context;

public void test() {
    MyService a = context.getBean(MyService.class);
    MyService b = context.getBean(MyService.class);
    System.out.println(a == b); // true
}

🔄 If You Use @Scope("prototype")

You get a new instance every time:
@Component
@Scope("prototype")
public class MyService {
}

MyService a = context.getBean(MyService.class);
MyService b = context.getBean(MyService.class);
System.out.println(a == b); // false

🔍 Output: false – each call to getBean() returns a new object.

Scope Behavior   Same instance?
singleton (default)  One instance per Spring container  âœ… Yes
prototype      New instance every time    âŒ No
request / session   Used in web apps for each request/session   Depends


*/
        //ngonchange vs ngDoCheck

/*
        In Angular, both ngOnChanges() and ngDoCheck() are lifecycle hooks used to detect and respond to changes in component state—but they serve different purposes and are triggered under different circumstances.

⸻

🔁 ngOnChanges()

📌 Purpose:

        Called only when input-bound properties (@Input()) change.

🧪 Syntax:
ngOnChanges(changes: SimpleChanges): void {
  console.log('Changes:', changes);
}

✅ Use when:
	•	You want to react specifically to changes in input properties.
	•	You need to know what changed, with access to previous and current values.

🔁 Triggered:
	•	Every time an @Input() property changes by reference or value.

	🔎 ngDoCheck()

📌 Purpose:

Called during every change detection cycle, regardless of whether any input changed.

🧪 Syntax:

ngDoCheck(): void {
  console.log('Change detection triggered');
}

✅ Use when:
	•	You need custom change detection.
	•	You’re watching for changes that Angular doesn’t detect automatically (e.g., mutation inside objects/arrays).

⚠️ Caution:
	•	Runs very frequently — avoid heavy operations inside it.


Feature   ngOnChanges  ngDoCheck
Trigger
On @Input() property changes  Every change detection cycle
Granularity      Detects specific changes   General check (no details)
Performance    Efficient     More expensive (runs frequently)
Use case         Monitor @Input() updates     Detect deep/complex changes
Parameters     Yes (SimpleChanges)          No parameters

✅ Example Scenario:

If a parent sends an updated object:
@Input() user: User;

	•	If the object reference changes, ngOnChanges() is triggered.
	•	If you mutate a property inside user without changing the reference:
	•	ngOnChanges() is not triggered.
	•	But ngDoCheck() will run, and you can detect the internal change manually.

⸻📌 What is an “Object Reference”?

In JavaScript/TypeScript, objects are reference types. This means:
	•	Variables don’t hold the object itself, they hold a reference (pointer) to the object in memory.
	•	Two objects are only equal (===) if they point to the same memory location.

⸻example
@Input() user: any;
this.user = { name: 'Alice' };  // 🔁 New object (new reference)
This will trigger ngOnChanges() in the child component because Angular sees a new reference.


this.user.name = 'Bob';  // ❌ Same object, mutated property
The object reference didn’t change—only the contents did—so:
	•	ngOnChanges() will not run
	•	ngDoCheck() can still detect this if you implement custom logic


let userA = { name: 'Alice' };
let userB = userA; // userB points to the same object

userB.name = 'Bob';
console.log(userA.name); // Bob — same object!

let userC = { name: 'Charlie' }; // new object

Change Type   Triggers ngOnChanges()?    Triggers ngDoCheck()?
New object assigned to @Input()  âœ… Yes   âœ… Yes
Property inside object modified   Œ No   âœ… Yes



*/
        //*ngDoCheck() Detect and act upon changes that Angular can't or won't detect on its own. */
        //construcor in componentn in angular
        //pure impure pipes

        /*
     In Angular, pipes are used to transform data in templates. These can be pure or impure, and understanding the difference is important for both performance and correct behavior, especially with mutable data like arrays and objects.

⸻

✅ Pure Pipes (Default)

📌 What is a Pure Pipe?

A pure pipe is called only when the input value or its reference changes.

🔁 Angular calls it when:
	•	The input is a primitive (like number, string) and its value changes.
	•	The input is an object/array, and its reference changes (not just internal mutation).

🧠 Benefits:
	•	Highly performant — not called on every change detection cycle.

🧪 Example:
@Pipe({ name: 'capitalize' })
export class CapitalizePipe implements PipeTransform {
  transform(value: string): string {
    return value.charAt(0).toUpperCase() + value.slice(1);
  }
}

<p>{{ name | capitalize }}</p>

❌ Impure Pipes

📌 What is an Impure Pipe?

An impure pipe is executed every change detection cycle, regardless of whether the inputs change.

🔁 Angular calls it when:
	•	Any binding or event occurs, even if unrelated to the pipe input.

🧠 Use When:
	•	Your data is mutable (e.g., modifying an array/object without changing its reference).
	•	You want real-time updates, like filtering a list that’s being mutated.

⚠️ Downside:
	•	Performance hit — runs often, even unnecessarily.

🧪 Example:

@Pipe({
  name: 'filterUsers',
  pure: false // 👈 Impure pipe
})
export class FilterUsersPipe implements PipeTransform {
  transform(users: any[], search: string): any[] {
    return users.filter(u => u.name.includes(search));
  }
}

Feature            Pure Pipe                               Impure Pipe
Default behavior   Yes                                     No (pure: false)
When it runs       Only if input reference/value changes   Every change detection
Performance        High                                    Lower (use sparingly)
Use case            Static or reference-based data         Dynamic/mutated data


using impure pipe:

<input [(ngModel)]="searchText" placeholder="Search users..." />

<ul>
  <li *ngFor="let user of users | filterUsers:searchText">
    {{ user.name }}
  </li>
</ul>
@NgModule({
  declarations: [
    FilterUsersPipe,
    // other components/pipes
  ]
})
export class AppModule { }

import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filterUsers',
  pure: false  // 👈 Makes the pipe impure
})
export class FilterUsersPipe implements PipeTransform {
  transform(users: any[], search: string): any[] {
    return users.filter(user => user.name.toLowerCase().includes(search.toLowerCase()));
  }
}
This pipe runs on every change detection cycle (e.g., keystrokes, button clicks, etc.).
	•	Even if users array is mutated in-place, the pipe will still update the view.'

	⚠️ Performance Note:

Impure pipes run frequently and can slow down your app if used carelessly — use only when:
	•	You mutate arrays/objects without changing references.
	•	You need real-time updates in the view.


        */


        //how jwt token is signed::
        // https://dev.to/kimmaida/signing-and-validating-json-web-tokens-jwt-for-everyone-25fb


        //how authentication is done in jwt
/*
Great question! Let’s break down how authentication works with JWT (JSON Web Token) and how the token is signed for security.

⸻

✅ What is JWT?

A JSON Web Token is a compact, URL-safe token used to represent claims between two parties — often between a client and a server.

⸻

🔐 JWT-Based Authentication Flow

1. User Logs In
	•	User sends a POST request with credentials (username/password) to /login.

2. Server Verifies Credentials
	•	If valid, the server creates a JWT token with a payload (user ID, roles, etc.).

3. Token is Signed
	•	The JWT is signed using a secret (HMAC) or private key (RSA).
	•	This ensures the token cannot be tampered with.

4. Token Sent to Client
	•	Server responds with the signed token.
	•	The client stores it (usually in localStorage or sessionStorage).

5. Client Sends Token on Requests
	•	For protected APIs, the client sends the token in the Authorization header:
	Authorization: Bearer <JWT_TOKEN>
	6. Server Verifies Token
	•	Server verifies the signature using the secret/private key.
	•	If valid, it allows access to the resource.

HEADER.PAYLOAD.SIGNATURE
{
  "alg": "HS256",
  "typ": "JWT"
}
{
  "sub": "1234567890",
  "name": "John Doe",
  "role": "admin",
  "exp": 1714927200  // (expiry timestamp)
}
HMACSHA256(
  base64UrlEncode(header) + "." + base64UrlEncode(payload),
  secret
)

 */
        //@componentn in place of @repository

        /*
        Using @Component instead of @Repository technically works, but there are important reasons why using the correct stereotype annotation matters in Spring Boot.

⸻

✅ Quick Summary
Annotation
Role
Detectable via @ComponentScan?
Extra Behavior
@Component
Generic Spring-managed bean
âœ… Yes
âŒ None
@Repository
Specialization of @Component for DAOs
âœ… Yes
âœ… Translates DB exceptions to Springâ€™s DataAccessException


🔍 Why @Repository is Better for Repositories

✅ 1. Semantic Clarity

Using @Repository tells both Spring and other developers that the class is meant to access the database.

It’s about writing self-documenting code.

⸻

✅ 2. Exception Translation

Spring automatically wraps low-level persistence exceptions (e.g., SQLException) into its DataAccessException hierarchy when using @Repository.

@Repository
public class UserRepository {
    // Any persistence exception is caught and wrapped cleanly
}
✅ 3. AOP and Tooling Support

Using @Repository allows Spring to apply repository-specific aspects, like:
	•	Transaction management
	•	Persistence exception translation
	•	Easier integration with Spring Data JPA
	❌ If You Use @Component Instead
	•	✅ Bean will still be scanned and injected.
	•	❌ No exception translation — you’ll have to manually handle raw database exceptions.
	•	❌ Less readable/semantic for developers.
	•	❌ Can break Spring Data repository behavior if misused.

⸻

🧪 Example

@Component Version (not recommended for DAO):
@Component
public class UserDao {
    // works, but no exception translation
}
✅ Recommended @Repository Version:
@Repository
public class UserDao {
    // works + exception translation
}

✅ Conclusion

Use:
	•	@Component for generic beans
	•	@Service for business logic
	•	@Repository for data access (DAO/repository)

This follows Spring’s stereotype annotations pattern and ensures full framework support.

Would you like an example showing exception translation in action with @Repository?


         */

        // @service
        //*Readable
        //*Upgrade specific to component will be within each annotation
        //* Log intenral are segregated and easily maintained else difficult to find


        //@lazy/eacger loafding in angular
        /*
        Module loaded with application, or loadind lazily related to specific page like with children
        * */

            //what is cyclomatic :  https://www.geeksforgeeks.org/cyclomatic-complexity/

        //fucntional interface vs normal interface
        //how to create
/*
 Functional interface which has only one abstract method can be referenced in
        lambda funcitons
        eg2.
        public interface MyFunctionalInterface {
            public void execute();
        }


        MyFunctionalInterface interfaceTest = () -> {
            System.out.println("Executing...");
        }
 */


        /*
        🔍 Why Use @Service Instead of @Component?

✅ 1. Semantic Meaning

@Service tells developers (and Spring) that the class contains business logic, not just any bean.

Example:
@Service
public class PaymentService {
    // business logic
}

@Component
@Component
public class PaymentService {
    // still works, but less clear
}

✅ 2. AOP & Transactional Behavior

Spring may apply proxy-based features (like transactions or logging) more reliably when
 the bean is marked with the correct stereotype like @Service.

While technically all these annotations (@Service, @Repository, @Controller) are
 meta-annotated with @Component, Spring or third-party tools can apply specific behaviors
  based on the stereotype.


✅ 3. Better Tooling and Debugging

Some frameworks (like Spring Boot DevTools, IDEs, or even testing frameworks) may treat @Service beans differently for auto-configuration, profiling, or error tracing.
❌ What You Lose by Using @Component Instead of @Service
	•	Less readable and maintainable code
	•	Potential issues with AOP features not being applied as expected
	•	Losing the benefits of layer-specific semantics

⸻

✅ Best Practice
	•	Use @Component only for generic beans.
	•	Use @Service for business logic classes.
	•	Use @Repository for data access (DAO) classes.
	•	Use @Controller / @RestController for web layers.




         */

        //@componentscan, @enableautoconfiguraton @configuration usage
//The @EnableAutoConfiguration annotation enables Spring Boot to
// auto-configure the application context. Therefore, it automatically
// creates and registers beans based on both the included jar files
// in the classpath and the beans defined by us

        /*
        * class employee{
        *   name
        *  department
        *  salary*
        *  }
        *   //Map<> ofemply for employee list with name and department of highest salary
        *
        * */
        emp emp1= new emp("rishabh","BIETC",20000);
        emp emp2= new emp("prateek","Analytics",21000);
        emp emp3= new emp("prn","BCA",10000);
        emp emp4= new emp("dhw","ACD",200);
        emp emp5= new emp("dhw","DS",2120);


        List<emp> empList= new ArrayList<>();
        empList.add(emp1);
        empList.add(emp2);
        empList.add(emp3);
        empList.add(emp4);
        empList.add(emp5);

       Map<String,String> map= empList.stream()
               .max(Comparator.comparingInt(p -> p.salary))
               .stream()
               .collect(Collectors.toMap(emp -> emp.name, emp -> emp.department));


//        Map<String,String> map= empList.stream()
//                .max((p1, p2) -> Integer.compare(p1.salary, p2.salary))
//                .stream()
//                .collect(Collectors.toMap(emp -> emp.name, emp -> emp.department));
        System.out.println(map);
        //microservice disadvantage/bbenfit
        //spring boot benefit

    }
    static class emp{
        emp(String name, String department,Integer salary){
            this.department = department;
            this.name = name;
            this.salary = salary;

        }
        String name;
        String department;
        Integer salary;
    }
}
