package Simulazione2;

public class SoldiLC extends SoldiAstratto {
    public SoldiLC() {
        super(new MyLC());
    }

    public SoldiLC(MyLC list) {
        super(list);
    }

    @Override
    public Soldi paga(Soldi s1, Soldi s2) {
        if (s2.totale() < s1.totale()) {
            throw new SoldiInsufficientiException();
        }

        MyLC ret = new MyLC();
        double resto = s2.totale() - s1.totale();
        this.add(s2);   //mi dò i soldi che mi devono pagare

        for (Denaro d : this) {     //scorre dal taglio più grande al più piccolo (vedi compareTo di Denaro) i miei soldi
            if (d.getValore() <= resto) {
                int pezzi = (int) (resto / d.getValore());  //prendo quanti più pezzi possibile che coprano il resto
                d.setQuantita(d.getQuantita() - pezzi); //li tolgo dal mio portafoglio
                ret.add(new DenaroConcreto(Taglio.valoreToTaglio(d.getValore()), pezzi)); //aggiungo quanto tolto alla lista da restituire come resto
                resto -= pezzi * d.getValore();  //tolgo quanto dato dal resto ancora da restituire
            }
        }

        //se non è possibile restituire la differenza esatta a meno di un centesimo
        if (resto > 0.01) {
            //ripristino condizioni iniziali

            //restituisco s2
            for (Denaro d : s2) {
                this.sub(d);
            }

            //mi restituisco il resto che stavo per restituire
            for (Denaro d : ret) {
                this.add(d);
            }

            throw new TaglioMancanteException();
        }

        return new SoldiLC(ret);
    }
}
