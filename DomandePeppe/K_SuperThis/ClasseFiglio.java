package DomandePeppe.K_SuperThis;

public class ClasseFiglio extends ClassePadre {

    String cognome, nome;

    public ClasseFiglio(String cognome, String nome) {
        // Con super accedo al costruttore del padre per creare figlio allo stesso modo
        super(cognome);
        this.nome = nome;
    }

    @Override
    public String getInfo() {
        String info = super.getInfo();
        return "Mi chiamo " + nome + " " + info;
    }

}
