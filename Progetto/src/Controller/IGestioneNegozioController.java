package Controller;

import Exception.OperationException;

/**
 * Questa classe rappresenta l'interfaccia del controller 
*/

public interface IGestioneNegozioController{

    public void aggiungiDipendente(String nome, String cognome, String codFiscale) throws OperationException;

    public boolean controlloEmail(String email) throws OperationException;

    public int controlloSconto(String codice) throws OperationException;

}
