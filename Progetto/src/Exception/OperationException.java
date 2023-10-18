package Exception;

/**
 * Questa classe gestisce le eccezioni relative alle operazioni effettuate dal
 * controller
 */

public class OperationException extends Exception {
    public OperationException() {
    }

    public OperationException(String msg) {
        super(msg);
    }
}