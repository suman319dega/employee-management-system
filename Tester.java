public class Tester extends Employee {

    private String testingTool;

    public Tester(int id, String name, int age,
                  String department, String designation,
                  double salary, String testingTool) {

        super(id, name, age, department, designation, salary);
        this.testingTool = testingTool;
    }

    public String getTestingTool() {
        return testingTool;
    }

    @Override
    public void work() {
        System.out.println(
                getName() + " is testing software using "
                + testingTool + "."
        );
    }

    @Override
    public double calculateBonus() {
        return getSalary() * 0.08;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Testing Tool: "
                + testingTool;
    }
}