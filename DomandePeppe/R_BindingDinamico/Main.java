package DomandePeppe.R_BindingDinamico;

public class Main {

    public static void main(String[] args) {
        Persona[] arrayPersone = new Persona[2];
        arrayPersone[0] = new Persona("Trimarchi", "Giuseppe");
        arrayPersone[1] = new Studente("Trimarchi", "Giuseppe", 529962);

        for (int i = 0; i < arrayPersone.length; i++) {
            arrayPersone[i].Presentati();
        }
    }

}
