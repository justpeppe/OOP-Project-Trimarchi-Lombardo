package DomandePeppe.I_ClassiSottoclassi;

public class ClassePadre {

    private String nome, cognome;
    private int eta;

    public ClassePadre(String nome) {
        this.nome = nome;
    }

    protected ClassePadre(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    private ClassePadre(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    protected String getNome() {
        return nome;
    }

    protected String getCognome() {
        return cognome;
    }

    public String getInfo() {
        return "Mi chiamo " + nome;
    }
}
