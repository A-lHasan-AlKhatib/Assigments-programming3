/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hasan;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Handy
 */
public class Try {

    public static Employee[] byScanner(Employee[] employees) {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < employees.length; i++) {
            String name, department;
            double salary;
            System.out.println("Employee number  " + (i + 1) + ".\nEnter the name.");
            name = scan.nextLine();
            System.out.println("Enter the department.");
            department = scan.nextLine();
            System.out.println("Enter the salary.");
            salary = Double.parseDouble(scan.nextLine());
            employees[i] = new Employee(name, department, salary);
        }
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        return employees;
    }

    public static Employee[] byJpoint(Employee[] employees) {

        for (int i = 0; i < employees.length; i++) {
            String name, department;
            double salary;
            JOptionPane.showMessageDialog(null, String.format("Employee number"
                    + " %d", (i + 1)), "name", JOptionPane.INFORMATION_MESSAGE);
            name = JOptionPane.showInputDialog("Enter  Name");
            department = JOptionPane.showInputDialog("Enter  Department");
            salary = (Double.parseDouble(JOptionPane.
                    showInputDialog("Enter Salary")));
            employees[i] = new Employee(name, department, salary);
        }
        String strings = "";
        for (Employee employee : employees) {
            strings += employee + "\n";
        }
        JOptionPane.showMessageDialog(null, strings, "name",
                JOptionPane.INFORMATION_MESSAGE);
        return employees;
    }

    public static void commands() {
        Employee[] employees = new Employee[4];
        employees[0] = new Employee("Hasan", "IT", 3720);
        employees[1] = new Employee("Ahmad", "Sales", 2500);
        employees[2] = new Employee("Tamer", "Manegement", 3050);
        employees[3] = new Employee("Khalid", "HR", 2220);

        Employee.sortByName(employees);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("************************************************");
        Employee.sortByDepartment(employees);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
      //  employees = byScanner(employees);
      //  employees = byJpoint(employees);
      commands();
    }
}
