package DomandePeppe.J_DomSax;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class SAX_Handler extends DefaultHandler {

    private boolean inNome = false;

    @Override
    public void startDocument() {
        System.out.println("Inizio del documento XML");
    }

    @Override
    public void endDocument() {
        System.out.println("Fine del documento XML");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("persona")) {
            int id = Integer.parseInt(attributes.getValue("id"));
            System.out.println("Trovata persona con ID: " + id);
        } else if (qName.equalsIgnoreCase("nome")) {
            inNome = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("persona")) {
            System.out.println("Fine della persona");
        } else if (qName.equalsIgnoreCase("nome")) {
            inNome = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (inNome) {
            String nome = new String(ch, start, length);
            System.out.println("Nome trovato: " + nome);
            inNome = false;
        }
    }

}
