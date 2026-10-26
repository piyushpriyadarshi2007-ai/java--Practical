class Person {
    protected String name;
    protected int age;
    public Person(String name, int age) {
        this.name = name; this.age = age;
        System.out.println("Person constructor");
    }
    public void display() { System.out.println("Name: " + name + ", Age: " + age); }
}

class Student extends Person {           
    protected String rollNo;
    public Student(String name, int age, String rollNo) {
        super(name, age);                
        this.rollNo = rollNo;
        System.out.println("Student constructor");
    }
    @Override public void display() { super.display(); System.out.println("Roll No: " + rollNo); }
}

class GraduateStudent extends Student {   
    private String thesisTopic;
    public GraduateStudent(String name, int age, String rollNo, String thesisTopic) {
        super(name, age, rollNo);
        this.thesisTopic = thesisTopic;
        System.out.println("GraduateStudent constructor");
    }
    @Override public void display() { super.display(); System.out.println("Thesis: " + thesisTopic); }
}

class Faculty extends Person {
    private String department;
    private double salary;
    public Faculty(String name, int age, String department, double salary) {
        super(name, age);
        this.department = department; this.salary = salary;
        System.out.println("Faculty constructor");
    }
    @Override public void display() {
        super.display();
        System.out.println("Dept: " + department + ", Salary: " + salary);
    }
}

public class Practical2 {
    public static void main(String[] args) {
        System.out.println("--- Student ---");
        Student s = new Student("Piyush", 19, "25-CSE-AIDS-008");
        s.display();
        System.out.println("\n--- GraduateStudent (multilevel) ---");
        GraduateStudent g = new GraduateStudent("Aman", 23, "PG-001", "Federated Learning");
        g.display();
        System.out.println("\n--- Faculty ---");
        Faculty f = new Faculty("Dr. Sharma", 45, "AI & DS", 90000);
        f.display();
    }
}

