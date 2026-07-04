public class Developer extends Employee {

    private String programmingLanguage;

    public Developer(int id, String name, int age,
                     String department, String designation,
                     double salary, String programmingLanguage) {

        super(id, name, age, department, designation, salary);
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    @Override
    public void work() {
        System.out.println(
                getName() + " is writing "
                + programmingLanguage + " code."
        );
    }

    @Override
    public double calculateBonus() {
        return getSalary() * 0.10;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Programming Language: "
                + programmingLanguage;
    }
}