package Esercitazione4;

public class Report extends DocumentoAstratto implements StampaDocumento {
    private String destinatario;
    private String[] parametri;
    private boolean[] raggiuntiParametri;

    public Report(String testo, String proprietario, String firma, String destinatario, String[] parametri, boolean[] raggiuntiParametri) {
        super(testo, proprietario, firma);
        this.destinatario = destinatario;
        this.parametri = parametri;
        this.raggiuntiParametri = raggiuntiParametri;
    }

    @Override
    protected boolean checkSign() {
        return super.getProprietario().equals(super.getFirma());
    }

    @Override
    public void stampaDocumento() {
        System.out.println("Report stampato!");
    }
}
