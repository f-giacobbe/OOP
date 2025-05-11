package Simulazione2;

public enum Taglio {
    UN_CENT(0.01f),
    DUE_CENT(0.02f),
    CINQUE_CENT(0.05f),
    DIECI_CENT(0.1f),
    VENTI_CENT(0.2f),
    CINQUANTA_CENT(0.5f),
    UN_EURO(1f),
    DUE_EURO(2f),
    CINQUE_EURO(5f),
    DIECI_EURO(10f),
    VENTI_EURO(20f),
    CINQUANTA_EURO(50f),
    CENTO_EURO(100f),
    DUECENTO_EURO(200f);

    private final float valore;

    Taglio(float valore) {
        this.valore = valore;
    }

    public float getValore() {
        return valore;
    }

    public static Taglio valoreToTaglio(float v) {
        for (Taglio t : Taglio.values()) {
            if (t.getValore() == v) {
                return t;
            }
        }

        throw new IllegalArgumentException("Non esiste un taglio da " + v + "€");
    }
}
