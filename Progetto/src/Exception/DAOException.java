package Exception;

/**
 * Questa classe gestisce le eccezioni di tipo DAOException
 */

public class DAOException extends Exception {
    public DAOException() {
    }

    public DAOException(String msg) {
        super(msg);
    }
}