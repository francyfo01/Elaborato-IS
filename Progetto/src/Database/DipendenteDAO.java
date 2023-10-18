package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Entity.EntityDipendente;
import Exception.DAOException;
import Exception.DBConnectionException;

public class DipendenteDAO {

    /**
     * Inserisce un dipendente nel database.
     * 
     * @param  dipendente            L'oggetto EntityDipendente da inserire nel database.
     * @throws DAOException          Se si verifica un errore nell'accesso al database.
     * @throws DBConnectionException Se si verifica un errore nell'instaurazione di una connessione al database.
     */
    public static void insertDipendente(EntityDipendente dipendente) throws DAOException, DBConnectionException {

        try {
            Connection conn = DBManager.getConnection();
            String query = "INSERT INTO DIPENDENTE (nome, cognome, codfiscale) VALUES (?, ?, ?);";

            try {
                PreparedStatement stmt = conn.prepareStatement(query);

                stmt.setString(1, dipendente.getNome());
                stmt.setString(2, dipendente.getCognome());
                stmt.setString(3, dipendente.getCodFiscale());

                stmt.executeUpdate();
                
            } catch (SQLException e) {
                throw new DAOException("Errore durante l'inserimento del dipendente");
            } finally {
                DBManager.closeConnection();
            }
        } catch (SQLException e) {
            throw new DBConnectionException("Errore di connessione DB");
        }
    }
}




