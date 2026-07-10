package DSA.employee;

public class EmployeeTest {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5);

        // Add employees
        manager.addEmployee(new Employee("E101", "Alice", "Developer", 60000));
        manager.addEmployee(new Employee("E102", "Bob", "Manager", 80000));
        manager.addEmployee(new Employee("E103", "Charlie", "Tester", 50000));

        // Traverse
        manager.traverseEmployees();

        // Search
        Employee emp = manager.searchEmployee("E102");
        System.out.println("\nSearch Result: " + (emp != null ? emp : "Not Found"));

        // Delete
        manager.deleteEmployee("E103");

        // Final traverse
        manager.traverseEmployees();
    }
}

