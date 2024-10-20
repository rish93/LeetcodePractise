package com.javatopics.oops;

public class SolidPrinciple {
    //Single Responsibility principal
    //Open close principle
    //Liskov Substitution principal
    //interface seggregation principal
    //Dependency injection
}

/*S:  The “S” in SOLID is for Single Responsibility Principle, which states that every object should have a single responsibility and that all of its services should be aligned with that responsibility. “Responsibility” is defined as “a reason to change”, 
       As an example, consider a module that compiles and prints a report. Such a module can be changed for two reasons. First, the content of the report can change. Second, the format of the report can change. These two things change for very different causes; one substantive, and one cosmetic. The single responsibility principle says that these two aspects of the problem are really two separate responsibilities, and should therefore be in separate classes or modules. It would be a bad design to couple two things that change for different reasons at different times.*/
/*O:   The “O” in SOLID is for Open-Closed Principle, which states that software entities – such as classes, modules, functions and so on – should be open for extension but closed for modification. The idea is that it’s often better to make changes to things like classes by adding to or building on top of them (using mechanisms like subclassing or polymorphism) rather than modifying their code*/
/*L:   The “L” in SOLID is for Liskov Substitution Principle, which states that subclases should be substitutable for the classes from which they were derived. For example, if MySubclass is a subclass of MyClass, you should be able to replace MyClass with MySubclass without bunging up the program.*/
/*I:   The “I” in SOLID is for Interface Segregation Principle, which states that clients should not be forced to depend on methods they don’t use. If a class exposes so many members that those members can be broken down into groups that serve different clients that don’t use members from the other groups, you should think about exposing those member groups as separate interfaces.*/
/*D:   The “D” in SOLID is for Dependency Inversion Principle, which states that high-level modules shouldn’t depend on low-level modules, but both should depend on shared abstractions. In addition, abstractions should not depend on details – instead, details should depend on abstractions.*/