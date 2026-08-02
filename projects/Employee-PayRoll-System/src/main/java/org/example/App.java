package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Arun Pandey!
 *
 */

//abstraction
abstract class Employee{
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }
//encapsulation
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public abstract double calculateSalary();
    @Override
    public String toString() {
        return "Employee [name=" + name + ", id=" + id +", salary=" + calculateSalary()+"]";
    }
}

//inheritance
class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary){
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    //polymorphism
    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
}
class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    //polymorphism
    @Override
    public double calculateSalary() {
        return (hoursWorked * hourlyRate);
    }
}
class PayRollSystem {
    private List<Employee> employeeList;
    //private List<Employee> employees = new ArrayList<Employee>();

    public PayRollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {
       Employee employeeToRemove = null;
       for (Employee employee : employeeList) {
           if (employee.getId() == id) {
               employeeToRemove = employee;
               break;
           }
       }
       if (employeeToRemove != null) {
           System.out.println("Removed employee: " + employeeToRemove.getId());
           employeeList.remove(employeeToRemove);
       }

    }
   public void displayEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
   }
}


public class App 
{
    public static void main( String[] args )
    {
       PayRollSystem payRollSystem = new PayRollSystem();
       FullTimeEmployee emp1 = new  FullTimeEmployee("Raj", 1, 80000.00);
       PartTimeEmployee emp2 = new PartTimeEmployee("Kamal", 2,240, 2000);
       payRollSystem.addEmployee(emp1);
       payRollSystem.addEmployee(emp2);
        System.out.println("Initial Employee Details: " );
        payRollSystem.displayEmployees();
        System.out.println("Removing Employee");
        payRollSystem.removeEmployee(2);
        System.out.println("Remaining Employee Details: " );
        payRollSystem.displayEmployees();
    }
}
