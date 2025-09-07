
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
/*Creare una classe Main di test, in cui si chiede all’utente di inserire un nuovo evento con tutti i parametri. */
System.out.println("Inserisci i dati dell'evento: titolo, data, numero di posti totali. \n Inserisci il titolo: ");

String titolo = scan.nextLine();
boolean dataValida = false;
while (!dataValida){
    try {
System.out.println("Inserisci la data dell'evento divisa per giorno , mese , anno. \n Inserisci il giorno:");
int giorno = scan.nextInt();
System.out.println("Inserisci il mese:");
int mese = scan.nextInt();
System.out.println("Inserisci l'anno:");
int anno = scan.nextInt();
LocalDate date = LocalDate.of(anno, mese, giorno);
dataValida = true;
    } catch (DateTimeException e){
        System.out.println("Data non valida");
        scan.nextLine();
    }
}
System.out.println("Inserisci il numero di posti totali.");
int totalePosti = scan.nextInt();
scan.nextLine();

Evento evento1 = new Evento(titolo, date, totalePosti);
System.out.println("\n Evento creato.");
System.out.println("Dettagli evento: " + evento1);

/*Dopo che l’evento è stato istanziato, chiedere all’utente se e quante prenotazioni vuole fare e provare ad effettuarle,
implementando opportuni controlli */

System.out.println("Vuoi effettuare una prenotazione? Scegli : \n - 1 : per effettuare una prenotazione; \n - 2 : non effettuare nessuna prenotazione.");
int scelta = scan.nextInt();
if(scelta == 1){
        System.out.println("Quanti posti vuoi prenotare?");
        int prenotazioniEffettuate = scan.nextInt();
        scan.nextLine();

        if(scelta == 2){
            System.out.println("Nessuna prenotazione effettuata.");
            
        } else if( prenotazioniEffettuate < 0){
            throw new IllegalArgumentException("Il numero di prenotazioni non può essere negativo");
        }else if( prenotazioniEffettuate > (evento1.getTotalePosti()-evento1.getPostiPrenotati())){
            throw new IllegalArgumentException("Non ci sono posti disponibili");
        } else {
            for (int i = 0; i < prenotazioniEffettuate; i++){
                evento1.prenota();
            }
            
            
        }
    }

    /*Stampare a video il numero di posti prenotati e quelli disponibili */
    System.out.println("Posti prenotati: " + evento1.getPostiPrenotati());
    System.out.println("Posti disponibili: " + evento1.getTotalePosti());

/*Chiedere all’utente se e quanti posti vuole disdire */
System.out.println("Vuoi disdire una prenotazione? Scegli:  \n - 1 : disdire una prenotazione; \n - 2 : non disdire nessuna prenotazione");
int scelta2 = scan.nextInt();
if(scelta2 == 1){
        System.out.println("Quante prenotazioni vuoi disdire?");
        int disdette = scan.nextInt();
    
        if(disdette == 0){
            System.out.println("Non hai effettuato nessuna disdetta.");
            
        } else if( disdette < 0 ){
            throw new IllegalArgumentException("Numero disdette non valido.");
        }else if(disdette > evento1.getPostiPrenotati()){
            throw new IllegalArgumentException("Non ci sono prenotazioni da disdire");
            
        }else {
            for (int i = 0; i < disdette; i++){
                evento1.disdici();
            }
            System.out.println("Disdetta della prenotazione effettuata");
            
        }
    }
    System.out.println("Posti prenotati: " + evento1.getPostiPrenotati());
    System.out.println("Posti disponibili: " + evento1.getTotalePosti());
    }
}

