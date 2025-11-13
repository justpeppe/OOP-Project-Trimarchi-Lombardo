package UniME.Shared;

public class StrumentoLegno extends Strumento{
      public StrumentoLegno (String nome, String marca, int ID, int prezzo){
        super(nome, marca, ID, prezzo, Sezioni.LEGNO);
    }

    public StrumentoLegno (String nome, String marca, int ID, int prezzo, int quantita){
        super(nome, marca, ID, prezzo, quantita, Sezioni.LEGNO);
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
}
