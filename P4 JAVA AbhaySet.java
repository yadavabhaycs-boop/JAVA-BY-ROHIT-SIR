import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Set; // For Set interface
import java.util.Iterator;

public class AbhaySet {

    public static void main(String[] args) {

// b. Demonstrating Set Interface (using HashSet)
        System.out.println("\n--- Demonstrating Set Interface ---");
        Set<String> uniqueColors = new HashSet<>();

// Basic Set operations
        uniqueColors.add("Red"); // add(E element)
        uniqueColors.add("Green");

        uniqueColors.add("Blue");
        uniqueColors.add("Red"); // Duplicate, won't be added
        System.out.println("Initial Set: " + uniqueColors);
        uniqueColors.remove("Green"); // remove(Object o)
        System.out.println("Set after removing Green: " + uniqueColors);

// Other Set methods
        System.out.println("Does set contain Blue? " + uniqueColors.contains("Blue")); //contains(Object)
        System.out.println("Size of the set: " + uniqueColors.size()); // size()
        System.out.println("Is the set empty? " + uniqueColors.isEmpty()); // isEmpty()

// Iterating and adding collections
        System.out.print("Iterating over the set: ");
        Iterator<String> iterator = uniqueColors.iterator(); // iterator()
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        Set<String> moreColors = new HashSet<>();
        moreColors.add("Yellow");
        moreColors.add("Blue");
        uniqueColors.addAll(moreColors); // addAll(Collection<? extends E> c)
        System.out.println("Set after adding more colors: " + uniqueColors);
    }
}

