
Design pattern -> Solution to repeating problems in software design
-------------------------------------------
https://www.youtube.com/watch?v=NU_1StN5Tkk
--------------------------------------------
Benefit:
Helps in maintanable, reusable software.
Helps in learnig new framework faster

23 design patterns(classic and documented), documented in 90's in book byAuthor  Gang of four (GoF)
Hence Gang of 4 patterns are:-

a) Creational            b) Structural        c) Behavioral

a) It is all about different ways to create objects
b) It's about relationship between objects
c) It is about interaction or communication between objects


Class -> can have coupling, more the classes more the coupling.
        need to compile each one of them for small changes
        We can decouple classes using interfaces and build loosely coupled application...
        eg
        Main.class                                       User.class
        psvm{                                           User(String user){this.name=name
v1                                                        }
              User user = new User("Rishabh")
          }
//if we add new parameter all dependent need to recompile
      Main.class                                       User.class
        psvm{                                           User(String user, int age){this.name=name
v1                                                        }
              User user = new User("Rishabh",2)
          }

Interfaces -> Contract that specifies the capabilities that a class should provide.

