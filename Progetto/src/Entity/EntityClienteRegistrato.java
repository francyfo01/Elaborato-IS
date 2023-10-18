package Entity;

/**
 * Classe Entity per la gestione dei Clienti Registrati
 */

public class EntityClienteRegistrato {
    private String nome;
    private String cognome;
    private Indirizzo indirizzo;
    private String email;
    private String username;
    private String password;
    private String cartadicredito;

    /**
     * 
     * Costruttore della classe EntityClienteRegistrato.
     * 
     * @param nome                Nome del cliente registrato
     * @param cognome             Cognome del cliente registrato
     * @param indirizzo           Indirizzo del cliente registrato
     * @param email               Email del cliente registrato
     * @param username            Username del cliente registrato
     * @param password            Password del cliente registrato
     * @param cartadicredito      Cartadicredito del cliente registrato
     */

    public EntityClienteRegistrato(String nome, String cognome,
            Indirizzo indirizzo, String email, String username, String password, String cartadicredito) {

        setNome(nome);
        setCognome(cognome);
        setIndirizzo(indirizzo);
        setEmail(email);
        setUsername(username);
        setPassword(password);
        setCartadicredito(cartadicredito);
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

    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCartadicredito() {
        return cartadicredito;
    }

    public void setCartadicredito(String cartadicredito) {
        this.cartadicredito = cartadicredito;
    }

}