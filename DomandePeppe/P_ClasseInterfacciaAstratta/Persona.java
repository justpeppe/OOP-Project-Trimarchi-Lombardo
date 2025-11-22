package DomandePeppe.P_ClasseInterfacciaAstratta;

public abstract class Persona {

    private String cognome;

    public Persona(String cognome) {
        this.cognome = cognome;
    }

    // Metodo concreto
    public String getCognome() {
        return cognome;
    }

    // Metodo astratto
    public abstract void Saluta();

}
