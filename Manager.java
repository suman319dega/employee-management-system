public class Manager extends Employee {

    private int teamSize;

    public Manager(int id, String name, int age,
                   String department, String designation,
                   double salary, int teamSize) {

        super(id, name, age, department, designation, salary);
        this.teamSize = teamSize;
    }

    public int getTeamSize() {
        return teamSize;
    }

    @Override
    public void work() {
        System.out.println(
                getName() + " is managing a team of "
                + teamSize + " employees."
        );
    }

    @Override
    public double calculateBonus() {
        return getSalary() * 0.20;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Team Size: "
                + teamSize;
    }
}