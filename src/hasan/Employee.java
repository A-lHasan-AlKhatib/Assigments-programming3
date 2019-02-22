package hasan;

/**
 *
 * @author Handy
 */
public class Employee {

    private String name;
    private String department;
    private double salary;
    public static int count;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setSalary(double salary, double bonus) {
        this.salary = salary + getBonus(bonus);
    }

    public static int getCount() {
        return count;
    }

    public double getBonus(double bonus) {
        return salary * bonus;
    }

    public static Employee[] sortByName(Employee[] employees) {
        Employee temp;
        for (int i = 0; i < employees.length - 1; i++) {
            if ((employees[i].getName().compareTo(employees[i + 1].
                    getName())) > 0) {
                temp = employees[i];
                employees[i] = employees[i + 1];
                employees[i + 1] = temp;
            }
        }
        return employees;
    }

    public static Employee[] sortByDepartment(Employee[] employees) {
        Employee temp;
        for (int i = 0; i < employees.length - 1; i++) {
            if ((employees[i].getDepartment().compareTo(employees[i + 1].
                    getDepartment())) > 0) {
                temp = employees[i];
                employees[i] = employees[i + 1];
                employees[i + 1] = temp;
            }
        }
        return employees;
    }

    @Override
    public String toString() {
        return "Name : " + name + " Department : " + department + " Salary : " +
                String.format("%.2f", salary);
    }
}
