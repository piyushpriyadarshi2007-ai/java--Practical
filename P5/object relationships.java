import java.util.*;

class Teacher {                                
    private String name;
    Teacher(String name) { this.name = name; }
    String getName() { return name; }
}

class Department {
    private String name;
    private List<Teacher> teachers = new ArrayList<>();   
    Department(String name) { this.name = name; }
    void addTeacher(Teacher t) { teachers.add(t); }
    String getName() { return name; }
    void show() {
        System.out.print("  Dept " + name + " -> ");
        for (Teacher t : teachers) System.out.print(t.getName() + "  ");
        System.out.println();
    }
}

class College {
    private String name;
    private List<Department> departments = new ArrayList<>();
    College(String name, String... deptNames) {
        this.name = name;
        for (String d : deptNames) departments.add(new Department(d)); 
    }
    Department getDepartment(String n) {
        for (Department d : departments) if (d.getName().equals(n)) return d;
        return null;
    }
    void show() { System.out.println("College: " + name); for (Department d : departments) d.show(); }
    void close() { departments.clear(); System.out.println(name + " closed -> its departments no longer exist."); }
}

class Course {
    private String title;
    Course(String title) { this.title = title; }
    String getTitle() { return title; }
}

class Student {                                 
    private String name;
    private List<Course> courses = new ArrayList<>();
    Student(String name) { this.name = name; }
    void enroll(Course c) { courses.add(c); }
    void show() {
        System.out.print(name + " enrolled in: ");
        for (Course c : courses) System.out.print(c.getTitle() + "  ");
        System.out.println();
    }
}

public class Practical5 {
    public static void main(String[] args) {
        Teacher t1 = new Teacher("Dr. Sharma"), t2 = new Teacher("Prof. Gupta"), t3 = new Teacher("Dr. Mehta");

        College college = new College("Echelon Institute", "AI&DS", "CSE");
        college.getDepartment("AI&DS").addTeacher(t1);
        college.getDepartment("AI&DS").addTeacher(t2);
        college.getDepartment("CSE").addTeacher(t3);
        college.show();

        Course java = new Course("Java"), dsa = new Course("DSA");
        Student s1 = new Student("Piyush"), s2 = new Student("Riya");
        s1.enroll(java); s1.enroll(dsa); s2.enroll(java);     
        s1.show(); s2.show();

        college.close();   // composition: departments die with college
        System.out.println("Teacher still alive after college closes (aggregation): " + t1.getName());
        System.out.println("Course still alive independent of students (association): " + java.getTitle());
    }
}

