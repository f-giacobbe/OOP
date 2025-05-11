package Simulazione2;

import java.util.Iterator;
import java.util.List;

public abstract class SoldiAstratto implements Soldi {
    private List<Denaro> collezione;

    protected SoldiAstratto(List<Denaro> collezione) {
        this.collezione = collezione;
    }

    @Override
    public Iterator<Denaro> iterator() {
        return collezione.iterator();
    }

    @Override
    public void add(Denaro d) {
        //se nella collezione ho già questo taglio
        for (Denaro den : collezione) {
            if (den.getValore() == d.getValore()) {
                den.setQuantita(den.getQuantita() + d.getQuantita());
                return;
            }
        }

        //altrimenti, se è da aggiungere
        collezione.add(d);
        collezione.sort(Denaro::compareTo);

        //collezione.sort((d1, d2) -> {return Float.compare(d1.getValore(), d2.getValore());});
    }

    @Override
    public void add(Soldi s) {
        for (Denaro d : s) {
            add(d);
        }
    }

    @Override
    public void sub(Denaro d) {
        for (Denaro den : collezione) {
            if (den.getValore() == d.getValore() && den.getQuantita() >= d.getQuantita()) {
                den.setQuantita(den.getQuantita() - d.getQuantita());
                return;
            }
        }

        throw new TaglioMancanteException();
    }
}
