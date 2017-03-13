package gestioneelencoecb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBMSControl {
    
    private Connection connection;
    private Statement statement;
    
    private final String connectionUrl = "jdbc:mysql://localhost:3306/test";
    private final String user = "test";
    private final String password = "test";

    // costruttore vuoto 
    public DBMSControl() {}
    
    public void connetti() {
        System.out.print("Connessione al DBMS in corso... ");
        try {
            connection = DriverManager.getConnection(connectionUrl, user, password);
            statement = connection.createStatement();
            System.out.println("connesso!");
        } 
        catch (SQLException ex) {
            System.out.println("Errore di connessione al DBMS, l'applicazione verrà terminata");
            System.exit(0);
        }
    }

    public void disconnetti() {
        System.out.print("Disconnessione dal DBMS in corso... ");
        try {
            statement.close();
            connection.close();
            System.out.println("disconnesso!");
        } 
        catch (SQLException ex) {
            System.out.println("Errore nella disconnessione dal DBMS!");
        }
    }
    
    public ResultSet doQuery(String query) {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);
            return resultSet;
        } 
        catch (SQLException ex) {
            System.out.println("Errore nell'esecuzione della query!");
        }
        return resultSet;
    }

    public void doUpdate(String query) {
        try {
            statement.executeUpdate(query);
        } 
        catch (SQLException ex) {
            System.out.println("Errore nell'esecuzione della query!");
        }
    }
    
    public int getNumeroRighe(ResultSet resultSet) {
        int size;
        try {
            resultSet.last();
            size = resultSet.getRow();
            resultSet.beforeFirst();
        }
        catch(Exception ex) {
            return 0;
        }
        return size;
    }

    
}
