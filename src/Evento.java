
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

    private String titolo;
    private LocalDate date;
    private int totalePosti;
    private int postiPrenotati;

    /*Quando si istanzia un nuovo evento questi attributi devono essere tutti valorizzati nel costruttore, tranne posti prenotati
    che va inizializzato a 0. */
    public Evento(String titolo, LocalDate date, int totalePosti) {
        this.titolo = titolo;
        this.date = date;
        this.totalePosti = totalePosti;
        this.postiPrenotati = 0;
    
/*Inserire il controllo che la data non sia già passata e che il numero di posti totali sia positivo. 
In caso contrario sollevare eccezione. */
    if(date == null || date.isBefore(LocalDate.now())){
    throw new IllegalArgumentException("La data non è valida");
} else {
    this.date = date;
}

    if(totalePosti <= 0){
        throw new IllegalArgumentException("Il numero di posti totali non può essere negativo o 0.");
    } else {
        this.totalePosti = totalePosti;
    }
}

    /*Aggiungere metodi getter e setter in modo che:
    titolo sia in lettura e in scrittura
    data sia in lettura e scrittura
    numero di posti totale sia solo in lettura
    numero di posti prenotati sia solo in lettura
 */

    
    
    public void setTitolo(String titolo){
        if(titolo == null || titolo.isBlank()){ //System.out.println("Entra nell'if");
            System.out.println("Il titolo non può essere vuoto.");
        } else if(titolo.matches("\\d+")){
            System.out.println("Il titolo non può contenere solo numeri");
        }else { //System.out.println("Esce dall'if");
            this.titolo = titolo;
        }
    }
    public String getTitolo() {
        return titolo;
    }

    public LocalDate getDate() {
        return date;
    }
    public LocalDate setDate(){
        return date;
    }

    public int getTotalePosti() {
        return totalePosti;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }    

    /*Vanno inoltre implementati dei metodi public che svolgono le seguenti funzioni:
 - prenota: aggiunge uno ai posti prenotati. Se l’evento è già passato o non ha posti 
            disponibili deve sollevare eccezione. */

public void prenota(){
    boolean prenotato = false;
if(date.isBefore(LocalDate.now())){
    System.out.println("Non puoi prenotare un posto per un evento già passato.");
} else if (postiPrenotati >= totalePosti){
    System.out.println("Non ci sono più posti disponibili per la prenotazione.");
} else {
    postiPrenotati++;
    totalePosti--;
System.out.println("Prenotazione per l'evento effettuata.");
}
}
/* - disdici: riduce di uno i posti prenotati. Se l’evento è già passato o non ci sono prenotazioni 
solleva eccezione.
 */

 public void disdici() {
    if(date.isBefore(LocalDate.now())){
        System.out.println("Non puoi disdire la prenotazione perchè l'evento è già passato.");
    } else if(postiPrenotati == 0){
        System.out.println("Non ci sono prenotazioni effettute.");
    }else {
        postiPrenotati --;
        totalePosti ++;
        System.out.println("Disdetta effettuata.");
    }
 }

 /* - l’override del metodo toString() in modo che venga restituita una stringa contenente: data formattata - titolo */

 @Override
 public String toString(){
    DateTimeFormatter dataFormattata = DateTimeFormatter.ofPattern("dd/MM/yyy");
    return "Data: " + date.format(dataFormattata) + " - Titolo : " + titolo;
 }
}
