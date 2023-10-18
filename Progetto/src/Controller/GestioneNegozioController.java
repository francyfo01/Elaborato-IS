package Controller;

import Database.AcquistoDAO;
import Database.ClienteRegistratoDAO;
import Database.DipendenteDAO;
import Database.ScontoDAO;
import Entity.EntityDipendente;
import Exception.DAOException;
import Exception.DBConnectionException;
import Exception.OperationException;

/**
 * 
 * Classe controller per la gestione del negozio
 * 
 */
public class GestioneNegozioController {

    private static GestioneNegozioController instance;

    /*
     * Funziona getInstance per la condivisione globale di un istanza
     */

    protected GestioneNegozioController() {

    }

    public static synchronized GestioneNegozioController getInstance() {
        if (instance == null) {
            instance = new GestioneNegozioController();
        }
        return instance;
    }

    /**
     * Aggiunge un dipendente al sistema.
     * 
     * @param nome        Nome del nuovo dipendente.
     * @param cognome     Cognome del nuovo dipendente.
     * @param codfiscale  Codice fiscale del nuovo dipendente.
     * @throws OperationException Se si verifica un errore durante l'operazione di inserimento.
     */
    
    public void aggiungiDipendente(String nome, String cognome, String codfiscale) throws OperationException {
        try {

            EntityDipendente dipendente = new EntityDipendente(nome, cognome, codfiscale);

            // Inserisce il dipendente nel database
            DipendenteDAO.insertDipendente(dipendente);

        } catch (DAOException | DBConnectionException e) {
            throw new OperationException("\nRiscontrato problema interno applicazione!\n");
        }
    }


    
    /**
     * Controlla se un'email è presente nel sistema.
     * 
     * @param email L'email da controllare.
     * @return True se l'email è presente nel sistema, false altrimenti.
     * @throws OperationException Se si verifica un errore durante l'operazione di
     *                            controllo dell'email.
     */

    public boolean controlloEmail(String email)
    throws OperationException {

     int ClienteEsiste = 0;

     try {

     ClienteEsiste = ClienteRegistratoDAO.readClienteRegistrato(email);

     if (ClienteEsiste != 0) {
         return true;
     } else
         return false;

     } catch (DAOException | DBConnectionException e) {

     throw new OperationException("\nRiscontrato problema interno applicazione!\n");
     }

    }


    /**
     * Controlla se il codice sconto e' valido.
     * 
     * @param codice              codice dello sconto da controllare.
     * @return True               se l'email è presente nel sistema, false altrimenti.
     * @throws OperationException Se si verifica un errore durante l'operazione di
     *                            controllo del codice sconto
     */

    public static int controlloSconto(String codice) throws OperationException {

        int percentuale = 0;

        try {

            percentuale = ScontoDAO.readPercentualeSconto(codice);

        } catch (DAOException | DBConnectionException e) {
            throw new OperationException("\nRiscontrato problema interno applicazione!\n");
        }

        return percentuale;

    }

    /**
     * Calcola il prezzo totale dell'acquisto
     * 
     * @param idacquisto           ID ultimo acquisto
     * @return prezzo              Il totale dell'acquisto su cui si può applicare lo sconto
     * @throws OperationException  Se si verifica un errore durante l'operazione di calcolo del prezzo totale
     */

    public static double calcolaPrezzoTotale() throws OperationException{

        try {
            
            AcquistoDAO.getLastIdAcquisto(); // Ottieni l'ID dell'ultimo acquisto
            double prezzo = AcquistoDAO.getPrezzoByLastIdAcquisto(); // Ottieni il prezzo usando l'ID dell'ultimo acquisto

            return prezzo;

        } catch (DAOException | DBConnectionException e) {
            throw new OperationException("\nRiscontrato problema interno applicazione!\n");
        }
        
    }

}

