package gestioneelencoecb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Nominativo {
    
    private int id;
    private String nome;
    private String cognome;
    private Date dataNascita;
    private String email;
    private boolean attivo;
    
    // costruttore vuoto
    public Nominativo() {  }
    
    // costruttore
    public Nominativo(
            int id,
            String nome,
            String cognome,
            Date dataNascita,
            String email,
            boolean attivo
    ) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.email = email;
        this.attivo = attivo;
    }
    
    // costruttore
    public Nominativo(ResultSet resultSet) {
        try {
            if(resultSet.isBeforeFirst()) {
                resultSet.next();
                
                this.id = resultSet.getInt("ID_Utente");
                this.nome = resultSet.getString("Nome");
                this.cognome = resultSet.getString("Cognome");
                this.dataNascita = resultSet.getDate("DataNascita");
                this.email = resultSet.getString("Email");
                this.attivo = resultSet.getBoolean("Attivo");
            }
        }
        catch(SQLException ex) {
            System.out.println("Errore SQL: " + ex.getMessage());
            System.exit(0);
        }
    }
    
    public int getId() {
        return this.id;
    }
    public String getNome() {
        return this.nome;
    }
    public String getCognome() {
        return this.cognome;
    }
    public Date getDataNascita() {
        return this.dataNascita;
    }
    public String getEmail() {
        return this.email;
    }
    public boolean isAttivo() {
        return this.attivo;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setAttivo(boolean attivo) {
        this.attivo = attivo;
    }
    
}
