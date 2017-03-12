package gestioneelencoecb;

import java.util.Scanner;

public class EliminazioneNominativo {
    
    private final DBMSControl dbmsControl;
    
    // costruttore
    public EliminazioneNominativo() {
        this.dbmsControl = new DBMSControl();
    }
    
    public void elimina() {
        dbmsControl.connetti();
        Scanner daTastiera = new Scanner(System.in);
        
        System.out.print("Indica l'ID del nominativo da eliminare: ");
        String id = daTastiera.nextLine();
        
        String query = "DELETE from elenco WHERE ID_Utente = " + id;
        System.out.println("Eseguo: " + query);
        
        dbmsControl.doUpdate(query);
        dbmsControl.disconnetti();
    }
    
}
