package DomandePeppe.O_Static;

// Static può essere utilizzato nei metodi e nelle variabili

public class EsempiStatic {

    private static int eta = 10;

    public static int getEta() {
        return eta;
    }

    // La differenza sostanziale sta se affianchiamo o meno final a static
    // Final non permette di modificare le variabili/metodi dopo che sono stati
    // dichiarati

}
