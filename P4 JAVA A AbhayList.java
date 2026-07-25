
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import


import java.util.Iterator;

public class AbhayList {

    public static void main(String[] args) {

        // a. Demonstrating List
        System.out.println("---Demonstrating List Interface---");
        List<String> animal = new ArrayList<>();

        //Basic List Operations
        animal.add("Cat"); //Add Element
        animal.add("Dog");
        animal.add("Lion");
        animal.add("Cat"); // Duplicates allowed
        System.out.println("Initial List: " + animal);

        animal.add(1, "Cheeta"); // add(int index, E element)
        System.out.println("List after adding Cheeta at index 1: " + animal);
        System.out.println("First animal: " + animal.get(0)); // get(int index)
        
        animal.set(2, "Tiger"); // set(int index, E element)
        System.out.println("List after updating element at index 2 to Tiger: " + animal);
        
        animal.remove("Cat"); // remove(Object o)
        System.out.println("List after removing the first Cat: " + animal);
        
        animal.remove(animal.size() - 1); // remove(int index)
        System.out.println("List after removing the last element: " + animal);

// Other List methods
        System.out.println("Index of Lion: " + animal.indexOf("Lion")); // indexOf(Object o)
        System.out.println("Does list contain Dog? " + animal.contains("Dog")); // contains(Object)
        System.out.println("Size of the list: " + animal.size()); // size()
        
        animal.clear(); // clear()
        System.out.println("List after clearing: " + animal);

    }
}

