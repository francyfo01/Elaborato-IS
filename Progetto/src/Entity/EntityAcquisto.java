package Entity;


/**
 * Classe Entity per la gestione degli Acquisti
 */

public class EntityAcquisto {

    private int idAcquisto;
    private int totaleSpesa;

    /**
     * 
     * Costruttore della classe EntityAcquisto.
     * 
     * @param idAcquisto   ID dell'acquisto
     * @param totaleSpesa  costo totale dell'acquisto
     * 
     */

    public EntityAcquisto(int idAcquisto, int totaleSpesa) {
        setIdAcquisto(idAcquisto);
        setTotaleSpesa(totaleSpesa);
    }

    // metodi Get e Set per gli attributi

    public int getIdAcquisto() {
        return idAcquisto;
    }

    public void setIdAcquisto(int idAcquisto) {
        this.idAcquisto = idAcquisto;
    }

    public int getTotaleSpesa() {
        return totaleSpesa;
    }

    public void setTotaleSpesa(int totaleSpesa) {
        this.totaleSpesa = totaleSpesa;
    }


}
