package Entity;

/**
 * Questa classe gestisce l'attributo Indirizzo
 */

public class Indirizzo {
    private String via;
    private int numeroCivico;
    private String citta;
    private String provincia;

    /**
     * 
     * Costruttore della classe Indirizzo.
     * 
     * @param via          Nome della via
     * @param numeroCivico Numero civico
     * @param citta        Nome della città
     * @param provincia    Nome della provincia
     */

    public Indirizzo(String via, int numeroCivico, String citta, String provincia) {
        setVia(via);
        setNumeroCivico(numeroCivico);
        setCitta(citta);
        setProvincia(provincia);

    }

    // metodi get e set per gli attributi

    public int getNumeroCivico() {
        return numeroCivico;
    }

    public void setNumeroCivico(int numeroCivico) {
        this.numeroCivico = numeroCivico;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

}