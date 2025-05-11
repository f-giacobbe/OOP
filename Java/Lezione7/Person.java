package Lezione7;

public abstract class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getDescription();
            ///////metodo astratto; dovrà essere implementato nella classe figlia
}
