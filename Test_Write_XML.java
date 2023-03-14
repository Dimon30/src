import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Test_Write_XML {

    /**
     * @param args
     * @throws TransformerException 
     * @throws ParserConfigurationException 
     * @throws IOException 
     */
    public static void main(String[] args) throws TransformerException, ParserConfigurationException, IOException {
        // TODO Auto-generated method stub
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//      System.out.print("Enter number to add elements in your XML file: ");
//      String str = bf.readLine();
        int no=2;
//      System.out.print("Enter root: ");
        String root = "SMS";
        DocumentBuilderFactory documentBuilderFactory =DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder =documentBuilderFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();

        Element rootElement = document.createElement(root);

            document.appendChild(rootElement);
//      for (int i = 1; i <= no; i++)
//        System.out.print("Enter the element: ");
//        String element = bf.readLine();
          String element ="Number";
          System.out.print("Enter the Number: ");
          String data = bf.readLine();
          Element em = document.createElement(element);
          em.appendChild(document.createTextNode(data));
          rootElement.appendChild(em);

          String element1 ="message";
          System.out.print("Enter the SMS: ");
          String data1 = bf.readLine();
          Element em1 = document.createElement(element1);
          em1.appendChild(document.createTextNode(data1));
          rootElement.appendChild(em1);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);

            StreamResult result =  new StreamResult(new StringWriter());

          //t.setParameter(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");
            transformer.transform(source, result);

          //writing to file
          FileOutputStream fop = null;
          File file;
          try {

                file = new File("Test_Write_XML.xml");
                fop = new FileOutputStream(file);

                // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }

                // get the content in bytes
                String xmlString = result.getWriter().toString();
                System.out.println(xmlString);
                byte[] contentInBytes = xmlString.getBytes();

                fop.write(contentInBytes);
                fop.flush();
                fop.close();

                System.out.println("Done");

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fop != null) {
                        fop.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

    }

}