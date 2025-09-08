
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgrammaEventi {

    private String titolo;
    private List<Evento> eventi;

    /*Nel costruttore valorizzare il titolo, passato come parametro, e inizializzare la lista 
    di eventi come una nuova ArrayList */

    public ProgrammaEventi(String titolo){
        this.titolo = titolo;
        this.eventi = new ArrayList<>();
    }

    /* AGGIUNGERE UN METODO CHE AGGIUNGA ALLA LISTA UN EVENTO, PASSATO COME PARAMETRO */

    public void aggiungiEvento(Evento evento){
        if(evento == null){
            throw new IllegalArgumentException("Aggiungere un evento per inserirlo nella lista.");
        } eventi.add(evento);
    }

    /*AGGIUNGI UN METODO PER OTTENERE UNA LISTA CON TUTTI GLI EVENTI PRESENTI IN UNA CERTA DATA */

    public List<Evento> getEventiData (LocalDate date){
        List<Evento> eventiPerData = new ArrayList<>();
        for(Evento evento : eventi){
            if(evento.getDate().equals(date)){
                eventiPerData.add(evento);
            }
        }
        return eventiPerData;
    }

    /*METODO PER RESTITUIRE QUANTI EVENTI CI SONO IN PROGRAMMA */

    
}
