package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Exception.DAOException;
import Exception.DBConnectionException;

/**
 * Classe DAO per la gestione degi Acquisti
 */

public class AcquistoDAO {


    public static int getLastIdAcquisto() throws DAOException, DBConnectionException {

        int idAcquisto = 0;

        try {

            Connection conn = DBManager.getConnection();

            String query = "SELECT MAX(IDACQUISTO) FROM ACQUISTO ;";

            try {

                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet resultSet = stmt.executeQuery();
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }

            } catch (SQLException e) {
                throw new DBConnectionException("Errore get id acquisto");
            } finally {
                // Chiusura della connessione
                DBManager.closeConnection();
            }

        } catch (SQLException e) {
            throw new DBConnectionException("Errore connessione database");
        }

        return idAcquisto;
    }

   /**
   * Ottiene il prezzo associato all'ultimo ID di acquisto dalla tabella ACQUISTO.
   *
   * @return prezzo                Il prezzo associato all'ultimo ID di acquisto come un valore double.
   * @throws DAOException          Se si verifica un errore nell'accesso al database.
   * @throws DBConnectionException Se si verifica un errore nell'instaurazione di una connessione al database.
   */
   public static double getPrezzoByLastIdAcquisto() throws DAOException, DBConnectionException {
   double prezzo = 0.0;

    try {
        Connection conn = DBManager.getConnection();
        String query = "SELECT TOTALESPESA FROM ACQUISTO WHERE IDACQUISTO = ?";

        int lastIdAcquisto = getLastIdAcquisto(); // Ottieni l'ultimo ID di acquisto

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, lastIdAcquisto);

            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    prezzo = resultSet.getDouble("TOTALESPESA");
                }
            } catch (SQLException e) {
                throw new DBConnectionException("Errore nell'ottenere il prezzo per l'ultimo ID di acquisto");
            }
        } catch (SQLException e) {
            throw new DBConnectionException("Errore nell'eseguire la query per ottenere il prezzo");
        } finally {
            // Chiusura della connessione
            DBManager.closeConnection();
        }

    } catch (SQLException e) {
        throw new DBConnectionException("Errore connessione database");
    }

    return prezzo;
 }

}
