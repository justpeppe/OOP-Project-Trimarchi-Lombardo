package DomandePeppe.R_BindingDinamico;

public class Persona {

    private String cognome, nome;

    public Persona(String cognome, String nome) {
        this.cognome = cognome;
        this.nome = nome;
    }

    public void Presentati() {
        System.out.println("Mi chiamo " + this.nome + " " + this.cognome);
    }

    

}
