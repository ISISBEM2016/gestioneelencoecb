package gestioneelencoecb;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InserimentoNominativo {
    
    private final DBMSControl dbmsControl;
    private final Nominativo nominativo;
    
    // costruttore
    public InserimentoNominativo() {
        this.dbmsControl = new DBMSControl();
        this.nominativo = new Nominativo();
    }
    
    public void inserisci() {
        dbmsControl.connetti();
        Scanner daTastiera = new Scanner(System.in);
                
        System.out.print("Inserisci il nome: ");
        nominativo.setNome(daTastiera.nextLine());
        System.out.print("Inserisci il cognome: ");
        nominativo.setCognome(daTastiera.nextLine());
        
        Date dataNascita;
        DateFormat df = new SimpleDateFormat("d/M/y");
        try {    
            System.out.print("Inserisci la data di nascita: ");
            String dataNascitaS = daTastiera.nextLine();
            dataNascita = df.parse(dataNascitaS); 
        } 
        catch (ParseException ex) {
            System.out.println("Errore di validazione della data di nascita!");
            dataNascita = new Date(); 
        }
        nominativo.setDataNascita(dataNascita);
        
        System.out.print("Inserisci l'indirizzo email: ");
        nominativo.setEmail(daTastiera.nextLine());
        System.out.print("Vuoi attivare questo nominativo? (si/no): ");
        String risposta = daTastiera.nextLine();
        nominativo.setAttivo(risposta.equals("si"));
        
        df = new SimpleDateFormat("yyyy-MM-dd");
        String query = "INSERT INTO elenco (Nome, Cognome, DataNascita, Email, Attivo) "
                + "VALUES ('" 
                + nominativo.getNome() + "', '" 
                + nominativo.getCognome() + "', '" 
                + df.format(nominativo.getDataNascita()) + "', '" 
                + nominativo.getEmail() + "', " 
                + (nominativo.isAttivo() ? "1" : "0") 
                + ")";
        System.out.println("Eseguo: " + query);
        
        dbmsControl.doUpdate(query);
        dbmsControl.disconnetti();
    }
    
}
