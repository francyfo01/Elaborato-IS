package Database;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Exception.DAOException;
import Exception.DBConnectionException;

public class ScontoDAO {

    /**
     * Ottiene la percentuale dell'eventuale sconto con codice corrispondente trovato nel DB
     *
     * @param  codice il codice sconto da cercare
     * @return La percentuale di sconto associata al codice sconto, 0 se il codice non è valido.
     * @throws DAOException          Se si verifica un errore nell'accesso al database.
     * @throws DBConnectionException Se si verifica un errore nell'instaurazione di una connessione al database.
     */
    public static int readPercentualeSconto(String codice) throws DAOException, DBConnectionException {
        int percentuale = 0; // Valore di default nel caso lo sconto non venga trovato

        try {
            Connection conn = DBManager.getConnection();
            String query = "SELECT PERCENTUALE FROM SCONTO WHERE CODICE = ?;";

            try {
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, codice);
                ResultSet result = stmt.executeQuery();

                if (result.next()) {
                    percentuale = result.getInt(1);
                }
            } catch (SQLException e) {
                throw new DAOException("Errore lettura codice sconto");
            } finally {
                DBManager.closeConnection();
            }
        } catch (SQLException e) {
            throw new DBConnectionException("Errore di connessione DB");
        }

        return percentuale;
    }

}

