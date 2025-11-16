package DomandePeppe.J_DomSax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler {

    // Estendo DefaultHandler per gestire gli eventi SAX

    // Questo metodo viene chiamato quando incontro un tag di apertura
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        // Controllo se il tag che ho trovato è "persona"
        if (qName.equalsIgnoreCase("persona")) {

            // Estraggo il valore dell'attributo "nome"
            String nome = attributes.getValue("nome");

            // Estraggo il valore dell'attributo "cognome" (attenzione alla maiuscola)
            String cognome = attributes.getValue("cognome");

            // Stampo i dati della persona trovata
            System.out.println("Trovata persona con nome " + nome + " cognome " + cognome);
        }
    }

    // Questo metodo viene chiamato quando incontro del testo tra i tag
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        // Converto l'array di caratteri in una stringa
        String content = new String(ch, start, length).trim();

        // Stampo il contenuto solo se non è vuoto
        if (!content.isEmpty()) {
            System.out.println("Contenuto: " + content);
        }
    }

    // Questo metodo viene chiamato quando incontro un tag di chiusura
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        // Posso usare questo metodo per segnalare la fine di un elemento
        if (qName.equalsIgnoreCase("persona")) {
            System.out.println("Fine persona\n");
        }
    }

    // Questo metodo viene chiamato all'inizio del documento
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Inizio parsing del documento XML\n");
    }

    // Questo metodo viene chiamato alla fine del documento
    @Override
    public void endDocument() throws SAXException {
        System.out.println("Fine parsing del documento XML\n");
    }
}