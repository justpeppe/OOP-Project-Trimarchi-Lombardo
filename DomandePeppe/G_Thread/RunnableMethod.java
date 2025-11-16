package DomandePeppe.G_Thread;

public class RunnableMethod implements Runnable {

    private int count;

    // Va sovrascritto il metodo Run
    @Override
    public void run() {

        System.out.println("Sono un thread in esecuzione con il metodo runnable");

        try {
            while (count == 0) {
                wait();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Errore: " + e.getMessage());
        }
    }
}
