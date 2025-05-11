package Lezione18;

public enum Valore {
    ASSO(1),
    DUE(2),
    TRE(3),
    QUATTRO(4),
    CINQUE(5),
    SEI(6),
    SETTE(7),
    DONNA(8),
    CAVALLO(9),
    RE(10);

    private final int value;

    Valore(int v) {
        //evito il controllo siccome privato
        this.value = v;
    }

    public int getValue() {
        return value;

        //return this.ordinal() + 1;        -- stessa cosa, ma meno elegante
    }
}
