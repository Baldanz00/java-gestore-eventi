
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

    /*Creare una classe Evento che abbia le seguenti proprietà:
    - titolo
    - data
    - numero di posti in totale
    - numero di posti prenotati
*/
    private String title;
    private LocalDate date;
    private int totalPlace;
    private int totalReservation;

    /*Quando si istanzia un nuovo evento questi attributi devono essere tutti valorizzati nel costruttore, tranne posti prenotati 
che va inizializzato a 0.*/
public Evento(String title, LocalDate date, int totalPlace) {
        this.title = title;
        this.date = date;
        this.totalPlace = totalPlace;
        this.totalReservation = 0;

/*Inserire il controllo che la data non sia già passata e che il numero di posti totali sia positivo. In caso contrario sollevare eccezione.
Aggiungere metodi getter e setter in modo che:
- titolo sia in lettura e in scrittura
- data sia in lettura e scrittura
- numero di posti totale sia solo in lettura
- numero di posti prenotati sia solo in lettura
 */
        if(date == null || date.isBefore(LocalDate.now())){
    throw new IllegalArgumentException("La data non è valida");
} else {
    this.date = date;
}

    if(totalPlace <= 0){
        throw new IllegalArgumentException("Il numero di posti totali non può essere negativo o 0.");
    } else {
        this.totalPlace = totalPlace;
    }
}

        
    public void setTitolo(String title){
        if(title == null || title.isBlank()){ //System.out.println("Entra nell'if");
            System.out.println("Il titolo non può essere vuoto.");
        } else if(title.matches("\\d+")){
            System.out.println("Il titolo non può contenere solo numeri");
        }else { //System.out.println("Esce dall'if");
            this.title = title;
        }
    }
    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }
    public LocalDate setDate(){
        return date;
    }

    public int getTotalPlace() {
        return totalPlace;
    }

    public int getTotalReservation() {
        return totalReservation;
    }    

    /*Vanno inoltre implementati dei metodi public che svolgono le seguenti funzioni:
 - prenota: aggiunge uno ai posti prenotati. Se l’evento è già passato o non ha posti 
            disponibili deve sollevare eccezione. */

public void prenota(){
if(date.isBefore(LocalDate.now())){
    System.out.println("Non puoi prenotare un posto per un evento già passato.");
} else if (totalReservation >= totalPlace){
    System.out.println("Non ci sono più posti disponibili per la prenotazione.");
} else {
    totalReservation++;
    totalPlace--;
;
}
}
/* - disdici: riduce di uno i posti prenotati. Se l’evento è già passato o non ci sono prenotazioni 
solleva eccezione.
 */

 public void disdici() {
    if(date.isBefore(LocalDate.now())){
        System.out.println("Non puoi disdire la prenotazione perchè l'evento è già passato.");
    } else if(totalReservation == 0){
        System.out.println("Non ci sono prenotazioni effettute.");
    }else {
        totalReservation --;
        totalPlace ++;
        System.out.println("Disdetta effettuata.");
    }
 }

 /* - l’override del metodo toString() in modo che venga restituita una stringa contenente: data formattata - titolo */

 @Override
 public String toString(){
    DateTimeFormatter dataFormattata = DateTimeFormatter.ofPattern("dd/MM/yyy");
    return "Data: " + date.format(dataFormattata) + " - Titolo : " + title;
 }
}
