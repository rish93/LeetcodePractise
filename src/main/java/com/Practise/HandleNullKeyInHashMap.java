package com.Practise;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HandleNullKeyInHashMap {
//        How can you handle null pointer when iterator encounters a null key while iteration over a hashmap.
    public static void main(String[] args) {

        Map<String,String> map = new HashMap<>();

        map.put("null",null);
        map.put("test", "test");
        map.put(null, "null");
      System.out.println(map.containsKey(null)+" "+map.containsKey("null"));

      for(Map.Entry<String,String> entry: map.entrySet()){
          System.out.println(entry.getKey());
      }

        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while(it.hasNext())
        {
            System.out.println(it.next().getKey());
        }
    }
}




