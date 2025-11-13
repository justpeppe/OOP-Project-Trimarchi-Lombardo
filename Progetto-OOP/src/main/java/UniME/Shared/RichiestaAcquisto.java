package UniME.Shared;

public class RichiestaAcquisto extends Richiesta {
    private String nome, cognome, email; // nomeStrumento;
    private int IDStrumento;

    public RichiestaAcquisto(String nome, String cognome, String email, int IDStrumento) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.IDStrumento = IDStrumento;
        // this.nomeStrumento = nomeStrumento;
    }

    public RichiestaAcquisto(String nome, String cognome, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public int getIDStrumento() {
        return IDStrumento;
    }

    /*
     * public String getNomeStrumento() {
     * return nomeStrumento;
     * }
     */
}
