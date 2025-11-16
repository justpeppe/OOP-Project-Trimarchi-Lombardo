package DomandePeppe.K_SuperThis;

public class ClassePadre {

    String cognome;

    public ClassePadre(String cognome) {
        // Ad una variabile di istanza associamo una variabile locale
        this.cognome = cognome;
    }

    public String getInfo() {
        return cognome;
    }

}
