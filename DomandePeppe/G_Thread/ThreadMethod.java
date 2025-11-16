package DomandePeppe.G_Thread;

// Metodo 01 -> estensione classe thread

public class ThreadMethod extends Thread {

    private int count;

    // Va sovrascritto Run
    @Override
    public void run() {

        System.out.println("Sono un thread in esecuzione con il metodo thread");
        try {
            while (count == 0) {
                // Possiamo mettere il thread in pausa finchè una condizione è vera
                wait();
            }
        } catch (InterruptedException e) {
            // Va fermato il thread e stampato errore
            Thread.currentThread().interrupt();
            System.err.println("ERRORE: " + e.getMessage());
        }

        // Una volta finito liberiamo il lock del monitor e lo comunichiamo a tutti
        count++;
        notifyAll();

    }

}
