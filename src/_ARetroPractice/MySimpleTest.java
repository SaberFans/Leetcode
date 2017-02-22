package _ARetroPractice;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by yang on 2016/12/1.
 */
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

class MySimpleTest {

    static void iterate(NodeList nodes, char startingLetter, Collection<String> names) {
        for (int i = 0; i < nodes.getLength(); i++) {
            Node curNode = nodes.item(i);
            String folderName = curNode.getAttributes().item(0).getNodeValue();
            if(folderName.startsWith(""+startingLetter))
                names.add(folderName);
            if(curNode.hasChildNodes()){
                iterate(curNode.getChildNodes(), startingLetter, names);
            }

        }
    }

    public static Collection<String> folderNames(String xml , char startingLetter) throws Exception {
        Collection<String> matchedNames = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //factory.setValidating(true);
        factory.setIgnoringElementContentWhitespace(true);

        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new ByteArrayInputStream(xml.getBytes())));
        NodeList list = doc.getChildNodes();

        iterate(list, startingLetter, matchedNames);


        return matchedNames;


    }

    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<folder name=\"c\">" +
                        "<folder name=\"program files\">" +
                        "<folder name=\"uninstall information\" />" +
                        "</folder>" +
                        "<folder name=\"users\" />" +
                        "</folder>";

        Collection<String> names = folderNames(xml, 'u');
        for(String name: names)
            System.out.println(name);
    }
}
