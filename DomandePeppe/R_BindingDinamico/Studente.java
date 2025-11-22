package DomandePeppe.R_BindingDinamico;

public class Studente extends Persona {

    private String cognome, nome;
    private int matricola;

    public Studente(String cognome, String nome, int matricola) {
        super(cognome, nome);
        this.matricola = matricola;
    }

    @Override
    public void Presentati() {
        System.out.println("Sono uno studente e mi chiamo " + this.cognome + " " + this.nome
                + " e la mia matricola e\' " + this.matricola);
    }

}
