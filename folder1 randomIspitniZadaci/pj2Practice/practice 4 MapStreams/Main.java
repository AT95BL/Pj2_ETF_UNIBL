
// https://www.baeldung.com/java-maps-streams

import java.util.*;
import java.util.stream.*;

public class Main{
    public static void main(String[] args) {

        Map<String, Integer> someMap = new HashMap<>();
        someMap.put("C", 1);
        someMap.put("C++", 2);
        someMap.put("Java", 3);
        someMap.put("JavaScript", 4);

        for(Map.Entry<String, Integer> entry : someMap.entrySet()){
            System.out.println(entry);  //  what will be the output!??
        }

        // We can obtain a set of key-value pairs:
        Set<Map.Entry<String, Integer>> entries = someMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }
        
        // We can also get the key set associated with the Map
        Set<String> keySet = someMap.keySet();
        for (String key : keySet) {
            System.out.println("Key: " + key);
        }
        
        // Or we could work directly with the set of values:
        Collection<Integer> values = someMap.values();
        for (Integer value : values) {
            System.out.println("Value: " + value);
        }
        
        // These each give us an entry point to process those collections by obtaining streams from them:
        Stream<Map.Entry<String, Integer>> entriStream = entries.stream();
        Stream<Integer> valuesStream = values.stream();
        Stream<String> keyStream = keySet.stream();

        // Let’s assume we have a Map:
        Map<String, String> books = new HashMap<>();
        books.put(
            "978-0201633610", "Design patterns : elements of reusable object-oriented software");
        books.put(
            "978-1617291999", "Java 8 in Action: Lambdas, Streams, and functional-style programming");
        books.put(
            "978-0134685991", "Effective Java");

            Optional<String> optionalIsbn1 = books.entrySet().stream()
                .filter(e -> "Effective Java".equals(e.getValue()))
                .map(Map.Entry::getKey)
                .findFirst();
                System.out.println(optionalIsbn1);
            //  assertEquals("978-0134685991", optionalIsbn.get());

            Optional<String> optionalIsbn2 = books.entrySet().stream()
                .filter(e -> "Non Existent Title".equals(e.getValue()))
                .map(Map.Entry::getKey).findFirst();
                System.out.println(optionalIsbn2);
            //  assertEquals(false, optionalIsbn.isPresent());
        
    }
}