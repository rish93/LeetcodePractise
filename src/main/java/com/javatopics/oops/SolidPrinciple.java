package com.javatopics.oops;

public class SolidPrinciple {
    //Single Responsibility principal
    //Open close principle
    //Liskov Substitution principal
    //interface seggregation principal
    //Dependency injection
}

/*S:  The “S” in SOLID is for Single Responsibility Principle, which states that every object should have a
single responsibility and that all of its services should be aligned with that responsibility.
“Responsibility” is defined as “a reason to change”,
       As an example, consider a module that compiles and prints a report. Such a module can be changed for two reasons. First, the content of the report can change. Second, the format of the report can change. These two things change for very different causes; one substantive, and one cosmetic. The single responsibility principle says that these two aspects of the problem are really two separate responsibilities, and should therefore be in separate classes or modules. It would be a bad design to couple two things that change for different reasons at different times.*/
/*O:   The “O” in SOLID is for Open-Closed Principle, which states that software entities –
such as classes, modules, functions and so on – should be open for extension but closed for modification.
 The idea is that it’s often better to make changes to things like classes by adding to or building on
 top of them (using mechanisms like subclassing or polymorphism) rather than modifying their code*/
/*L:   The “L” in SOLID is for Liskov Substitution Principle, which states that subclases should be
substitutable for the classes from which they were derived. For example, if MySubclass is a subclass
of MyClass, you should be able to replace MyClass with MySubclass without bunging up the program.*/
/*I:   The “I” in SOLID is for Interface Segregation Principle, which states that clients should not be
forced to depend on methods they don’t use. If a class exposes so many members that those members
can be broken down into groups that serve different clients that don’t use members from the other groups,
you should think about exposing those member groups as separate interfaces.*/
/*D:   The “D” in SOLID is for Dependency Inversion Principle, which states that high-level
 modules shouldn’t depend on low-level modules, but both should depend on shared abstractions.
  In addition, abstractions should not depend on details – instead, details should depend on abstractions.*/






/*
    The SOLID principles are a set of design principles in object-oriented programming aimed at improving software design by making systems easier to maintain, scale, and understand. These principles were introduced by Robert C. Martin (Uncle Bob) and are foundational in modern software development. Here’s an overview of each principle:

        1. S - Single Responsibility Principle (SRP)

        Definition: A class should have only one reason to change, meaning it should have a single responsibility or function.

        Purpose: This principle helps in reducing the complexity of a class and makes it easier to understand, test, and maintain.

        Example:
        Bad:

class Report {
    void generateReport() { /* code to generate report }
    void printReport() { /* code to print report }
}

Good:

class ReportGenerator {
    void generateReport() { /* code to generate report  }
}
class ReportPrinter {
    void printReport() { /* code to print report  }
}

2. O - Open/Closed Principle (OCP)

        Definition: Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.

        Purpose: This allows new functionality to be added without altering existing code, reducing the risk of introducing bugs.

        Example:
        Bad:

        class Shape {
        void draw(String shapeType) {
        if (shapeType.equals("Circle")) { /* draw circle  }
        else if (shapeType.equals("Rectangle")) { /* draw rectangle  }
        }
        }

        Good:

        abstract class Shape {
        abstract void draw();
        }
        class Circle extends Shape {
        void draw() { /* draw circle  }
        }
        class Rectangle extends Shape {
        void draw() { /* draw rectangle  }
        }

        3. L - Liskov Substitution Principle (LSP)

        Definition: Objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program.

        Purpose: This ensures that derived classes extend the functionality of base classes without altering their expected behavior.

        Example:
        Bad:

        class Rectangle {
        int width, height;
        void setWidth(int w) { width = w; }
        void setHeight(int h) { height = h; }
        }
        class Square extends Rectangle {
        void setWidth(int w) { width = height = w; }
        void setHeight(int h) { width = height = h; }
        }

        Good:
        Use separate classes for Rectangle and Square if they have different behaviors.

        4. I - Interface Segregation Principle (ISP)

        Definition: A class should not be forced to implement interfaces it does not use.

        Purpose: This helps avoid bloated interfaces and ensures classes only implement what they need.

        Example:
        Bad:

        interface Worker {
        void work();
        void manage();
        }
        class Developer implements Worker {
        void work() { /* coding  }
        void manage() { /* unnecessary  }
        }

        Good:

        interface Coder {
        void code();
        }
        interface Manager {
        void manage();
        }
        class Developer implements Coder {
        void code() { /* coding  }
        }

        5. D - Dependency Inversion Principle (DIP)

        Definition: High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details; details should depend on abstractions.

        Purpose: This decouples modules, making the system more flexible and easier to change.

        Example:
        Bad:

        class MySQLDatabase {
        void connect() { /* connection logic  }
        }
        class Application {
        MySQLDatabase db = new MySQLDatabase();
        void start() { db.connect(); }
        }

        Good:

        interface Database {
        void connect();
        }
        class MySQLDatabase implements Database {
        void connect() { /* connection logic  }
        }
        class Application {
        Database db;
        Application(Database db) { this.db = db; }
        void start() { db.connect(); }
        }

        Summary of Benefits

        •	SRP: Makes code simpler and less prone to bugs.
        •	OCP: Makes adding new functionality safer and easier.
        •	LSP: Preserves behavior across inheritance hierarchies.
        •	ISP: Keeps interfaces focused and easier to implement.
        •	DIP: Encourages loose coupling and flexible design.

        Together, these principles foster better software design, leading to systems that are easier to build, extend, and maintain.

*/