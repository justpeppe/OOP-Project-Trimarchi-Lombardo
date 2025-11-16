package DomandePeppe.D_CostruttoreDefault;

public class Main {

    public static void main(String[] args) {
        // Creiamo l'oggetto con uno dei costruttori
        CostruttoreDefault c1 = new CostruttoreDefault();
        System.out.println(c1.getTesto());

        CostruttoreDefault c2 = new CostruttoreDefault("prova");
        System.out.println(c2.getTesto());

        CostruttoreDefault c3 = new CostruttoreDefault(13);
        System.out.println(c3.getTesto());

        CostruttoreDefault c4 = new CostruttoreDefault("prova", 13);
        System.out.println(c4.getTesto());

    }

}
