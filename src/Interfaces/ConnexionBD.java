package Interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/gestion_conge";
    private static final String UTILISATEUR = "root";  // L'utilisateur pour se connecter � MySQL
    private static final String MOT_DE_PASSE = "";  // Le mot de passe pour MySQL (si vide, laisse le comme �a)

    // M�thode pour v�rifier si l'utilisateur existe
    public static boolean verifierUtilisateur(String email, String password) {
        String requete = "SELECT * FROM admins WHERE email = ? AND password = ?";  // Requ�te SQL pour v�rifier l'email et le mot de passe

        try (Connection connexion = DriverManager.getConnection(URL, UTILISATEUR, MOT_DE_PASSE);
             PreparedStatement statement = connexion.prepareStatement(requete)) {
            
            // Remplacement des param�tres dans la requ�te SQL
            statement.setString(1, email);
            statement.setString(2, password);
            
            ResultSet result = statement.executeQuery();

            return result.next();  // Si la requ�te retourne une ligne, cela signifie que l'utilisateur est trouv�

        } catch (SQLException e) {
            System.err.println("Erreur lors de la connexion ou v�rification : " + e.getMessage());
            return false;
        }
    }
}
