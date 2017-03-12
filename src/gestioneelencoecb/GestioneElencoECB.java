package gestioneelencoecb;

public class GestioneElencoECB {
    
    private MenuUtente menuUtente;
    
    public static void main(String[] args) {
        GestioneElencoECB gestioneElencoDB = new GestioneElencoECB();
        gestioneElencoDB.start();
    }
    
    private void start() {
        menuUtente = new MenuUtente();
        menuUtente.menu();
    }
    
}