package Exception;

/**
 * Questa classe gestisce le eccezioni di tipo DBConnectionException
 */

public class DBConnectionException extends Exception {
    public DBConnectionException() {
    }

    public DBConnectionException(String msg) {
        super(msg);
    }
}