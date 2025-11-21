package DomandePeppe.O_Static;

// - final su classi/metodi/variabili per impedire estensioni/modifiche
// - static per membri condivisi a livello di classe (accessibili senza istanza)

// Classe final -> non può essere estesa (nessuna sottoclasse possibile)
public final class FinalStatic {

    // Variabile: static = condivisa fra tutte le istanze; final = immutabile.
    public static final double PI = 3.14;

    // Metodo statico: può essere chiamato senza creare un'istanza
    // (FinalStatic.getCostante(...)).
    // Metodo final: non può essere sovrascritto in una sottoclasse

    public static final double getCostante() {
        return PI;
    }
}
