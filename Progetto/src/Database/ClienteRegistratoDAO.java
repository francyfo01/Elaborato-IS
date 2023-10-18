package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Exception.DAOException;
import Exception.DBConnectionException;

/**
 * Classe DAO per la gestione degi Clienti Registrati
 */

public class ClienteRegistratoDAO {

    public static int readClienteRegistrato(String email)
            throws DAOException, DBConnectionException {

        int clienteEsiste = 0;

        try {

            Connection conn = DBManager.getConnection();

            String query = "SELECT COUNT(*) AS clienteEsiste FROM CLIENTEREGISTRATO WHERE EMAIL=? ;";

            try {
                PreparedStatement stmt = conn.prepareStatement(query);

                stmt.setString(1, email);

                ResultSet result = stmt.executeQuery();
                if (result.next()) {
                    clienteEsiste = result.getInt("clienteEsiste");
                }

            } catch (SQLException e) {
                throw new DBConnectionException("Errore readClienteRegistrato");
            } finally {
                // Chiusura della connessione
                DBManager.closeConnection();
            }

        } catch (SQLException e) {
            throw new DBConnectionException("Errore connessione database");
        }

        return clienteEsiste;

    }

}