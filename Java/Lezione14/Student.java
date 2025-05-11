package Lezione14;

public class Student {
    private final String id;
    private final String surname;
    private final String name;


    public Student(String id, String surname, String name) {
        this.id = id;
        this.surname = surname;
        this.name = name;
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Student s)) {
            return false;
        }

        return s.id.equals(this.id);
    }

    @Override
    public final int hashCode() {
        return id.hashCode();
    }

    public String getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "("+surname+","+name+")["+id+"]";
    }
}
