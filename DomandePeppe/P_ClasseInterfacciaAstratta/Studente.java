package DomandePeppe.P_ClasseInterfacciaAstratta;

public class Studente extends Persona implements Interfaccia {

    private String cognome;
    private int matricola;

    public Studente(String cognome, int matricola) {
        super(cognome);
        this.matricola = matricola;
    }

    // Dobbiamo implementare i metodi astratti sia dell'interfaccia che della classe
    public void Presentati() {
        System.out.println("Sono lo studente " + this.cognome + " con matricola: " + this.matricola);
    }

    public void Saluta() {
        System.out.println("Ciao!");
    }
}
