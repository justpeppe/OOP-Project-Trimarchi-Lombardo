package DomandePeppe.J_DomSax;

import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.File;

public class SAX {

    public static void main(String[] args) {

        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            SAX_Handler sax_Handler = new SAX_Handler();

            File xmFile = new File("esempio.xml");

            sp.parse(xmFile, sax_Handler);

        } catch (Exception e) {
            System.err.println("ERRORE: " + e.getMessage());
        }

    }
}
