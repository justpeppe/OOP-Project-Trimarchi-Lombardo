package UniME.ServerSide;

import java.sql.*;
import java.util.ArrayList;

import UniME.Shared.*;

public class PostgreSQLManager extends GestoreDB {

    private String nomeClasse, driver;
    private Statement stmt;
    private Connection conn;

    public PostgreSQLManager() {
        super();
        this.nomeClasse = Utils.getElementValue("server.xml", "nomeclasse");
        this.driver = Utils.getElementValue("server.xml", "driver");
    }

    // Apertura e chiusura connessione

    @Override
    public void Connect() {
        try {
            Class.forName(nomeClasse);
            conn = DriverManager.getConnection(
                    this.driver + "://" + this.getIp() + ":" + this.getPorta() + "/" + this.getNomeDB(),
                    this.getUsername(), this.getPassword());
            stmt = conn.createStatement();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
    }

    @Override
    public void CloseConnectionDB() {
        try {
            stmt.close();
            conn.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    // QUERY

    @Override
    public ArrayList<Strumento> getListaStrumenti() {
        ArrayList<Strumento> listaStrumenti = new ArrayList<>();
        String sqlQuery = "SELECT * FROM Strumenti";

        ResultSet resultSet;

        try {
            resultSet = stmt.executeQuery(sqlQuery);
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String nome = resultSet.getString("Nome");
                String marca = resultSet.getString("Marca");
                int prezzo = resultSet.getInt("Prezzo");
                int quantita = resultSet.getInt("Quantita"); // senza accento
                String sezioneStrumento = resultSet.getString("Sezione");

                Sezioni sezioneQuery = Sezioni.valueOf(sezioneStrumento.toUpperCase());

                Strumento strumento;

                switch (sezioneQuery) {
                    case LEGNO:
                        strumento = new StrumentoLegno(nome, marca, id, prezzo, quantita);
                        listaStrumenti.add(strumento);
                        break;
                    case ARCO:
                        strumento = new StrumentoArco(nome, marca, id, prezzo, quantita);
                        listaStrumenti.add(strumento);
                        break;
                    case PERCUSSIONE:
                        strumento = new StrumentoPercussione(nome, marca, id, prezzo, quantita);
                        listaStrumenti.add(strumento);
                        break;
                    case OTTONE:
                        strumento = new StrumentoOttone(nome, marca, id, prezzo, quantita);
                        listaStrumenti.add(strumento);
                        break;
                    default:
                        System.out.println("Errore, sezione non riconosciuta!");
                        break;
                }
            }
        } catch (SQLException sqlException) {
            System.out.println("Non è stato possibile fare la query, errore: \n");
            sqlException.printStackTrace();
        }
        return listaStrumenti;
    }

    @Override
    public ArrayList<Strumento> getNomeStrumento(String nomeStrumento) {
        ArrayList<Strumento> listaStrumentiNome = new ArrayList<>();

        String sqlQuery = "SELECT * FROM Strumenti " +
                "WHERE NOME LIKE %'" + nomeStrumento + "%'";

        ResultSet resultSet;

        try {
            resultSet = stmt.executeQuery(sqlQuery);
            if (resultSet.isBeforeFirst()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("ID");
                    String nome = resultSet.getString("Nome");
                    String marca = resultSet.getString("Marca");
                    int prezzo = resultSet.getInt("Prezzo");
                    int quantita = resultSet.getInt("Quantita");
                    String sezioneStrumento = resultSet.getString("Sezione");

                    Sezioni sezioneQuery = Sezioni.valueOf(sezioneStrumento.toUpperCase());

                    Strumento strumento;

                    switch (sezioneQuery) {
                        case LEGNO:
                            strumento = new StrumentoLegno(nome, marca, id, prezzo, quantita);
                            listaStrumentiNome.add(strumento);
                            break;
                        case ARCO:
                            strumento = new StrumentoArco(nome, marca, id, prezzo, quantita);
                            listaStrumentiNome.add(strumento);
                            break;
                        case PERCUSSIONE:
                            strumento = new StrumentoPercussione(nome, marca, id, prezzo, quantita);
                            listaStrumentiNome.add(strumento);
                            break;
                        case OTTONE:
                            strumento = new StrumentoOttone(nome, marca, id, prezzo, quantita);
                            listaStrumentiNome.add(strumento);
                            break;
                        default:
                            System.out.println("Errore, sezione non riconosciuta!");
                            break;
                    }
                }
            } else {
                System.out.println("Non e\' stato trovato nessuno strumento con il nome: " + nomeStrumento);
            }
        } catch (SQLException sqlException) {
            System.out.println("Non è stato possibile fare la query, errore: \n");
            sqlException.printStackTrace();
        }
        return listaStrumentiNome;
    }

    @Override
    public ArrayList<Strumento> getListaStrumentiSezioni(String sezione) {
        ArrayList<Strumento> listaStrumentiSezioni = new ArrayList<>();
        String sqlQuery = "SELECT * FROM Strumenti " +
                "WHERE Sezione = '" + sezione + "'";

        ResultSet resultSet;

        try {
            resultSet = stmt.executeQuery(sqlQuery);
            if (resultSet.isBeforeFirst()) { // Serve per assicurarci che siamo all'inizio
                while (resultSet.next()) {
                    int id = resultSet.getInt("ID");
                    String nome = resultSet.getString("Nome");
                    String marca = resultSet.getString("Marca");
                    int prezzo = resultSet.getInt("Prezzo");
                    int quantita = resultSet.getInt("Quantita"); // senza accento
                    String sezioneStrumento = resultSet.getString("Sezione");

                    Sezioni sezioneQuery = Sezioni.valueOf(sezioneStrumento.toUpperCase());

                    Strumento strumento;

                    switch (sezioneQuery) {
                        case LEGNO:
                            strumento = new StrumentoLegno(nome, marca, id, prezzo, quantita);
                            listaStrumentiSezioni.add(strumento);
                            break;
                        case ARCO:
                            strumento = new StrumentoArco(nome, marca, id, prezzo, quantita);
                            listaStrumentiSezioni.add(strumento);
                            break;
                        case PERCUSSIONE:
                            strumento = new StrumentoPercussione(nome, marca, id, prezzo, quantita);
                            listaStrumentiSezioni.add(strumento);
                            break;
                        case OTTONE:
                            strumento = new StrumentoOttone(nome, marca, id, prezzo, quantita);
                            listaStrumentiSezioni.add(strumento);
                            break;
                        default:
                            System.out.println("Errore, sezione non riconosciuta!");
                            break;
                    }
                }
            } else {
                System.out.println("Nessuno strumento trovato per la sezione: " + sezione);
            }
        } catch (

        SQLException sqlException) {
            System.out.println("Non è stato possibile fare la query, errore: \n");
            sqlException.printStackTrace();
        }
        return listaStrumentiSezioni;
    }

    public ArrayList<Strumento> getListaStrumentiMarca(String marcaStrumento) {
        ArrayList<Strumento> listaStrumentiMarca = new ArrayList<>();
        String sqlQuery = "SELECT * FROM Strumenti " +
                "WHERE Marca LIKE '%" + marcaStrumento + "%'";

        ResultSet resultSet;

        try {
            resultSet = stmt.executeQuery(sqlQuery);
            if (resultSet.isBeforeFirst()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("ID");
                    String nome = resultSet.getString("Nome");
                    String marca = resultSet.getString("Marca");
                    int prezzo = resultSet.getInt("Prezzo");
                    int quantita = resultSet.getInt("Quantita"); // senza accento
                    String sezioneStrumento = resultSet.getString("marca");

                    Sezioni sezioneQuery = Sezioni.valueOf(sezioneStrumento.toUpperCase());

                    Strumento strumento;

                    switch (sezioneQuery) {
                        case LEGNO:
                            strumento = new StrumentoLegno(nome, marca, id, prezzo, quantita);
                            listaStrumentiMarca.add(strumento);
                            break;
                        case ARCO:
                            strumento = new StrumentoArco(nome, marca, id, prezzo, quantita);
                            listaStrumentiMarca.add(strumento);
                            break;
                        case PERCUSSIONE:
                            strumento = new StrumentoPercussione(nome, marca, id, prezzo, quantita);
                            listaStrumentiMarca.add(strumento);
                            break;
                        case OTTONE:
                            strumento = new StrumentoOttone(nome, marca, id, prezzo, quantita);
                            listaStrumentiMarca.add(strumento);
                            break;
                        default:
                            System.out.println("Errore, marca non riconosciuta!");
                            break;

                    }

                }
            } else {
                System.out.println("Nessuno strumento trovato per la marca: " + marcaStrumento);
            }
        } catch (

        SQLException sqlException) {
            System.out.println("Non è stato possibile fare la query, errore: \n");
            sqlException.printStackTrace();
        }
        return listaStrumentiMarca;
    }

    public boolean AcquistaStrumento(RichiestaAcquisto richiestaAcquisto) {
        String nome = richiestaAcquisto.getNome();
        String cognome = richiestaAcquisto.getCognome();
        String email = richiestaAcquisto.getEmail();
        int IDstrumento = richiestaAcquisto.getIDStrumento();
        String nomeStrumento = richiestaAcquisto.getNomeStrumento();

        // Acquista deve diminuire il numero di copie disponibili nel db
        String sqlQueryAcquista = "UPDATE Strumenti " +
                "SET NumeroCopie = NumeroCopie - 1" +
                "WHERE ID = " + IDstrumento + " " +
                "AND Numerocopie > 0";

        // Aggiorniamo la tabella delle vendite
        String sqlQueryVendita = "INSERT INTO Vendite (Nome,Cognome,Email,IDStrumento,NomeStrumento) " +
                "VALUES ('" + nome + "', '" + cognome + "', '" + email + "', '" + IDstrumento + "', '" + nomeStrumento
                + "');";

        int risultatoQueryAcquista = 0;
        int risultatoQueryVendita = 0;

        try {
            risultatoQueryAcquista = stmt.executeUpdate(sqlQueryAcquista);
            risultatoQueryVendita = stmt.executeUpdate(sqlQueryVendita);
        } catch (SQLException sqlException) {
            System.out.println("Errore nella query: ");
            sqlException.printStackTrace();
            return false;
        } finally {
            if ((risultatoQueryAcquista) > 0 && (risultatoQueryVendita) > 0) {
                System.out.println("Acquisto andato a buon fine!");
                return true;
            } else if ((risultatoQueryAcquista) == 0) {
                System.out.println("Lo strumento richiesto non e\' disponibile");
                return false;
            } else if ((risultatoQueryVendita) == 0) {
                System.out.println("Errore nell'aggiornare la tabella Vendite");
                return false;
            }
        }

        // Se try-catch-finally fallisce per altri motivi la funzione deve restituire
        // false
        return false;
    }

    public ArrayList<String> getListaAcquisti(RichiestaStorico richiestaStorico) {
        ArrayList<String> listaAcquisti = new ArrayList<>();
        String sqlQuery = "SELECT NomeStrumento " +
                "FROM Vendite " +
                "WHERE Nome = '" + richiestaStorico.getNome() + "'" +
                "AND Cognome = '" + richiestaStorico.getCognome() + "'" +
                "AND Email = '" + richiestaStorico.getEmail() + "';";

        ResultSet resultSet;

        try {
            resultSet = stmt.executeQuery(sqlQuery);
            if (resultSet.isBeforeFirst()) {
                while (resultSet.next()) {
                    String nomeStrumento = resultSet.getString("NomeStrumento");
                    listaAcquisti.add(nomeStrumento);
                }
            } else {
                System.out.println("Nessuno acquisto trovato per utente " + richiestaStorico.getEmail());
            }
        } catch (SQLException sqlException) {
            System.out.println("Non è stato possibile fare la query, errore: \n");
            sqlException.printStackTrace();
        }
        return listaAcquisti;
    }

}
