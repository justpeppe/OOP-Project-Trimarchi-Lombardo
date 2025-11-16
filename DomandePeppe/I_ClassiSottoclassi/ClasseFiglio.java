package DomandePeppe.I_ClassiSottoclassi;

public class ClasseFiglio extends ClassePadre {

    private String cognome;

    public ClasseFiglio(String nome, String cognome) {
        super(nome); // premere ctrl + spazio per vedere i costruttori della classe padre
        this.cognome = cognome;
    }

    // Sovrascriamo il metodo per dare le info complete
    @Override
    public String getInfo() {
        return "Mi chiamo " + getNome() + " " + cognome;
    }

}
