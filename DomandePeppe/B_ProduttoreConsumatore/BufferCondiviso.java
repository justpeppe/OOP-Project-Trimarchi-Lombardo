package DomandePeppe.B_ProduttoreConsumatore;

public class BufferCondiviso {

    private int[] buffer;
    private final int size; // La dimensione del buffer è una costante (final)
    private int count = 0;
    private int in = 0; // Indice di inserimento
    private int out = 0; // Indice di estrazione

    public BufferCondiviso(int bufferSize) {
        this.size = bufferSize;
        buffer = new int[bufferSize]; // Creiamo l'array di interi
    }

    public synchronized void add(int value) throws InterruptedException {

        // Se il buffer è pieno, il Produttore deve attendere
        while (count == size) {
            wait();
        }

        // Inserimento del dato
        buffer[in] = value;
        in = (in + 1) % size;
        count++;

        System.out.println("PRODUTTORE: Inserito " + value + ". Elementi attuali: " + count);

        // notifyAll() risveglia tutti i thread in attesa (Consumatori) sul monitor,
        notifyAll();
    }

    public synchronized int get() throws InterruptedException {

        // Se il buffer è vuoto, il Consumatore deve attendere
        while (count == 0) {
            wait();
        }

        // Estrazione del dato
        int value = buffer[out];
        out = (out + 1) % size;
        count--;

        System.out.println("CONSUMATORE: Prelevato " + value + ". Elementi attuali: " + count);

        // Risveglia i thread in attesa (Produttori)
        notifyAll();
        return value;
    }
}
