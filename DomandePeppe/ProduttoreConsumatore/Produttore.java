package DomandePeppe.ProduttoreConsumatore;

//Classe implementa Runnable per essere eseguita in un Thread separato

public class Produttore implements Runnable {

    private final BufferCondiviso buffer;
    private int ITERAZIONI = 10;

    public Produttore(BufferCondiviso buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            // Inseriamo 10 elementi
            for (int i = 1; i <= ITERAZIONI; i++) {
                buffer.add(i);
                System.out.println("Ho inserito il seguente dato: " + i);
            }
        } catch (InterruptedException e) {
            // In caso di errore lo stampiamo e fermiamo il thread
            System.err.println("Produttore interrotto.");
            Thread.currentThread().interrupt();
        }
    }
}
