package DomandePeppe.L_Final;

// Classe finale: non può essere estesa da altre classi.
public final class EsempiFinal {

    // Costante di istanza non modificabile.
    // 'final' impedisce di modificare PI dopo l'inizializzazione.
    // Nota: non è 'static', quindi ogni istanza ha il suo campo PI (ma il valore è
    // immutabile).
    public final double PI = 3.14;

    // Metodo finale: non può essere sovrascritto dalle sottoclassi.
    public final double getCostanti() {
        return PI;
    }

}
