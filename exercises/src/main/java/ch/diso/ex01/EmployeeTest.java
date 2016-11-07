package ch.diso.ex01;

import java.text.NumberFormat;

public class EmployeeTest {

    public static void main(String[] args) {

        Engineer eng = new Engineer(101, "Arno Hofstette", "012-34-5678", 120_345.27);

        Manager mgr = new Manager(207, "Daniel Meienberg", "054-12-2367", 109_501.36, "Sales");

        Admin adm = new Admin(304, "Gisela Kaiser", "108-23-6509", 75_002.34);

        Director dir = new Director(12, "Daniel Senften", "099-45-2340", 120_567.36, "Corporate", 100_000.00);

        printEmployee(eng);
        printEmployee(adm);
        printEmployee(mgr);
        printEmployee(dir);

        System.out.println("\nTesting raiseSalary and setName on Manager:");
        mgr.setName("Peter Vögeli");
        mgr.raiseSalary(10000);
        printEmployee(mgr);

    }

    public static void printEmployee(Employee emp) {
         System.out.println(); // Print a blank line as a separator
         // Print out the data in this Employee object
         System.out.println("Employee type:   " + emp.getClass().getSimpleName());
         System.out.println(emp);
     }

     public static void printEmployee(Employee emp, EmployeeStockPlan esp) {
         printEmployee (emp);
         System.out.println("Stock Options:   " + esp.grantStock(emp));
     }

}