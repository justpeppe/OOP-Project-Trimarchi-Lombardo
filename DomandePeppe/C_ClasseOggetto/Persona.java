package DomandePeppe.C_ClasseOggetto;

// La classe è la struttura astratta degli oggetti
// Esempio persona
public class Persona {

    private String nome, cognome;
    private int eta;

    // Questo è il costruttore default che restituisce il
    // riferimento in memoria dell'oggetto
    public Persona(String nome, String cognome, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

    public void Presentati() {
        System.out.println("Mi chiamo " + this.nome + " " + this.cognome + " e ho " + this.eta + " anni");
    }

}
