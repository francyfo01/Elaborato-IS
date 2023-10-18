package Boundary;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import Controller.GestioneNegozioController;
import Exception.OperationException;

/**
 * Classe Boundary per la gestione del proprietario
 */

public class BoundaryProprietario {

    Scanner scanner = new Scanner(System.in);
    private static final Pattern CF_PATTERN = Pattern.compile("^[A-Z0-9]+$");
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z]+$");

    public static void main(String[] args) {
        BoundaryProprietario proprietario = new BoundaryProprietario();
        proprietario.start();
    }

    /**
     * Gestisce l'inserimento di uno o più dipendenti richiedendo e validando le
     * informazioni necessarie
     */

     public void start() {

        GestioneNegozioController controller = GestioneNegozioController.getInstance();
    
        try {
    
            System.out.println("Benvenuto, Proprietario!");
    
            while (true) {
                System.out.println("Seleziona un'opzione:");
                System.out.println("1) Inserimento nuovi dipendenti");
                System.out.println("2) Esci dal sistema");
    
                int scelta = scanner.nextInt();
    
                if (scelta == 1) {
                    int numDipendenti;
                    do {
                        System.out.print("Inserisci il numero di dipendenti da aggiungere (almeno 1): ");
                        numDipendenti = scanner.nextInt();
    
                        if (numDipendenti < 1) {
                            System.out.println("Errore: il numero di dipendenti deve essere almeno 1.");
                        }
                    } while (numDipendenti < 1);
    
                    scanner.nextLine(); // Consuma il newline
    
                    for (int i = 0; i < numDipendenti; i++) {
                        System.out.print("Inserisci il nome del dipendente: ");
                        String nome = scanner.nextLine();
    
                        while (!isValidName(nome)) {
                            System.out.println("Errore: il nome contiene numeri o simboli. Riprova.");
                            System.out.print("Inserisci il nome del dipendente: ");
                            nome = scanner.nextLine();
                        }
    
                        System.out.print("Inserisci il cognome del dipendente: ");
                        String cognome = scanner.nextLine();
    
                        while (!isValidName(cognome)) {
                            System.out.println("Errore: il cognome contiene numeri o simboli. Riprova.");
                            System.out.print("Inserisci il cognome del dipendente: ");
                            cognome = scanner.nextLine();
                        }
    
                        String codfiscale;
                        do {
                            System.out.print("Inserisci il codice fiscale del dipendente: ");
                            codfiscale = scanner.nextLine();
    
                            if (!isValidCF(codfiscale)) {
                                System.out.println("Errore: il codice fiscale contiene caratteri speciali. Riprova.");
                            }
                        } while (!isValidCF(codfiscale));
    
                        controller.aggiungiDipendente(nome, cognome, codfiscale);
                        System.out.println("Dipendente aggiunto con successo.");
                    }
                } else if (scelta == 2) {
                    System.out.println("Uscita dal sistema.");
                    break;
                } else {
                    System.out.println("Scelta non valida. Riprova.");
                }
            }
        } catch (OperationException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
        
    // Metodo per verificare se il codice fiscale è valido
    private boolean isValidCF(String codfiscale) {
        Matcher matcher = CF_PATTERN.matcher(codfiscale);
        return matcher.matches();
    }

    // Metodo per verificare se il nome e il cognome contengono solo lettere
    private boolean isValidName(String name) {
        Matcher matcher = NAME_PATTERN.matcher(name);
        return matcher.matches();
    }
}
