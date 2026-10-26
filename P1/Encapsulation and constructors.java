class Student{
  private int rollNo;
  private String name;\
  // default constructor
  Student () {
    roll No= 0;
    name = "Unknown";
  }
  // parameterized constructor 
  Student(int r, String n) {
    setRollNo(r);
    setNmae(n);
  }
  // getter and setter
  public int getRollNo() {
    return rollNo;
  }
  public void setRollNo(int r) {
    if (r> 0) rollNo = r;
  }
  public String getName() {
    return name;
  }
  public void setName(String n) {
    if (n ! = null && !n.trim().isEmpty())
      name = n;
  }
  void display() {
    System.out.println(rollNo +" " + name);
  }
  public static void main(String[] args) {
    Student s1 = new Student();
    Student s2 = new Student( 99, "Piyush");
    s1.display();
    s2.display();
  }
}
      
  
  

































[
