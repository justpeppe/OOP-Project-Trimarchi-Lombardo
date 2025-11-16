package DomandePeppe.J_DomSax;

// Importiamo le librerie necessarie

import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.File;

public class DOM {

    public static void main(String[] args) {

        try {
            // Creiamo il document builder
            DocumentBuilderFactory db_Factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = db_Factory.newDocumentBuilder();

            // Passiamo il file xml ad un parser
            File xmlFile = new File("File.xml");

            // Salviamo la struttura in un documento
            Document xmlDocument = db.parse(xmlFile);

            // Otteniamo la radice
            Element root = xmlDocument.getDocumentElement();

            // Prendiamo tutti i nodi con <Persona>
            NodeList personeList = root.getElementsByTagName("persona");

            // Prendiamo le singole persone
            for (int i = 0; i < personeList.getLength(); i++) {

                // Salviamo l'elemento i-esimo in una struttura persona
                Element persona = (Element) personeList.item(i);

                String nome = persona.getAttribute("nome");
                String cognome = persona.getAttribute("cognome");

                System.out.println("Mi chiamo " + nome + " " + cognome);

            }

        } catch (Exception e) {
            System.err.println("ERRORE: " + e.getMessage());
        }

    }

}
