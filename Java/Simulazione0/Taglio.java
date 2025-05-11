package Simulazione0;

public enum Taglio {
    CENT(0.01f),
    DUECENTS(0.02f),
    CINQUECENTS(0.05f),
    //continua così
    DIECICENTS(0.1f),
    CINQUANTACENTS(0.5f),
    EURO(1f),
    DUE(2f),
    CINQUE(5f),
    DIECI(10f),
    VENTI(20f),
    CINQUANTA(50f),
    CENTO(100f),
    DUECENTO(200f);

    private final float valore;

    Taglio(float value) {
        this.valore = value;
    }

    public float getValore() {
        return valore;
    }

    public static Taglio findByValue(Float valore) {
        Taglio res = null;
        for (Taglio t : values()) {
            if (valore.equals(t.getValore())) {
                return t;
            }
        }

        throw new IllegalArgumentException("Nessun taglio di valore " + valore);
    }
}
