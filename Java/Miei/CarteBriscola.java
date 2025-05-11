package Miei;

public enum CarteBriscola {
    ASSO(11),
    DUE(0),
    TRE(10),
    QUATTRO(0),
    CINQUE(0),
    SEI(0),
    SETTE(0),
    DONNA(2),
    CAVALLO(3),
    RE(4);

    private final int punteggio;

    CarteBriscola(int punteggio) {
        this.punteggio = punteggio;
    }

    public int punteggio() {
        return punteggio;
    }
}
