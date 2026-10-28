
import java.util.*;

// Interface
interface Displayable {
    void display();
}

// Abstraction
abstract class Person implements Displayable {
    private String name;
    private int age;

    public Person(String name, int age) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be positive.");
        }

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract String getRole();
}

// Inheritance
class Student extends Person {
    private int rollNo;
    private double marks;

    public Student(int rollNo, String name, int age, double marks) {
        super(name, age);

        if (rollNo <= 0) {
            throw new IllegalArgumentException(
                "Roll number must be positive."
            );
        }
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException(
                "Marks must be between 0 and 100."
            );
        }

        this.rollNo = rollNo;
        this.marks = marks;
    }

    public int getRollNo() {
        return rollNo;
    }

    public double getMarks() {
        return marks;
    }

    @Override
    public String getRole() {
        return "Student";
    }

    // Polymorphism
    @Override
    public void display() {
        System.out.println(
            "Roll No: " + rollNo +
            ", Name: " + getName() +
            ", Age: " + getAge() +
            ", Marks: " + marks
        );
    }
}

// Generic repository
class Repository<T> {
    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public boolean remove(T item) {
        return items.remove(item);
    }

    public T find(int index) {
        if (index < 0 || index >= items.size()) {
            throw new IndexOutOfBoundsException(
                "Invalid record index."
            );
        }
        return items.get(index);
    }

    public int size() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void displayAll() {
        if (items.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        for (T item : items) {
            if (item instanceof Displayable) {
                ((Displayable) item).display();
            } else {
                System.out.println(item);
            }
        }
    }
}

// Composition: manager owns a repository
class StudentManager {
    private final Repository<Student> repository =
        new Repository<>();

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException(
                "Student cannot be null."
            );
        }
        repository.add(student);
        System.out.println("Student added successfully.");
    }

    public void removeStudent(Student student) {
        if (repository.remove(student)) {
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student record not found.");
        }
    }

    public void displayStudents() {
        repository.displayAll();
    }

    public void displayStudentAt(int index) {
        repository.find(index).display();
    }

    public int getTotalStudents() {
        return repository.size();
    }

    public boolean isEmpty() {
        return repository.isEmpty();
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        try {
            System.out.println("=== Student Record System ===");

            // Add records
            Student s1 = new Student(1, "Aditya", 19, 85.5);
            Student s2 = new Student(2, "Harsh", 19, 91.0);
            Student s3 = new Student(3, "Riya", 20, 88.0);

            manager.addStudent(s1);
            manager.addStudent(s2);
            manager.addStudent(s3);

            // Display all records
            System.out.println("\nAll Student Records:");
            manager.displayStudents();

            // Search by index
            System.out.println("\nStudent at index 1:");
            manager.displayStudentAt(1);

            // Total count
            System.out.println(
                "\nTotal Students: " + manager.getTotalStudents()
            );

            // Delete a record
            System.out.println("\nRemoving Harsh:");
            manager.removeStudent(s2);

            System.out.println("\nUpdated Records:");
            manager.displayStudents();

            // Demonstrate exception handling
            System.out.println("\nTesting invalid roll number:");
            try {
                Student invalid =
                    new Student(0, "Test", 19, 75);
                manager.addStudent(invalid);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

            // Demonstrate invalid index handling
            System.out.println("\nTesting invalid index:");
            try {
                manager.displayStudentAt(10);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        } finally {
            System.out.println("\nProgram execution completed.");
        }
    }
}
