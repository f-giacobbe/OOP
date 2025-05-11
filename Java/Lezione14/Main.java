package Lezione14;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Student> students = new TreeSet<>(new StudentComparator());

        //ANONYMOUS INNER CLASS
        Comparator<Student> comp = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getId().compareTo(o2.getId());
            }
        };

        var s1 = new Student("1234", "Smith", "PierAristilde");
        var s2 = new Student("35564", "Moore", "PierCarmelo");
        var s3 = new Student("77324234", "Mason", "Nick");
        var s4 = new Student("7432534", "Barrett", "Sid");
        var s5 = new Student("98912473", "Gilmour", "David");
        var s6 = new Student("454564", "Waters", "Roger");

        students.add(s1);
        System.out.println(students);
        students.add(s2);
        System.out.println(students);
        students.add(s3);
        System.out.println(students);
        students.add(s4);
        System.out.println(students);
        students.add(s5);
        System.out.println(students);
        students.add(s6);
        System.out.println(students);
    }
}


class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        int res = o1.getSurname().compareTo(o2.getSurname());

        if (res != 0) {
            return res;
        }

        //cognome uguale
        res = o1.getName().compareTo(o2.getName());

        if (res != 0) {
            return res;
        }

        //anche stesso nome
        res = o1.getId().compareTo(o2.getId());

        return res;
    }
}