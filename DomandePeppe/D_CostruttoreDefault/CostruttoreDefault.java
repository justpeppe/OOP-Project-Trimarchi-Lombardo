package DomandePeppe.D_CostruttoreDefault;

public class CostruttoreDefault {

    private String testo;

    public CostruttoreDefault() {
        this.testo = "Questo è il costruttore default senza parametri";
    }

    // E' possibile creare diversi costruttori default
    // Devono differire nella signature

    public CostruttoreDefault(String testo) {
        this.testo = "Questo e\' un costruttore default con il seguente testo " + testo;
    }

    public CostruttoreDefault(int numero) {
        this.testo = "Questo e\' un costruttore default con il seguente numero " + numero;
    }

    public CostruttoreDefault(String testo, int numero) {
        this.testo = "Questo e\' un costruttore default con il seguente testo " + testo + " e numero " + numero;
    }

    public String getTesto() {
        return testo;
    }

}
