
import java.time.LocalDate;
import java.time.LocalTime;

public class Concerto extends Evento{

    private LocalTime ora;
    private double prezzo;
    
    public Concerto(String titolo, LocalDate date, int totalePosti, LocalTime ora, double prezzo) {
        super(titolo, date, totalePosti); 
        this.ora = ora;

        if(prezzo < 0 ){
            throw new IllegalArgumentException("Il prezzo non può essere inferiore di 0.");
        }
        this.prezzo = prezzo;
    }

    public LocalTime getOra(){
        return ora;
    }
    
    public void setOra(LocalTime ora){
        if(ora == null || ora.isBefore(LocalTime.now())){
            throw new IllegalArgumentException("Ora non valida");
        }
        this.ora = ora;
    }

    public void getPrezzo(double prezzo){
        if(prezzo < 0){
            throw new IllegalArgumentException("Prezzo non valido");
        }
        this.prezzo = prezzo;
    }
}
