package Shared;

public class StrumentoPercussione extends Strumento{
      public StrumentoPercussione (String nome, String marca, int ID, int prezzo){
        super(nome, marca, ID, prezzo, Sezioni.PERCUSSIONE);
    }

    public StrumentoPercussione (String nome, String marca, int ID, int prezzo, int quantita){
        super(nome, marca, ID, prezzo, quantita, Sezioni.PERCUSSIONE);
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
}

