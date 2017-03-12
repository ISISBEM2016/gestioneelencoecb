package gestioneelencoecb;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StampaElenco {
    
    private final DBMSControl dbmsControl;
    private Nominativo nominativo;
    
    // costruttore
    public StampaElenco() {
        this.dbmsControl = new DBMSControl();
    }
    
    public void stampa() {
        dbmsControl.connetti();
        String query = "SELECT * FROM elenco";
        try {
            ResultSet resultSet = dbmsControl.doQuery(query);
            while(resultSet.next()) {
                this.nominativo = new Nominativo(resultSet);
                
                String id = resultSet.getString("ID_Utente");
                String firstName = resultSet.getString("Nome");
                String lastName = resultSet.getString("Cognome");
                
                System.out.println("ID: " + id + ", nome: " + firstName + ", cognome: " + lastName);
            }
            System.out.println("Numero dei record: " + dbmsControl.getNumeroRighe(resultSet));
        } 
        catch (SQLException ex) {
            System.out.println("Errore nell'esecuzione della query!");
        }
        dbmsControl.disconnetti();
    }
    
}
