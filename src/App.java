
import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args)  {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Inserisci i dati dell'evento: ");
            System.out.println("Titolo dell'evento:");
            String titolo = scan.nextLine();
            
            System.out.println("\nInserisci la data dell'evento:");
            System.out.println("\nAnno:");
            int year = scan.nextInt();
            
            System.out.println("\nMese:");
            int mounth = scan.nextInt();
            
            System.out.println("\nGiorno:");
            int day = scan.nextInt();
            
            LocalDate dateOfEvent = LocalDate.of(year, mounth, day);
            
            System.out.println("\nInserisci il numero di posti totali: ");
            int totalPlace = scan.nextInt();
            scan.nextLine();
            
            Evento evento1 = new Evento(titolo, dateOfEvent, totalPlace);
            System.out.println("\nEvento creato. \n Dettagli evento: " + evento1);
            
            /*Dopo che l’evento è stato istanziato, chiedere all’utente se e quante prenotazioni vuole fare e provare ad effettuarle,
            implementando opportuni controlli */
            
            System.out.println("\nVuoi effettuare una prenotazione? \nScegli : \n - 1 :  effettuare una prenotazione; \n - 2 : non effettuare nessuna prenotazione.");
            int scelta = scan.nextInt();
            if(scelta == 1){
                boolean validator = false;
                while(!validator){
                    System.out.println("Quanti posti vuoi prenotare?");
                    int prenotazioni = scan.nextInt();
                    scan.nextLine();
            
                    if(prenotazioni == 0){
                        System.out.println("Nessuna prenotazione effettuata");
                        validator = true;
                    } else if ( prenotazioni <0){
                        System.err.println("Errore: il numero di prenotazioni non è valido");
            
                    }else if(prenotazioni > (evento1.getTotalPlace()- evento1.getTotalReservation())){
                        System.err.println("Errore: non ci sono posti disponibili.");
                    } else {
                        for ( int i = 0; i < prenotazioni; i++){
                            evento1.prenota();
                        }
                        System.out.println("Prenotazione per l'evento: " + evento1.getTitle() + " effettuata");
                        validator = true;
                    }
                }
                    
                /*Stampare a video il numero di posti prenotati e quelli disponibili */
                System.out.println("Posti prenotati: " + evento1.getTotalReservation());
                System.out.println("Posti disponibili: " + evento1.getTotalPlace());
            } else if (scelta == 2) {
                System.out.println("Non hai effettuato nessuna prenotazione per questo evento");
            }
            
            //DISDIRE LE PRENOTAZIONI
            System.out.println("\n Vuoi disdire una prenotazione per l'evento " + evento1.getTitle() + " ?");
            System.out.println("Scegli: \n - 1 : vuoi disdire una prenotazione; \n - 2 : non disdire prenotazioni;");
            int sceltaDisdetta = scan.nextInt();
            if(sceltaDisdetta == 1){
            boolean disdire = false;
            while (!disdire){
                System.out.println("Puoi cancellare 1 prenotazione alla volta. Scrivi 1 per confermare la cancellazione. ");
                int prenotazioniDisdette = scan.nextInt();
                scan.nextLine();
            
                if(sceltaDisdetta == 0){
                    System.out.println("Nessuna disdetta effettuata.");
                    disdire = true;
                } else if( sceltaDisdetta < 0 || sceltaDisdetta > evento1.getTotalReservation()){
                    System.err.println("Errore: non ci sono prenotazioni da disdire.");
                
                } else {
                    for ( int i = 0; i < sceltaDisdetta; i++){
                        evento1.disdici();
                    }
                    System.out.println("Disdetta per l'evento " + evento1.getTitle() + " effettuata");
                    disdire = true;
                }
                }
                System.out.println("\n Posti prenotati: " + evento1.getTotalReservation());
                System.out.println("\n Posti disponibili: " + evento1.getTotalPlace());
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Errore durante la creazione dell'evento: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Errore generico: " + e.getMessage());
        } finally {
            System.out.println();
        }
    }

}

