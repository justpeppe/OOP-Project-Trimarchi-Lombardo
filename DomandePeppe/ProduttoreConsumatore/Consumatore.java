package DomandePeppe.ProduttoreConsumatore;

// Classe  Implementa Runnable per l'esecuzione concorrente.
public class Consumatore implements Runnable {

    private final BufferCondiviso buffer;
    private int ITERAZIONI = 10;

    public Consumatore(BufferCondiviso buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            // Preleviamo i primi 10 dati
            for (int i = 1; i <= ITERAZIONI; i++) {
                int datoPrelevato = buffer.get();
                System.out.println("Ho prelevato il seguente dato: " + datoPrelevato);
            }
        } catch (InterruptedException e) {
            // In caso di errore stampiamolo e fermiamo l'esecuzione
            System.err.println("Consumatore interrotto.");
            Thread.currentThread().interrupt();
        }
    }
}
