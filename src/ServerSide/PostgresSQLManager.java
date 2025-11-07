package ServerSide;

import java.sql.*;
import java.util.ArrayList;

import Shared.*;

public class PostgresSQLManager extends GestoreDB {

    private String nomeClasse, driver;
    private Statement stmt;
    private Connection conn;

    public PostgresSQLManager() {
        super();
        this.nomeClasse = Utils.getElementValue("server.xml", "nomeclasse");
        this.driver = Utils.getElementValue("server.xml", "driver");
    }

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
    public ArrayList<Strumento> getListaStrumentiSezioni(String sezione) {
        ArrayList<Strumento> listaStrumentiSezioni = new ArrayList<>();
        String sqlQuery = "SELECT * FROM Strumenti" +
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
        String sqlQuery = "SELECT * FROM Strumenti" +
                "WHERE Marca LIKE '%" + marcaStrumento + "'";

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

    public ArrayList<Strumento> getListaAcquisti(RichiestaStorico richiestaStorico) {
        ArrayList<Strumento> listaAcquisti = new ArrayList<>();
        String sqlQuery = "SELECT NomeStrumento" +
                "FROM Vendite " +
                "WHERE Nome = '" + richiestaStorico.getNome() + "'" +
                "AND Cognome = '" + richiestaStorico.getCognome() + "'" +
                "AND Email = '" + richiestaStorico.getEmail() + "';";

        ResultSet resultSet;

        try {
            resultSet = stmt.executeQuery(sqlQuery);
            if (resultSet.isBeforeFirst()) {
                while (resultSet.next()) {
                    String nomeStrumento = resultSet.getString("NomeLibro");
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
