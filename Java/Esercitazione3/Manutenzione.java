package Esercitazione3;

public interface Manutenzione {
    void eseguiManutenzione();
    int stimaProssimaManutenzione();

    default void eseguiManutenzioneLista(Manutenzione[] a) {
        for (Manutenzione m : a) {
            if (this.stimaProssimaManutenzione() < 1000)
                this.eseguiManutenzione();
        }
    }
}
