package me.surendra.learning.collection;

import java.util.HashMap;
import java.util.Map;

public class HashMap_CreationWays {
//    Java 8 and before
    Map<String, String> myMap = new HashMap<String, String>() {{
        put("a", "b");
        put("c", "d");
    }};

    Map<String, String> myMap1 = createMap();
    private static Map<String, String> createMap() {
        Map<String,String> myMap = new HashMap<>();
        myMap.put("a", "b");
        myMap.put("c", "d");
        return myMap;
    }


    /*
    //
    // Java 9
    //

    // this works for up to 10 elements:
    Map<String, String> test1 = Map.of(
        "a", "b",
        "c", "d"
    );


    // this works for any number of elements:
    Map<String, String> test2 = Map.ofEntries(
        entry("a", "b"),
        entry("c", "d")
    );
     */

}

// https://stackoverflow.com/questions/6802483/how-to-directly-initialize-a-hashmap-in-a-literal-way
