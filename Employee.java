public class Employee {

    private int id;
    private String name;
    private int age;
    private String department;
    private String designation;
    private double salary;

    public Employee(int id, String name, int age,
                    String department, String designation,
                    double salary) {

        this.id = id;
        setName(name);
        setAge(age);
        setDepartment(department);
        setDesignation(designation);
        setSalary(salary);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public String getDesignation() {
        return designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid employee name.");
        }
    }

    public void setAge(int age) {
        if (age >= 18) {
            this.age = age;
        } else {
            System.out.println("Employee age must be 18 or above.");
        }
    }

    public void setDepartment(String department) {
        if (department != null && !department.trim().isEmpty()) {
            this.department = department;
        } else {
            System.out.println("Invalid department.");
        }
    }

    public void setDesignation(String designation) {
        if (designation != null && !designation.trim().isEmpty()) {
            this.designation = designation;
        } else {
            System.out.println("Invalid designation.");
        }
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            System.out.println("Salary must be greater than zero.");
        }
    }

    public void work() {
        System.out.println(name + " is working.");
    }

    public double calculateBonus() {
        return salary * 0.05;
    }

    @Override
    public String toString() {
        return "ID: " + id
                + ", Name: " + name
                + ", Age: " + age
                + ", Department: " + department
                + ", Designation: " + designation
                + ", Salary: " + salary;
    }
}