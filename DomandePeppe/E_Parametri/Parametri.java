package DomandePeppe.E_Parametri;

public class Parametri {

    // Parametri formali
    // Sono i parametri che il metodo si aspetta di ricevere
    public int MetodoParametriFormali(int a, int b) {
        return a + b;
    }

    // Parametri attuali
    // Sono i parametri che passo al metodo quando lo invoco
    int x = 3;
    int y = 10;
    int somma = MetodoParametriFormali(x, y);

    // Parametri primitivi VS Parametri oggetto
    // In java i parametri primitivi come int, double, float se vengono passati ad
    // un metodo esso riceverà una copia
    int z = 3;

    public void FunzionePrimitiva(int a) {
        a = a + 10;

    }

    public void stampa() {
        FunzionePrimitiva(z);
        System.out.println(z); // vedremo che z non è cambiato
    }

    // I parametri oggetto come stringhe e array se vengono passati ai metodi
    // essi riceveranno un riferimento (indirizzo di memoria) del parametro perciò
    // le modifiche fatte al parametro si rifletteranno anche fuori dal metodo

    String testo = "prova";

    public void CambiaTesto(String testo) {
        testo = "Nuovo testo";
    }

    public void stampa2() {
        CambiaTesto(testo);
        System.out.println(testo); // vedremo testo è cambiato
    }
}
