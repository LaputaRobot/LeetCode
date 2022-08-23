import java.time.LocalDate;
import java.util.ArrayList;

class Employee{
    private int salary=0;
    private LocalDate date=null;
    private static int Id=0;
    private int myId=0;

    public Employee() {
    }

    public Employee(int salary, LocalDate date) {
        this.salary = salary;
        this.date = date;
        this.myId = Employee.Id++;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public int getMyId() {
        return myId;
    }

    public void setMyId(int myId) {
        this.myId = myId;
    }

}
class Manager extends Employee{
    private int bounus=0;

    public Manager(int bounus) {
        this.bounus = bounus;
    }

    public Manager(int salary, LocalDate date, int bounus) {
        super(salary, date);
        this.bounus = bounus;
    }

    @Override
    public int getSalary() {
        return super.getSalary()+bounus;
    }
}
public class Test {
    public static void main(String[] args) {
        Employee[] employees=new Employee[3];
        employees[0]=new Employee(12000,LocalDate.now());
        employees[1]=new Employee(13000,LocalDate.now());
        employees[2]=new Manager(13000,LocalDate.now(),2000);
        for (Employee e : employees) {
            System.out.println(""+e.getSalary()+", "+e.getMyId());
        }
        System.out.println(employees[2] instanceof Manager);
    }
}

class Main{
    public static void main(String[] args) {
        System.out.println(Math.round(-1.6));
    }
}
