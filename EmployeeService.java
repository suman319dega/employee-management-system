import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class EmployeeService {

    private final ArrayList<Employee> employees = new ArrayList<>();

    public boolean addEmployee(Employee employee) {

        if (searchEmployee(employee.getId()) != null) {
            return false;
        }

        employees.add(employee);
        return true;
    }

    public void viewEmployees() {

        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public Employee searchEmployee(int id) {

        for (Employee employee : employees) {

            if (employee.getId() == id) {
                return employee;
            }
        }

        return null;
    }

    public Employee searchEmployee(String name) {

        for (Employee employee : employees) {

            if (employee.getName().equalsIgnoreCase(name)) {
                return employee;
            }
        }

        return null;
    }

    public boolean updateEmployee(
            int id,
            String name,
            int age,
            String department,
            String designation,
            double salary) {

        Employee employee = searchEmployee(id);

        if (employee == null) {
            return false;
        }

        employee.setName(name);
        employee.setAge(age);
        employee.setDepartment(department);
        employee.setDesignation(designation);
        employee.setSalary(salary);

        return true;
    }

    public boolean deleteEmployee(int id) {

        Employee employee = searchEmployee(id);

        if (employee == null) {
            return false;
        }

        employees.remove(employee);
        return true;
    }

    public void searchByDepartment(String department) {

        boolean found = false;

        for (Employee employee : employees) {

            if (employee.getDepartment()
                    .equalsIgnoreCase(department)) {

                System.out.println(employee);
                found = true;
            }
        }

        if (!found) {
            System.out.println(
                    "No employees found in department: "
                    + department
            );
        }
    }

    public boolean increaseSalary(int id, double amount) {

        Employee employee = searchEmployee(id);

        if (employee == null || amount <= 0) {
            return false;
        }

        employee.setSalary(
                employee.getSalary() + amount
        );

        return true;
    }

    public void employeesAboveSalary(double salary) {

        boolean found = false;

        for (Employee employee : employees) {

            if (employee.getSalary() > salary) {
                System.out.println(employee);
                found = true;
            }
        }

        if (!found) {
            System.out.println(
                    "No employees found above salary: "
                    + salary
            );
        }
    }

    public int getEmployeeCount() {
        return employees.size();
    }

    public HashMap<String, Integer> getDepartmentEmployeeCount() {

        HashMap<String, Integer> departmentCount
                = new HashMap<>();

        for (Employee employee : employees) {

            String department = employee.getDepartment();

            departmentCount.put(
                    department,
                    departmentCount.getOrDefault(
                            department, 0
                    ) + 1
            );
        }

        return departmentCount;
    }

    public HashSet<String> getUniqueDepartments() {

        HashSet<String> departments = new HashSet<>();

        for (Employee employee : employees) {
            departments.add(employee.getDepartment());
        }

        return departments;
    }

    public void displayEmployeeWork(int id) {

        Employee employee = searchEmployee(id);

        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }

        employee.work();
    }

    public void displayEmployeeBonus(int id) {

        Employee employee = searchEmployee(id);

        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }

        System.out.println(
                "Employee Bonus: "
                + employee.calculateBonus()
        );
    }
}