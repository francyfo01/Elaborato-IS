package Boundary;

import java.util.Scanner;

import Controller.GestioneNegozioController;

import Exception.OperationException;

/**
 * Classe Boundary per la gestione dei clienti
 */

public class BoundaryCliente {

    private Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {
        BoundaryCliente cliente = new BoundaryCliente();
        cliente.effettuaAcquisto();
    }

    /**
     * Gestisce la fase finale dell'acquisto e l'inserimento di un eventuale
     * codice sconto
     */

    public void effettuaAcquisto() {

        GestioneNegozioController controller = GestioneNegozioController.getInstance();    
          
        try {
            boolean sconto = false;
            boolean inputValido;


            // Controllo dell'email
            System.out.println("Inserisci la tua email per iniziare l'acquisto:");
            String email = scan.next();
            boolean emailValida = controller.controlloEmail(email);


            if (emailValida){

              System.out.println("Hai un codice sconto da inserire?");

              inputValido = false;
              while (!inputValido) {
                try {
                    System.out.println("\nDigita (1) se hai un codice");
                    System.out.println("Digita (2) se non hai un codice");
                    String input3 = scan.next();
                    int scelta1 = Integer.parseInt(input3);

                    if (scelta1 == 1) {
                        inputValido = true;
                        sconto = true;
                    } else if (scelta1 == 2) {
                        inputValido = true;
                    } else {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\nAssicurati di inserire un numero corretto. Riprovare...");
                }
              }   

            }else{
                System.out.println("Email non registrata. Impossibile applicare un codice sconto.");
            }

            if (sconto) {
                inputValido = false;
                while (!inputValido) {
                    System.out.println("Inserisci il codice sconto:");
                    String codice = scan.next();

                    // Controllo della validità dello sconto
                    int percentuale = GestioneNegozioController.controlloSconto(codice);

                    if (percentuale != 0) {
                        System.out.println("Hai ottenuto uno sconto del " + percentuale + "%");
                        double prezzoTotale = GestioneNegozioController.calcolaPrezzoTotale(); // Calcola il prezzo totale
                        double importoSconto = (prezzoTotale * percentuale) / 100;

                        prezzoTotale = prezzoTotale - importoSconto;

                        System.out.println("Il nuovo prezzo scontato è: " + prezzoTotale);

                        inputValido = true;
                    } else {
                        System.out.println("Codice sconto non valido. Riprovare...");
                    }
                }
            }

            System.out.println("Vuoi confermare l'acquisto?");

            inputValido = false;
            while (!inputValido) {
                try {
                    System.out.println("\nDigita (1) per la conferma");
                    System.out.println("Digita (2) per annullare");
                    String input4 = scan.next();
                    int scelta2 = Integer.parseInt(input4);

                    if (scelta2 == 1) {
                        effettuaPagamento(); // Esegue il pagamento
                        System.out.println("Grazie per averci scelto.");
                    } else if (scelta2 == 2) {
                        System.out.println("Grazie per aver visitato il nostro negozio. Alla prossima!");
                        inputValido = true;
                    } else {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\nAssicurati di inserire un numero corretto. Riprovare...");
                }
            }
        } catch (OperationException oE) {
            System.out.println(oE.getMessage());
            System.out.println("Riprovare..\n");
        } catch (Exception e) {
            System.out.println("Unexpected exception, riprovare..");
            System.out.println();
        }
    }

    
    private void effettuaPagamento() {
        System.out.println("Pagamento effettuato!");
    }
}
