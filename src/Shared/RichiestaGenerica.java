package Shared;

public class RichiestaGenerica extends Richiesta{
    private TipoRichiesta tipoRichiesta;

    public RichiestaGenerica(TipoRichiesta tipoRichiesta){
        this.tipoRichiesta= tipoRichiesta;
    }

    public TipoRichiesta getTipoRichiesta(){
        return tipoRichiesta;
    }
}
