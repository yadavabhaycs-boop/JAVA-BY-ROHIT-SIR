import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map; // For Map interface
import java.util.Iterator;

public class AbhayMap {

    public static void main(String[] args) {
        // c. Demonstrating Map Interface (using HashMap)
        System.out.println("\n--- Demonstrating Map Interface ---");
        Map<String, Integer> studentScores = new HashMap<>();

// Basic Map operations
        studentScores.put("Alice", 95); // put(K key, V value)
        studentScores.put("Bob", 88);

        studentScores.put("Charlie", 76);
        studentScores.put("Alice", 98); // Updates value for existing key
        System.out.println("Initial Map: " + studentScores);
        System.out.println("Bob's score: " + studentScores.get("Bob")); // get(Object key)
        studentScores.remove("Charlie"); // remove(Object key)
        System.out.println("Map after removing Charlie: " + studentScores);

// Other Map methods
        System.out.println("Does map contain key Bob? " + studentScores.containsKey("Bob")); //containsKey(Object key)
        System.out.println("Does map contain value 98? " + studentScores.containsValue(98)); //containsValue(Object value)

// Getting views of the map
        System.out.println("Keys in the map: " + studentScores.keySet()); // keySet()
        System.out.println("Values in the map: " + studentScores.values()); // values()
        System.out.println("Entries in the map: " + studentScores.entrySet()); // entrySet()
        System.out.println("Size of the map: " + studentScores.size()); // size()
        studentScores.clear(); // clear()
        System.out.println("Map after clearing: " + studentScores);
    }
}

