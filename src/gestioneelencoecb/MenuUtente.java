package gestioneelencoecb;

import java.util.Scanner;

public class MenuUtente {
    
    private StampaElenco stampaElenco;
    private InserimentoNominativo inserimentoNominativo;
    private ModificaNominativo modificaNominativo;
    private EliminazioneNominativo eliminazioneNominativo;
    
    // costruttore vuoto
    public MenuUtente() {}
    
    public void menu() {
        Scanner daTastiera = new Scanner(System.in);
        String risposta;
        
        System.out.println("Menu principale:");
        System.out.println("1 - Stampa elenco nominativi");
        System.out.println("2 - Inserisci un nuovo nominativo");
        System.out.println("3 - Modifica un nominativo");
        System.out.println("4 - Elimina un nominativo");
        System.out.println("5 - Esci");
        System.out.println("\n------------\n");
        System.out.print("Scegli una voce dal menu: ");

        risposta = daTastiera.nextLine();

        switch(risposta) {
            case "1":
                stampaElenco = new StampaElenco();
                stampaElenco.stampa();
                break;
            case "2":
                inserimentoNominativo = new InserimentoNominativo();
                inserimentoNominativo.inserisci();
                break;
            case "3":
                modificaNominativo = new ModificaNominativo();
                modificaNominativo.modifica();
                break;
            case "4":
                eliminazioneNominativo = new EliminazioneNominativo();
                eliminazioneNominativo.elimina();
                break;
            case "5":
                System.exit(0);
                break;
            default:
                System.out.println("Scelta non valida!");
        }
        System.out.println("\n------------\n");
        menu();
    }
    
}
