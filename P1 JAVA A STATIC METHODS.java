package p1java;

class Student {
    String name;
    int age;

    // Default Constructor
    Student() {
        name = "Abhay";
        age = 21;
    }

    // Parameterized Constructor
    Student(String n, int a) {
        name = n;
        age = a;
    }

    // Method Overloading
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    void display(String course) {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
    }

    // Static Method
    static void collegeName() {
        System.out.println("College: MVLU College");
    }
}

public class P1JAVA {

    public static void main(String[] args) {

        // Calling Static Method
        Student.collegeName();

        // Default Constructor
        Student s1 = new Student();
        s1.display();

        System.out.println();

        // Parameterized Constructor
        Student s2 = new Student("Rahul", 20);
        s2.display("BSc Computer Science");
    }
}
