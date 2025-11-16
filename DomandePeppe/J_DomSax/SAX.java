package DomandePeppe.J_DomSax;

import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.File;

public class SAX {

    public static void main(String[] args) {

        try {
            // Creo la factory per il parser SAX
            SAXParserFactory factory = SAXParserFactory.newInstance();

            // Creo il parser SAX
            SAXParser saxParser = factory.newSAXParser();

            // Creo un'istanza del mio handler personalizzato
            Handler handler = new Handler();

            // Specifico il file XML da parsare
            File xmlFile = new File("File.xml");

            // Avvio il parsing passando il file e l'handler
            saxParser.parse(xmlFile, handler);

        } catch (Exception e) {
            System.err.println("ERRORE: " + e.getMessage());
        }
    }
}
