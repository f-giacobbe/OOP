package Lezione6;

public class Manager extends Employee {
    private double bonus;

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Manager(String name, double salary, int y, int m, int d) {
        super(name, salary, y, m, d);
        //il bonus lo inizializziamo a zero, poi andrà settato con il setBonus()
    }


    @Override
    public final double getSalary() {
        return super.getSalary() + bonus;
    }
}
