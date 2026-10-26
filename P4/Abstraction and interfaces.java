interface Payable { double getPaymentAmount(); }
interface Printable { void print(); }

abstract class Employee implements Payable, Printable {  
    protected int id;
    protected String name;
    Employee(int id, String name) { this.id = id; this.name = name; }

    abstract double calculateSalary();                  
    public double getPaymentAmount() { return calculateSalary(); }
    public void print() {                               
        System.out.println(getClass().getSimpleName() + " [" + id + "] " + name
                + " -> Salary: " + calculateSalary());
    }
    void showCompany() { System.out.println("Company: TechCorp"); }  
}

class FullTimeEmployee extends Employee {
    private double basic, hra, da;
    FullTimeEmployee(int id, String n, double basic) {
        super(id, n); this.basic = basic; this.hra = 0.20 * basic; this.da = 0.10 * basic;
    }
    double calculateSalary() { return basic + hra + da; }
}
class PartTimeEmployee extends Employee {
    private int hours; private double rate;
    PartTimeEmployee(int id, String n, int hours, double rate) { super(id, n); this.hours = hours; this.rate = rate; }
    double calculateSalary() { return hours * rate; }
}
class ContractEmployee extends Employee {
    private double contractAmount; private double tdsPercent;
    ContractEmployee(int id, String n, double amt, double tds) { super(id, n); contractAmount = amt; tdsPercent = tds; }
    double calculateSalary() { return contractAmount - contractAmount * tdsPercent / 100; }
}

public class Practical4 {
    public static void main(String[] args) {
        Employee[] emps = {
            new FullTimeEmployee(1, "Piyush", 40000),
            new PartTimeEmployee(2, "Riya", 80, 250),
            new ContractEmployee(3, "Aman", 60000, 10)
        };
        emps[0].showCompany();
        double total = 0;
        for (Employee e : emps) {
            e.print();                         
            total += e.getPaymentAmount();   
        }
        System.out.println("Total payroll: " + total);

        Payable p = emps[1];
        System.out.println("Via Payable reference: " + p.getPaymentAmount());
    }
}

