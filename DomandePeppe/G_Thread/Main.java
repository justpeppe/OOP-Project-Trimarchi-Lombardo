package DomandePeppe.G_Thread;

public class Main {

    public static void main(String[] args) {
        // Metodo 01
        ThreadMethod t1 = new ThreadMethod();
        t1.start();

        // Metodo 02 (va creato il thread)
        RunnableMethod r = new RunnableMethod();
        Thread t2 = new Thread(r);
        t2.start();

    }

}
