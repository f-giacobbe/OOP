package Lezione6;

public class Main {
    public static void main(String[] args) {
        Employee[] ae = new Employee[3];
        Object[] ao = new Object[3];
        ae[0] = new Employee("a", 5, 1, 1, 1);
        Manager m = new Manager("m", 5, 1, 1, 1);
        m.setBonus(1000);
        ae[1] = m;
        ae[2] = new Employee("b", 6, 1, 1, 1);
        ao[0] = ae[2];
        ao[1] = m;
        ao[2] = ae[0];
        double meanS = 0;
        for (int i = 0; i < ae.length; i++) {
            meanS += ae[i].getSalary();
            /* al secondo run, viene eseguito il getSalary della classe Employee, e successivamente
            viene aggiunto anche il bonus dato dal fatto che è del sottotipo Manager
             */
        }
        meanS /= ae.length;
        System.out.println(meanS);
    }



}
