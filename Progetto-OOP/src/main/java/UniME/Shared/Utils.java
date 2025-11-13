package UniME.Shared;

import java.io.File;
//import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

//import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerFactory;

//import javax.xml.transform.dom.DOMSource;

//import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Utils {

    public static String getElementValue(String file, String tag) {
        File xmFile = new File(System.getProperty("user.dir") + File.separator + file); // salviamo la directory
                                                                                        // completa del file
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance(); // creiamo la variabile db factory
        DocumentBuilder documentBuilder; // creiamo la variabile document builder
        Document config; // creiamo la variabile configurazione
        Element root; // creiamo la variabile rotta
        NodeList lista; // creiamo la variabile lista
        try {
            documentBuilder = dbFactory.newDocumentBuilder(); // creiamo il document builder dalla dbFactory per poter
                                                              // aprire il file .xml
            config = documentBuilder.parse(xmFile); // inseriamo nella configurazione la directory completa del file
            root = config.getDocumentElement(); // prendiamo la radice del documento xml passato
            lista = root.getElementsByTagName(tag); // prendiamo la lista degli elementi con tag = al valore passato al
                                                    // metodo
            return lista.item(0).getTextContent(); // prendiamo il primo elemento di questa lista
        } catch (Exception e) {
            throw new RuntimeException(e); // in caso di errore stampiamo con runtimeexception cosa sta succedendo
        }

    }

}
