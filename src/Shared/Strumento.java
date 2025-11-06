package Shared;

import java.io.Serializable;
public abstract class Strumento implements Serializable {
    private String nome, marca;
    private int ID, prezzo, quantita;
    private Sezioni sezione;
    
    public Strumento (String nome, String marca, int ID, int prezzo, Sezioni sezione){
        this.nome = nome;
        this.marca = marca;
        this.ID = ID;
        this.prezzo = prezzo;
        this.sezione = sezione;
    
    }

     public Strumento (String nome, String marca, int ID, int prezzo, int quantita, Sezioni sezione){
        this.nome = nome;
        this.marca = marca;
        this.ID = ID;
        this.prezzo = prezzo;
        this.sezione = sezione;
        this.quantita = quantita;
     }

     public Strumento (String nome, int ID){
        this.nome = nome;
        this.ID = ID;
     }

     public String getNome(){
        return nome;
     }

     public String getMarca(){
        return marca;
     }
 
    public int getId() {
        return ID;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public int getQuantita(){
    return quantita;        
    }

    public Sezioni getSezione(){
        return sezione;
    }

    @Override
    public String toString(){
        String descrizione = "Nome Strumento: " + nome + "\nMarca: "+ marca + "\nSezione: "+ sezione + "\nPrezzo: Eur "+ prezzo + "\nQuantità:" + quantita;
        return descrizione;
        }
}
