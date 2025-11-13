package Shared;

public class StrumentoArco extends Strumento {
    public StrumentoArco (String nome, String marca, int ID, int prezzo){
        super(nome, marca, ID, prezzo, Sezioni.ARCO);
    }

    public StrumentoArco (String nome, String marca, int ID, int prezzo, int quantita){
        super(nome, marca, ID, prezzo, quantita, Sezioni.ARCO);
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
}
