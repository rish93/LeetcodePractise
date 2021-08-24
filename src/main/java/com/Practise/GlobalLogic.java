package com.Practise;

public class GlobalLogic {
//find max of subarray
    //suppose string class is removed how to create + handle string pooling


//    parent class {
//       String run()
//    }
//    chile class extends parent
//    Integer run ()
//        is it possible  to have different return type




//    class call{
//        de.have (null) which one will be called
//    }
// class de{
//
//     have(Object value){
//
//     }
//
//     have(String value){
//
//     }
//
//     have(Integer value){
//
//     }
//
//
// }
//
//}
//

    //why to use static benefit.
/*
    Java Static Variables

    A static variable is common to all the instances (or objects) of the class because it is a class level variable. In other words you can say that only a single copy of static variable is created and shared among all the instances of the class. Memory allocation for such variables only happens once when the class is loaded in the memory. So when you need to share same variable for every instance of class then you should use static variable.

    Java Non - Static Variables

    Technically speaking, objects store their individual states in "non-static fields", that is, fields declared without the static keyword. Non-static fields are also known as instance variables because their values are unique to each instance of a class (to each object, in other words).

    public class VariablesOfJava {

        static int CourseFee=2200; // Static variable

        int age=0; // Non Static Variable

        String name; // Non Static Variable

        public void personVersha(String name, int age){

            System.out.println("CourseFee of Java is" +"-"+CourseFee); //2200

            System.out.println("Name of person is"+"-"+name); // Varsha

            System.out.println("Age of Person is"+"-"+age); //20

        }

        public void personKamble( String name,int age){

            System.out.println("CourseFee of Java is" +"-"+CourseFee); // 2200

            System.out.println("Name of person is"+"-"+name); // Ram

            System.out.println("Age of Person is"+"-"+age); //25

        }

        public static void main(String[] args){

            VariablesOf V=new VariablesOf();

            V.personVersha("Varsha",20);

            V.personKamble("Kamble",25);

        }

    }*/

///// second round

    //when to use generic

    // when to use stream


    /*
    Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = {"Hello", "World"};
printArray
printArray(intArray);


//make generic parametedr acceptance

   printArray(Object[] input){
		for(Object o:imput){

			if(o.instanceOf(String) ){
			   SOP((String)o)

			}else
			{
			SOP(Integer)o

			}

		List<?> list =getArray
		}

		new

		//find how many time instance was created in 900 line of code

		Person p = new person(w)

		Person p1 = new person()

		Person p2 = new person()

	map.put( , )

	Map<>  -> put(instance P, map.get(instance)+1 )

	}
	Map<Integer,IN> put()

	if i have method that take input 9 retrun 3
	if 3 then return 9



	//get duplicate in java 8 using stream

	inpList.stream().forEach( i-> {
	int
	Map<Integer,IN> put(i, map.get(instance)+1  )
	if()

	}).filter().map().to



	//duplicate email
	select e.name , e.mobile number Employee e where count(e.mobile)>1 And e.name =


	select e.name , e.mobile number Employee e where e.email containe svalid email
SELECT * FROM people WHERE email NOT LIKE '%_@__%.__%'



	factory design pattern drawback

	design pattern in microservice

	@RestController @ Controller
	@Controller is used to mark classes as Spring MVC Controller.
	@RestController is a convenience annotation that does nothing more than adding the @Controller and @ResponseBody annotations (see: Javadoc)
	So the following two controller definitions should do the same

	@Controller
	@ResponseBody
	public class MyController { }

	@RestController
	public class MyRestController { }

    with eg
    Map vs ConcurrentHashMap
        https://www.geeksforgeeks.org/difference-hashmap-concurrenthashmap/

    Patch vs put
        https://stackoverflow.com/questions/28459418/use-of-put-vs-patch-methods-in-rest-api-real-life-scenarios
        In a PUT request, the enclosed entity is considered to be a modified version of the resource stored on the origin server,
        and the client is requesting that the stored version be replaced.

        With PATCH, however, the enclosed entity contains a set of instructions describing how a resource
        currently residing on the origin server should be modified to produce a new version.

        Also, another difference is that when you want to update a resource with PUT request, you have to
         send the full payload as the request whereas with PATCH, you only send the parameters which you want to update.

    /**************************************
    Different ways  to create object
    Using new keyword
       : NewKeywordExample obj = new NewKeywordExample();

    Using new instance
       :  Class cls = Class.forName("NewInstanceExample");
          NewInstanceExample obj = (NewInstanceExample)cls.newInstance();

    Using clone() method
        :   // Java program to illustrate creation of Object
            // using clone() method

            // Main class implementing Cloneable interface
            // CloneExample
            class GFG implements Cloneable {

                // Method 1
                @Override
                protected Object clone()
                    throws CloneNotSupportedException
                {
                    return super.clone();
                }

                // Declaring and initializing string
                String name = "GeeksForGeeks";

                // Method 2
                // main driver method
                public static void main(String[] args)
                {
                    GFG obj1 = new GFG();

                    // Try block to check for exceptios
                    try {
                        CloneExample obj2 = (CloneExample)obj1.clone();
                        System.out.println(obj2.name);
                    }

                    // Catch block to handle the exceptions
                    catch (CloneNotSupportedException e) {
                        // Display the exception
                        // using printStackTrace() method
                        e.printStackTrace();
                    }
                }
            }

    Using deserialization
    **

    Using newInstance() method of Constructor class

        Using newInstance() method of the constructor class
        Constructor<GFG> constructor
                    = GFG.class.getDeclaredConstructor();

                GFG r = constructor.newInstance();
        This is similar to the newInstance() method of a class. There is one newInstance()
         method in the java.lang.reflect.Constructor class which we can use to create objects.
          It can also call the parameterized constructor, and private constructor by using this newInstance() method.
         Both newInstance() methods are known as reflective ways to create objects. In fact newInstance()
         method of Class internally uses newInstance() method of Constructor class.

     */


    //overload null error
//    https://www.geeksforgeeks.org/method-overloading-null-error-java/
}
