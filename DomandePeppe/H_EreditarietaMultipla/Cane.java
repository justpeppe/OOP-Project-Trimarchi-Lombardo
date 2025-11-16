package DomandePeppe.H_EreditarietaMultipla;

public class Cane extends Animale implements Suoni, Azioni {

    private String nome;

    public Cane(String nome) {
        super(nome);
    }

    @Override
    public void Abbaia() {
        System.out.println("Bau bau");
    }

    @Override
    public void Corre() {
        System.out.println(this.nome + " sta correndo");
    }

}
