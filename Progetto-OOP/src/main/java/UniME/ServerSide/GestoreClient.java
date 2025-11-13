package ServerSide;

import Shared.*;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class GestoreClient  extends Thread {  
    private Socket client;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private GestoreDB gestoreDB;

    public GestoreClient(Socket client) {
        this.client = client;
        try {
            objectInputStream = new ObjectInputStream(client.getInputStream());
            objectOutputStream = new ObjectOutputStream(client.getOutputStream());
        } catch(IOException e) {
            System.out.println("Attenzione! Si è verificato un errore. \nDettagòli: \n");
            e.printStackTrace();
            this.proceduraUscita();
        }
        gestoreDB = new PostgreSQLManager();
        gestoreDB.Connect();
    }
    @Override
    public void run() {
        //Gestisco le varie richieste (multithread)
        Object oggetto;
        boolean esci = false;

        while(!esci){
            try {
                oggetto = objectInputStream.readObject();
                if(oggetto instanceof RichiestaGenerica richiestaGenerica) { //Dichiaro e istanzio RichiestaGenerica
                    this.gestisciRichiesta(richiestaGenerica);
                }
                else if(oggetto instanceof RichiestaAcquisto richiestaAcquisto){ //Dichiaro e istanzio RichiestaAcquisto
                    this.gestisciAcquisto(richiestaAcquisto);
            
                }
                else if(oggetto instanceof RichiestaStorico richiestaStorico){ //Dichiaro e istanzio RichiestaStorico
                    this.gestisciStorico(richiestaStorico);
                }
            }
            catch (EOFException e) {
                System.out.println("Client disconnesso correttamente.");
                esci = this.proceduraUscita();
            }
            catch (IOException ioException){
                System.out.println("Attenzione! Operazione di I/O non effettuata correttamente.\nDettagli:\n");
                ioException.printStackTrace();
                esci= this.proceduraUscita();
            }
            catch (ClassNotFoundException classNotFoundException){
                System.out.println("Attenzione! La classe non è stata trovata.\n");
                classNotFoundException.printStackTrace();
                esci= this.proceduraUscita();
            }
        }
    }

    public void gestisciRichiesta(RichiestaGenerica richiestaGenerica) throws IOException{
        TipoRichiesta tipoRichiesta = richiestaGenerica.getTipoRichiesta();
        // Vado a gestire i tipi di richiesta implementati nel file tipoRichiesta

            /* Lista STRUMENTI */
        if(tipoRichiesta == TipoRichiesta.LISTA_STRUMENTI){
            ArrayList<Strumento> listaStrumenti;
            listaStrumenti = gestoreDB.getListaStrumenti();
            objectOutputStream.writeObject(listaStrumenti);
            }

            /* Ricerca per Sezione */
        if(tipoRichiesta == TipoRichiesta.LISTA_STRUMENTI_SEZIONE){
            ArrayList<Strumento> strumento;
            String sezione;
            try{
                sezione = (String) objectInputStream.readObject();
                strumento = gestoreDB.getListaStrumentiSezioni(sezione);
                objectOutputStream.writeObject(strumento);
            }
            catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        }

             /* Ricerca per Marca */
        if(tipoRichiesta == TipoRichiesta.LISTA_STRUMENTI_MARCA){
            ArrayList<Strumento> strumento;
            String marca;
            try{
                marca = (String) objectInputStream.readObject();
                strumento = gestoreDB.getListaStrumentiMarca(marca);
                objectOutputStream.writeObject(strumento);
            }
            catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        }
             /* Cerca Strumento per nome */
        if(tipoRichiesta == TipoRichiesta.CERCA_NOME_STRUMENTO){
            ArrayList<Strumento> strumento;
            String nomeStrumento;
            try{
                nomeStrumento = (String) objectInputStream.readObject();
                strumento = gestoreDB.getNomeStrumento(nomeStrumento);
                objectOutputStream.writeObject(strumento);
            }
            catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        
    }
    public void gestisciAcquisto(RichiestaAcquisto richiestaAcquisto){
        try{
            objectOutputStream.writeBoolean(gestoreDB.AcquistaStrumento(richiestaAcquisto));
            objectOutputStream.flush();
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
    }
    public void gestisciStorico(RichiestaStorico richiestaStorico){
        ArrayList<String> listaAcquisti;
        try{
            listaAcquisti = gestoreDB.getListaAcquisti(richiestaStorico);
            objectOutputStream.writeObject(listaAcquisti);
        }
        catch (IOException ioException){
            ioException.printStackTrace();
        }
    }


    public boolean proceduraUscita(){
        try{
            this.gestoreDB.CloseConnectionDB();
            this.objectInputStream.close();
            this.objectOutputStream.flush();
            this.objectOutputStream.close();
            this.client.close();
        }
        catch(IOException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
        finally{
            return true;
        }
    }
}

