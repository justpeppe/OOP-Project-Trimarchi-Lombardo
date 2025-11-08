package ServerSide;

import Shared.Strumento;
import Shared.RichiestaAcquisto;
import Shared.RichiestaStorico;
import Shared.Utils;

import java.util.ArrayList;

public abstract class GestoreDB {

    private final String Ip, nomeDB, username, password; // final perchè una volta impostati rimarranno invariabili
    private final int porta;

    public GestoreDB() {
        this.Ip = Utils.getElementValue("server.xml", "Ip");
        this.nomeDB = Utils.getElementValue("server.xml", "nomeDB");
        this.username = Utils.getElementValue("server.xml", "username");
        this.password = Utils.getElementValue("server.xml", "password");
        this.porta = Integer.parseInt(Utils.getElementValue("server.xml", "porta")); // Converto da stringa a int
    }

    public String getIp() {
        return Ip;
    }

    public String getNomeDB() {
        return nomeDB;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getPorta() {
        return porta;
    }

    // METODI DA IMPLEMENTARE PER OGNI TIPO DI DB (es: MySQL, PostgreSQL, MongoDB,
    // etc...)

    // Apertura e chiusura connessione

    public abstract void Connect();

    public abstract void CloseConnectionDB();

    // Query

    public abstract ArrayList<Strumento> getListaStrumenti();

    // Preleva tutti gli strumenti con un certo nome
    public abstract ArrayList<Strumento> getNomeStrumento(String nomeStrumento);

    public abstract ArrayList<Strumento> getListaStrumentiSezioni(String sezione);

    public abstract ArrayList<Strumento> getListaStrumentiMarca(String marcaStrumento);

    public abstract boolean AcquistaStrumento(RichiestaAcquisto richiestaAcquisto);

    // Qui avremo un ArrayList di stringhe (gli acquisti) e non di classi strumenti
    public abstract ArrayList<String> getListaAcquisti(RichiestaStorico richiestaStorico);

}