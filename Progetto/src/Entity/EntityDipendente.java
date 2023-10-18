package Entity;

/**
 * Classe Entity per la gestione dei Dipendenti
 */

public class EntityDipendente {
    private String nome;
    private String cognome;
    private String codfiscale;

    /**
     * 
     * Costruttore della classe EntityDipendente.
     * 
     * @param nome                Nome del dipendente
     * @param cognome             Cognome del dipendente
     * @param codfiscale          Codice Fiscale del dipendente
     */


    public EntityDipendente(String nome, String cognome,
     String codfiscale) {

        setNome(nome);
        setCognome(cognome);
        setCodfiscale(codfiscale);
    }

    // metodi Get e Set per gli attributi


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCodFiscale() {
        return codfiscale;
    }

    public void setCodfiscale(String codfiscale) {
        this.codfiscale = codfiscale;
    }

}
