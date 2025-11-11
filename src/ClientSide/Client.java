package ClientSide;

import Shared.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;


public class Client {
    public static void main(String[] args) {
        Socket socket;
        ObjectOutputStream objectOutputStream;
        ObjectInputStream objectInputStream;

        Scanner input = new Scanner(System.in);

        try{
            socket = new Socket(Utils.getElementValue("client.xml", "host"), Integer.parseInt(Utils.getElementValue("client.xml","port")));
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());


            int scelta = 0;

            do{
                System.out.println("\n");
                System.out.println("Benvenuto!\n");
                System.out.println("1. Visualizza Lista Strumenti Completa");
                System.out.println("2. Cerca uno Strumento");
                System.out.println("3. Cerca una Sezione");
                System.out.println("4. Cerca una Marca");
                System.out.println("5. Acquista strumento");
                System.out.println("6. Visualizzare Acquisti Precedenti");
                System.out.println("7. Uscire");
                System.out.print("Seleziona:");

                scelta = input.nextInt();
                switch(scelta){
                    case 1:
                        Client.RichiestaStrumento(objectOutputStream, objectInputStream);
                        break;
                    case 2:
                        Client.CercaStrumento(objectOutputStream, objectInputStream);
                        break;
                    case 3:
                        Client.CercaSezione(objectOutputStream, objectInputStream);
                        break;
                    case 4:
                        Client.CercaMarca(objectOutputStream, objectInputStream);
                        break;
                    case 5:
                        Client.AcquistaStrumento(objectOutputStream, objectInputStream);
                        break;
                    case 6:
                        Client.VisualizzaStorico(objectOutputStream, objectInputStream);
                        break;
                    case 7:
                        System.out.println("Uscita in corso. Attendere...");
                        break;
                    default:
                        System.out.println("Opzione non valida. Riprovare");
                        break;
                }
            }
            while(scelta !=7);

            objectOutputStream.flush();
            objectOutputStream.close();
            objectInputStream.close();
            socket.close();
            input.close();

        }
        catch (IOException e){
            e.printStackTrace();
            }
    }

    private static void RichiestaStrumento (ObjectOutputStream objectOutputStream, ObjectInputStream objectInputStream){
        RichiestaGenerica richiestaGenerica = new RichiestaGenerica(TipoRichiesta.LISTA_STRUMENTI);
        Object risposta;
        try{
            objectOutputStream.writeObject(richiestaGenerica);
            risposta = objectInputStream.readObject();

            if (risposta instanceof ArrayList<?>){
                ArrayList<Strumento> array = (ArrayList<Strumento>) risposta;
                if(array.isEmpty()) {
                    System.out.println("\nNessuno Strumento è stato trovato!");
                }
                else{
                    for (int i = 0; i < array.size(); i++) {
                        if(array.get(i).getQuantita() > 0) {
                            System.out.println("ID Strumento:"+array.get(i).getId()+"\n"+
                                    array.get(i).toString());
                            System.out.println("\n\n");
                        }
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }



    private static void CercaStrumento (ObjectOutputStream objectOutputStream, ObjectInputStream objectInputStream){
        RichiestaGenerica richiestaGenerica = new RichiestaGenerica(TipoRichiesta.CERCA_NOME_STRUMENTO);
        Object risposta;
        Scanner scanner;
        try{
            System.out.println("Inserisci il nome dell stumento che vuoi cercare:\n");
            scanner= new Scanner(System.in);
            String nomeStrumento = scanner.nextLine();
            objectOutputStream.writeObject(richiestaGenerica);
            objectOutputStream.writeObject(nomeStrumento);

            risposta = objectInputStream.readObject();
            if (risposta instanceof ArrayList<?>){
                ArrayList<Strumento> array = (ArrayList<Strumento>) risposta;
                if(array.isEmpty()) {
                    System.out.println("\nNessuno Strumento è stato trovato!");
                }
                else{
                    for (int i = 0; i < array.size(); i++) {
                        if(array.get(i).getQuantita() == 0) {
                            System.out.println("\n" + array.get(i).getNome()+ ": Strumento non disponibile\n\n");
                        }
                        else{
                            System.out.println("ID Strumento:"+array.get(i).getId()+"\n"+
                                    array.get(i).toString());
                            System.out.println("");
                        }
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }


 private static void CercaSezione (ObjectOutputStream objectOutputStream, ObjectInputStream objectInputStream){
        RichiestaGenerica richiestaGenerica = new RichiestaGenerica(TipoRichiesta.LISTA_STRUMENTI_SEZIONE);
        Object risposta;
        Scanner scanner;
        try{
            System.out.println("Inserisci la sezione dello strumento che vuoi cercare:\n");
            scanner= new Scanner(System.in);
            String sezione = scanner.nextLine();
            objectOutputStream.writeObject(richiestaGenerica);
            objectOutputStream.writeObject(sezione);

            risposta = objectInputStream.readObject();
            if (risposta instanceof ArrayList<?>){
                ArrayList<Strumento> array = (ArrayList<Strumento>) risposta;
                if(array.isEmpty()) {
                    System.out.println("\nNessuno Strumento appartenente a questa sezione:" + sezione +
                    "è stato trovato! Riprova");
                }
                else{
                    for (int i = 0; i < array.size(); i++) {
                        if(array.get(i).getQuantita() == 0) {
                            System.out.println("\n" + array.get(i).getNome()+ ": Strumento non disponibile\n\n");
                        }
                        else{
                            System.out.println("ID Strumento:"+array.get(i).getId()+"\n"+
                                    array.get(i).toString());
                            System.out.println("");
                        }
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }


 private static void CercaMarca (ObjectOutputStream objectOutputStream, ObjectInputStream objectInputStream){
        RichiestaGenerica richiestaGenerica = new RichiestaGenerica(TipoRichiesta.LISTA_STRUMENTI_MARCA);
        Object risposta;
        Scanner scanner;
        try{
            System.out.println("Inserisci la marca dello strumento che vuoi cercare:\n");
            scanner= new Scanner(System.in);
            String marca = scanner.nextLine();
            objectOutputStream.writeObject(richiestaGenerica);
            objectOutputStream.writeObject(marca);

            risposta = objectInputStream.readObject();
            if (risposta instanceof ArrayList<?>){
                ArrayList<Strumento> array = (ArrayList<Strumento>) risposta;
                if(array.isEmpty()) {
                    System.out.println("\nNessuno Strumento di questa marca:" + marca +
                    "è stato trovato! Riprova");
                }
                else{
                    for (int i = 0; i < array.size(); i++) {
                        if(array.get(i).getQuantita() == 0) {
                            System.out.println("\n" + array.get(i).getNome()+ ": Strumento non disponibile\n\n");
                        }
                        else{
                            System.out.println("ID Strumento:"+array.get(i).getId()+"\n"+
                                    array.get(i).toString());
                            System.out.println("");
                        }
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }


 private static void AcquistaStrumento( ObjectOutputStream objectOutputStream, ObjectInputStream objectInputStream){
    RichiestaAcquisto richiestaAcquisto;
    boolean esito;
    Scanner scanner;

    try{
        scanner = new Scanner(System.in);
        System.out.println("Inserisci l'id dello strumento che vuoi acquistare: ");
        int idStrumento = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Inserisci il nome dello strumento che vuoi acquistare: ");
        String nomeStrumento =scanner.nextLine();

        System.out.println("Inserisci il tuo nome: ");
        String nome = scanner.nextLine();

        System.out.println("Inserisci il cognome: ");
        String cognome = scanner.nextLine();

        System.out.println("Inserisci l'email: ");
        String email = scanner.nextLine();

        richiestaAcquisto = new RichiestaAcquisto(nome, cognome, email, idStrumento, nomeStrumento);
        
        objectOutputStream.writeObject(richiestaAcquisto);
        objectOutputStream.flush();
        esito = objectInputStream.readBoolean();

        if (esito == true){
                System.out.println("\nAcquisto riuscito! Grazie e arrivederci.\n");
            }
            else{
                System.out.println("\nQualcosa è andato storto durante l'acquisto, ritenta!\n");
            }
    }
    catch (IOException e){
        e.printStackTrace();
    }
 }

 private static void VisualizzaStorico (ObjectOutputStream objectOutputStream, ObjectInputStream objectInputStream){
    RichiestaStorico richiestaStorico;
    Object risposta;
    Scanner scanner;

    try{
        scanner = new Scanner(System.in);

        System.out.println("Inserisci il tuo nome: ");
        String nome = scanner.nextLine();

        System.out.println("Inserisci il tuo cognome: ");
        String cognome = scanner.nextLine();

        System.out.println("Inserisci la tua email: ");
        String email = scanner.nextLine();

        richiestaStorico = new RichiestaStorico(nome, cognome, email);

        objectOutputStream.writeObject(richiestaStorico);
        objectOutputStream.flush();

        risposta = objectInputStream.readObject();
        if (risposta instanceof ArrayList<?>) {
            ArrayList<Strumento> array = (ArrayList<Strumento>) risposta;
            if (array.isEmpty()){
                System.out.println("\nNessun acquisto è stato ancora effettuato");
            }
            else {
                for (int i =0; i < array.size(); i++) {
                    System.out.println("Strumento:" + array.get(i));
                }
            }
        }
        else{
            System.out.println("\nQualcosa è andato storto, ritetnta!\n\n");
        }
    }
    catch (IOException | ClassNotFoundException e){
        e.printStackTrace();
    }
 }
    
}
