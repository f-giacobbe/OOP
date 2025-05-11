package Esercitazione4;

public class Lettera extends DocumentoAstratto implements StampaDocumento {
    private String mittente;
    private String destinatario;

    public Lettera(String testo, String proprietario, String firma, String mittente, String destinatario) {
        super(testo, proprietario, firma);
        this.mittente = mittente;
        this.destinatario = destinatario;
    }

    @Override
    protected boolean checkSign() {
        return super.getFirma().equals(this.mittente);
    }

    @Override
    public void stampaDocumento() {
        System.out.println("Lettera stampata!");
    }
}
