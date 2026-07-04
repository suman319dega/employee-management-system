import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EmployeeService service = new EmployeeService();

        while (true) {

            displayMenu();

            int choice;

            try {

                System.out.print("Enter Choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

            } catch (InputMismatchException exception) {

                System.out.println(
                        "Invalid input. Please enter a number."
                );

                scanner.nextLine();
                continue;
            }

            switch (choice) {

                case 1:
                    addEmployee(scanner, service);
                    break;

                case 2:
                    service.viewEmployees();
                    break;

                case 3:
                    searchEmployee(scanner, service);
                    break;

                case 4:
                    updateEmployee(scanner, service);
                    break;

                case 5:
                    deleteEmployee(scanner, service);
                    break;

                case 6:
                    searchByDepartment(scanner, service);
                    break;

                case 7:
                    increaseSalary(scanner, service);
                    break;

                case 8:
                    employeesAboveSalary(scanner, service);
                    break;

                case 9:
                    System.out.println(
                            "Total Employees: "
                            + service.getEmployeeCount()
                    );
                    break;

                case 10:
                    displayDepartmentCount(service);
                    break;

                case 11:
                    displayUniqueDepartments(service);
                    break;

                case 12:
                    displayEmployeeWork(scanner, service);
                    break;

                case 13:
                    displayEmployeeBonus(scanner, service);
                    break;

                case 14:
                    System.out.println(
                            "Thank you for using "
                            + "Employee Management System."
                    );

                    scanner.close();
                    return;

                default:
                    System.out.println(
                            "Invalid choice. Select between 1 and 14."
                    );
            }
        }
    }

    private static void displayMenu() {

        System.out.println(
                "\n===== EMPLOYEE MANAGEMENT SYSTEM ====="
        );

        System.out.println("1. Add Employee");
        System.out.println("2. View Employees");
        System.out.println("3. Search Employee");
        System.out.println("4. Update Employee");
        System.out.println("5. Delete Employee");
        System.out.println("6. Search by Department");
        System.out.println("7. Increase Salary");
        System.out.println("8. Employees Above Salary");
        System.out.println("9. Total Employees");
        System.out.println("10. Department Wise Employee Count");
        System.out.println("11. View Unique Departments");
        System.out.println("12. Display Employee Work");
        System.out.println("13. Calculate Employee Bonus");
        System.out.println("14. Exit");
    }

    private static void addEmployee(
            Scanner scanner,
            EmployeeService service) {

        try {

            System.out.println("\nEmployee Types");
            System.out.println("1. Developer");
            System.out.println("2. Manager");
            System.out.println("3. Tester");
            System.out.println("4. General Employee");

            System.out.print("Select Employee Type: ");
            int type = scanner.nextInt();

            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Department: ");
            String department = scanner.nextLine();

            System.out.print("Enter Designation: ");
            String designation = scanner.nextLine();

            System.out.print("Enter Salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine();

            Employee employee;

            switch (type) {

                case 1:
                    System.out.print(
                            "Enter Programming Language: "
                    );

                    String programmingLanguage
                            = scanner.nextLine();

                    employee = new Developer(
                            id,
                            name,
                            age,
                            department,
                            designation,
                            salary,
                            programmingLanguage
                    );

                    break;

                case 2:
                    System.out.print("Enter Team Size: ");
                    int teamSize = scanner.nextInt();
                    scanner.nextLine();

                    employee = new Manager(
                            id,
                            name,
                            age,
                            department,
                            designation,
                            salary,
                            teamSize
                    );

                    break;

                case 3:
                    System.out.print("Enter Testing Tool: ");
                    String testingTool = scanner.nextLine();

                    employee = new Tester(
                            id,
                            name,
                            age,
                            department,
                            designation,
                            salary,
                            testingTool
                    );

                    break;

                case 4:
                    employee = new Employee(
                            id,
                            name,
                            age,
                            department,
                            designation,
                            salary
                    );

                    break;

                default:
                    System.out.println(
                            "Invalid employee type."
                    );
                    return;
            }

            boolean added = service.addEmployee(employee);

            if (added) {
                System.out.println(
                        "Employee added successfully."
                );
            } else {
                System.out.println(
                        "Employee ID already exists."
                );
            }

        } catch (InputMismatchException exception) {

            System.out.println(
                    "Invalid input. Enter valid numeric values."
            );

            scanner.nextLine();
        }
    }

    private static void searchEmployee(
            Scanner scanner,
            EmployeeService service) {

        System.out.println("1. Search by ID");
        System.out.println("2. Search by Name");

        System.out.print("Enter Search Type: ");
        int searchType = scanner.nextInt();
        scanner.nextLine();

        Employee employee;

        if (searchType == 1) {

            System.out.print("Enter Employee ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            employee = service.searchEmployee(id);

        } else if (searchType == 2) {

            System.out.print("Enter Employee Name: ");
            String name = scanner.nextLine();

            employee = service.searchEmployee(name);

        } else {

            System.out.println("Invalid search type.");
            return;
        }

        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void updateEmployee(
            Scanner scanner,
            EmployeeService service) {

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter New Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter New Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter New Department: ");
        String department = scanner.nextLine();

        System.out.print("Enter New Designation: ");
        String designation = scanner.nextLine();

        System.out.print("Enter New Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        boolean updated = service.updateEmployee(
                id,
                name,
                age,
                department,
                designation,
                salary
        );

        if (updated) {
            System.out.println(
                    "Employee updated successfully."
            );
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void deleteEmployee(
            Scanner scanner,
            EmployeeService service) {

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (service.deleteEmployee(id)) {

            System.out.println(
                    "Employee deleted successfully."
            );

        } else {

            System.out.println("Employee not found.");
        }
    }

    private static void searchByDepartment(
            Scanner scanner,
            EmployeeService service) {

        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        service.searchByDepartment(department);
    }

    private static void increaseSalary(
            Scanner scanner,
            EmployeeService service) {

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();

        System.out.print("Enter Increment Amount: ");
        double amount = scanner.nextDouble();

        scanner.nextLine();

        if (service.increaseSalary(id, amount)) {

            System.out.println(
                    "Salary increased successfully."
            );

        } else {

            System.out.println(
                    "Employee not found or invalid amount."
            );
        }
    }

    private static void employeesAboveSalary(
            Scanner scanner,
            EmployeeService service) {

        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        service.employeesAboveSalary(salary);
    }

    private static void displayDepartmentCount(
            EmployeeService service) {

        HashMap<String, Integer> departmentCount
                = service.getDepartmentEmployeeCount();

        if (departmentCount.isEmpty()) {

            System.out.println("No employee data available.");
            return;
        }

        System.out.println(
                "\n===== DEPARTMENT EMPLOYEE COUNT ====="
        );

        departmentCount.forEach(
                (department, count) ->
                        System.out.println(
                                department + " : " + count
                        )
        );
    }

    private static void displayUniqueDepartments(
            EmployeeService service) {

        HashSet<String> departments
                = service.getUniqueDepartments();

        if (departments.isEmpty()) {

            System.out.println("No departments found.");
            return;
        }

        System.out.println("\n===== UNIQUE DEPARTMENTS =====");

        for (String department : departments) {
            System.out.println(department);
        }
    }

    private static void displayEmployeeWork(
            Scanner scanner,
            EmployeeService service) {

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        service.displayEmployeeWork(id);
    }

    private static void displayEmployeeBonus(
            Scanner scanner,
            EmployeeService service) {

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        service.displayEmployeeBonus(id);
    }
}