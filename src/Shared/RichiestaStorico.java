package Shared;

public class RichiestaStorico extends Richiesta {
    private String nome, cognome, email;

    public RichiestaStorico (String nome, String cognome, String email){
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
    }

    public String getNome(){
        return nome;
    }

    public String getCognome(){
        return cognome;
    }

    public String getEmail(){
        return email;
    }

}
