package Lezione7;

public class Student extends Person {
    /* mi dà subito errore perché manca l'implementazione del metodo getDescription(), dichiarato
    * astratto e pubblico nella classe Person */

    private String major;

    public Student(String name, String major) {
        super(name);
        this.major = major;
    }

    @Override
    public String getDescription() {
        return this.getName() + " " + this.major;
    }
}
