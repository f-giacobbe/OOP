package Esercitazione4;

public abstract class DocumentoAstratto {
    private String testo;
    private String proprietario;
    private String firma;
    private int codiceFirma;    //0 se firmato, 1 se non firmato

    //non firmato
    public DocumentoAstratto(String testo, String proprietario) {
        this.testo = testo;
        this.proprietario = proprietario;
        this.codiceFirma = 1;
    }

    //firmato
    public DocumentoAstratto(String testo, String proprietario, String firma) {
        this.testo = testo;
        this.proprietario = proprietario;
        this.firma = firma;
        this.codiceFirma = 0;
    }

    public String getTesto() {
        return testo;
    }

    public String getProprietario() {
        return proprietario;
    }

    protected String getFirma() {
        return firma;
    }

    protected int getCodiceFirma() {
        return codiceFirma;
    }


    protected abstract boolean checkSign();

    public boolean eFirmato() {
        return this.firma == null || !(this.firma.isEmpty());
    }
}
