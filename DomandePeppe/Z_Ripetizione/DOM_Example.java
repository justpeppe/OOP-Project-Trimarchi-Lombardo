package DomandePeppe.Z_Ripetizione;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.File;

public class DOM_Example {
    public static void main(String[] args) {
        try {

            DocumentBuilderFactory doc_build_fact = DocumentBuilderFactory.newInstance();
            DocumentBuilder doc_build = doc_build_fact.newDocumentBuilder();

            File xmFile = new File("esempio.xml");
            Document doc = doc_build.parse(xmFile);

            Element radice = doc.getDocumentElement();

            NodeList lista_nodi = radice.getElementsByTagName("persona");

            for (int i = 0; i < lista_nodi.getLength(); i++) {
                // Accediamo ad attributi e sotto-elementi
                Element elemento = (Element) lista_nodi.item(i);

                String id = elemento.getAttribute("id");
                String nome = elemento.getElementsByTagName("nome").item(0).getTextContent();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
