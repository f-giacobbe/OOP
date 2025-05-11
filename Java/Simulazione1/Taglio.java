package Simulazione1;

public enum Taglio {
    UN_CENT(0.01f),
    DUE_CENT(0.02f),
    CINQUE_CENT(0.05f),
    DIECI_CENT(0.10f),
    VENTI_CENT(0.20f),
    CINQUANTA_CENT(0.50f),
    UN_EURO(1),
    DUE_EURO(2),
    CINQUE_EURO(5),
    DIECI_EURO(10),
    VENTI_EURO(20),
    CINQUANTA_EURO(50),
    CENTO_EURO(100),
    DUECENTO_EURO(200);

    private final float valore;

    Taglio(float valore) {
        this.valore = valore;
    }

    public float getValore() {
        return valore;
    }
}
