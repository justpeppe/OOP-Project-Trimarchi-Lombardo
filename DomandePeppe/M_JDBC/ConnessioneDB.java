package DomandePeppe.M_JDBC;

import java.sql.*;

public class ConnessioneDB {

    // Definiamo le nostre variabili
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:8080/mydb";
    private static final String username = "user";
    private static final String password = "529962";

    public static void main(String[] args) {
        // Creiamo una connessione
        Connection connection = null;

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, username, password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("ERRORE: " + e.getMessage());
        } finally {

            // Se la connessione è aperta chiudiamola
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
