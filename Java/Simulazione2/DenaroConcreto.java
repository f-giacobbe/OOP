package Simulazione2;

public class DenaroConcreto extends DenaroAstratto {
    private boolean variabileInutile = true;

    public DenaroConcreto(Taglio t, int quantita) {
        super(t, quantita);
    }

    @Override
    public Object clone() {
        DenaroConcreto cloned = (DenaroConcreto) super.clone();
        cloned.variabileInutile = this.variabileInutile;
        return cloned;
    }
}
