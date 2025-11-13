package Shared;

public class StrumentoOttone extends Strumento{
      public StrumentoOttone (String nome, String marca, int ID, int prezzo){
        super(nome, marca, ID, prezzo, Sezioni.OTTONE);
    }

    public StrumentoOttone (String nome, String marca, int ID, int prezzo, int quantita){
        super(nome, marca, ID, prezzo, quantita, Sezioni.OTTONE);
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
}

