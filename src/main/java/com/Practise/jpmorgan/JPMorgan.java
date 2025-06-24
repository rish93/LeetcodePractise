package com.Practise.jpmorgan;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JPMorgan {

    public static void main(String[] args) {


        List<List> testList= new ArrayList<>();
        testList.stream().flatMap(str->str.stream()).collect(Collectors.toList());


        String s="Rishabh";

        String s1= new String("Rishabh");
        System.out.println(s==s1);


//        user
//                -> name
//                -> id
//                -> addres
//                -> cibilscore
//        card
//                -> id
//                -> type
//                -> (fk) user_id
//                -> expiry date


            //milio of record which datastructure will use linked list or array list
                //suupse in custom stack you need min everytime popping or pushing  //maintainer min variable o0r min list
/*
* 🧠 Rule of Thumb:
	•	✅ Use ArrayList when:
	•	You mostly need random access (get(i))
	•	You’re mainly adding/removing at the end
	•	You want better performance with millions of records
	•	✅ Use LinkedList when:
	•	You have lots of insertions/deletions in the middle
	•	You don’t need random access
	•	You’re working with queues/stacks

⸻

💡 With millions of records:
	•	Most of the time, ArrayList is better due to better cache performance,
	* *  less memory overhead, and fast random access.
	•	LinkedList can become memory-heavy and slower for iteration.

⸻

🔥 Pro Tip:

If you’re hitting memory or performance issues with millions of records, consider:
	•	Using ArrayDeque if you’re building a queue/stack.
	•	Using streams or paging/chunking techniques.
	•	Using external databases or memory-mapped files if the dataset is too big for memory.
*
*
*
* * * * * */
        //how you weill handle when microservice intewract shopping-> cart-> payment and payment fails
        //-> retry and revert.... use hsyterix  or use transaction id and savereuse when avaiable


        ///three microservice, running in different isntance you dont want that particular part of database to be created
        //--> use SAGA patterns orchestration where centralized it is maintained that instance if created dont crewate



        //immuatable class
        //million of records coming drom query how to optimize  --use clause more often ... -


        //how to optimize query whioch is slow  ///remove unwanted column.... use indexing.........table can eb more normalized
        //ddynamic lenghtg of list
        //concurrent hashmaop with parallel stream  ///will it work
    }
}
