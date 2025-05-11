package Simulazione1;

import java.util.List;
import java.util.Iterator;

public abstract class SoldiAbstract implements Soldi, Cloneable {
    private List<Denaro> collezioneOrdinata;

    @Override
    public void add(Denaro d) {
        //verifico se la collezione contiene già almeno un taglio di questo tipo
        for (Denaro d1 : this) {
            if (d1.getValore() == d.getValore()) {
                d1.setQuantita(d1.getQuantita() + d.getQuantita());
                return;
            }
        }
        collezioneOrdinata.add(d);
    }

    @Override
    public void add(Soldi s) {
        for (Denaro d : s) {
            this.add(d);
        }
    }

    @Override
    public void sub(Denaro d) {
        for (Denaro d1 : this) {
            if (d1.getValore() == d.getValore()) {
                //verifica se ho abbastanza quantità del denaro
                if (d1.getQuantita() < d.getQuantita()) {
                    throw new RuntimeException("Non ci sono abbastanza tagli di questo tipo");
                }

                //altrimenti, se ce ne sono abbastanza, procedo con la rimozione
                d1.setQuantita(d1.getQuantita() - d.getQuantita());
                return;
            }
        }

        throw new RuntimeException("Non possiedi tagli di questo tipo");
    }

    @Override
    public Iterator<Denaro> iterator() {
        return collezioneOrdinata.iterator();
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
