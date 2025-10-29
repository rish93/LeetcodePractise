package com.Practise;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sapient2025 {

    public static void main(String[] args) {


        Integer [] arr= new Integer[]{10,20,2,3,30,1};
            //3 30 2 20 10
       String st = Arrays.stream(arr).sorted((o1, o2) -> {
//                    int digitSingle=o1%10;
//                    if(digitSingle>0 && digitSingle> o2/10 && digitSingle> o1/10){
//                        return -1;
//                    }

//                   if(o1/10 > o2/10)
//                        return -1;
//                    else if(o1/10 < o2/10)
//                        return 1;
//                    else
//                        return 0;
                    String s1= o1 +String.valueOf(o2);
                    String s2= o2 +String.valueOf(o1);
                      return s2.compareTo(s1);
//                   if(s1.equals(s2))
//                       return -1;
//                   else if(o1/10 < o2/10)
//                       return 1;
//                   else
//                       return 0;


               } )
               .map(integer -> String.valueOf(integer))
               .collect(Collectors.joining(""));
        System.out.print(st);
//        int m;
//        String s="";
//        for(int i=1;i<arr.length;i++){ ///20
//
//
//               m = arr[i-1]/10;  ///1
//               if(m<arr[i])    ///1< 20
//                s+=String.valueOf(arr[i]);
//               else
//                  s+= String.valueOf(arr[i-1]);
//
//
//        }
//        System.out.print(s);



        //bloom filter ?

        /*A Bloom Filter is a probabilistic data structure used to test whether an element is possibly in a set or definitely not in a set, with high space efficiency
        *t uses a bit array of length m (initialized to 0)
	•	And k independent hash functions

When you insert an element:
	1.	Pass it through all k hash functions.
	2.	Each hash returns an index in the bit array.
	3.	Set those k bits to 1.
	*
	*
	*
	* When you query an element:
	1.	Again, pass it through all k hash functions.
	2.	Check if all k corresponding bits are 1.
	•	If any bit is 0 → the element is definitely not present.
	•	If all bits are 1 → the element is possibly present (false positive possible).

⸻💡 Real-world Use Cases
	1.	Web caching (e.g., CDN or proxy servers)
→ Before querying a slow backend or database, check with a Bloom filter to see if the item might be cached.
Example: Google Chrome uses it for Safe Browsing URL checks.
	2.	Databases
→ HBase, Cassandra, RocksDB use Bloom filters to avoid unnecessary disk lookups.
Example: When checking if a key exists in an SSTable file.
	3.	Email spam detection
→ Check if an email or sender was seen before.
	4.	Blockchain systems
→ Bitcoin nodes use Bloom filters to detect relevant transactions for lightweight clients.
	5.	Distributed systems
→ In systems like Apache Kafka or Hadoop, to reduce network calls for existence checks.

* */

        //preflight
        /*
        * this comes up often in CORS (Cross-Origin Resource Sharing) discussions
        *
        * What is a Preflight API Call (OPTIONS Request)?

        A preflight request is an HTTP OPTIONS call automatically sent by the browser before making the actual API request (like POST, PUT, DELETE, etc.) — to check if the server allows the cross-origin call.

        It’s like the browser asking:

        “Hey server, is it okay if I send this request from my origin (frontend domain) with these headers and methods?”

        ⸻

        *
        * * * * */
        //resultset mapping
        //kafka pull based or push



























//        //
//        // value to key in map
//        // Original Map
//        Map<String, Integer> originalMap = new HashMap<>();
//        originalMap.put("apple", 1);
//        originalMap.put("banana", 2);
//        originalMap.put("cherry", 3);
//
//        System.out.println("Original Map: " + originalMap);
//
//        // Interchange key and value using Streams
//        Map<Integer, String> interchangedMap = originalMap.entrySet()
//                .stream()
//                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
//
//        System.out.println("Interchanged Map: " + interchangedMap);
//
//        // Example with potential duplicate values (which would cause issues)
//        Map<String, String> mapWithDuplicateValues = new HashMap<>();
//        mapWithDuplicateValues.put("key1", "valueA");
//        mapWithDuplicateValues.put("key2", "valueB");
//        mapWithDuplicateValues.put("key3", "valueA"); // Duplicate value
//
//        System.out.println("Map with potential duplicate values: " + mapWithDuplicateValues);
//
//        // To handle duplicate values, you can use a merge function in toMap
//        Map<String, String> interchangedMapWithMerge = mapWithDuplicateValues.entrySet()
//                .stream()
//                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey,
//                        (oldValue, newValue) -> oldValue + ", " + newValue)); // Concatenate keys for duplicate values
//
//        System.out.println("Interchanged Map with merge function: " + interchangedMapWithMerge);
    }
}
