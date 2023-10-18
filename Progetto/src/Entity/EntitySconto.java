package Entity;

/**
 * Classe Entity per la gestione degli sconti
 */

public class EntitySconto {

    private int idSconto;
    private String codice;
    private int percentuale;

    /**
     * 
     * Costruttore della classe EntitySconto.
     * 
     * @param idsconto    id che identifica ll codice sconto
     * @param codice      codice identificativo dello sconto
     * @param percentuale percententuale numerica dello sconto
     * 
     */

    public EntitySconto(int idSconto, String codice, int percentuale) {
        setIdSconto(idSconto);
        setCodice(codice);
        setPercentuale(percentuale);
    }

    // metodi get e set per gli attributi

    public int getIdSconto() {
        return idSconto;
    }

    public void setIdSconto(int idSconto) {
        this.idSconto = idSconto;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public int getPercentuale() {
        return percentuale;
    }

    public void setPercentuale(int percentuale) {
        this.percentuale = percentuale;
    }


}
