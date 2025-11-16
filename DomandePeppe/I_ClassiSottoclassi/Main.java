package DomandePeppe.I_ClassiSottoclassi;

public class Main {

    public static void main(String[] args) {

        ClassePadre Padre = new ClassePadre("Felice");
        ClasseFiglio Figlio = new ClasseFiglio("Giuseppe", "Trimarchi");

        System.out.println("Info padre: " + Padre.getInfo());
        System.out.println("Info figlio: " + Figlio.getInfo());

    }

}
