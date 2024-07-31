import java.util.Arrays;

public class EmployeeManagement {
    private Employee[] employees;
    private int size;

    public EmployeeManagement(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Add an employee
    public void addEmployee(Employee employee) {
        if (size == employees.length) {
            // Resize the array if it's full
            employees = Arrays.copyOf(employees, employees.length * 2);
        }
        employees[size++] = employee;
    }

    // Search for an employee by ID
    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse and print all employees
    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete an employee by ID
    public void deleteEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                // Shift elements to the left
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null;
                return;
            }
        }
    }

    public static void main(String[] args) {
        EmployeeManagement management = new EmployeeManagement(2);

        // Add employees
        management.addEmployee(new Employee("E001", "Alice", "Manager", 75000));
        management.addEmployee(new Employee("E002", "Bob", "Developer", 50000));
        management.addEmployee(new Employee("E003", "Charlie", "Designer", 60000));

        // Traverse employees
        System.out.println("All Employees:");
        management.traverseEmployees();

        // Search for an employee
        System.out.println("\nSearching for Employee with ID E002:");
        Employee employee = management.searchEmployee("E002");
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found.");
        }

        // Delete an employee
        System.out.println("\nDeleting Employee with ID E002");
        management.deleteEmployee("E002");

        // Traverse employees again
        System.out.println("\nAll Employees after Deletion:");
        management.traverseEmployees();
    }
