package xml;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReadSOAPXMLFile {
	public static void main(String argv[]) {

		try {

			File fXmlFile = new File("C://Users//Zshi//Desktop//testFiles//soapmsg.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

//			NodeList nList = doc.getElementsByTagName("S:Envelope");
			NodeList envelopeNodeList = doc.getElementsByTagName("S:Body");
			Element bodyElement = (Element) envelopeNodeList.item(0);
			System.out.println("bodyElement: " + bodyElement.getNodeName());
			
			NodeList detailNodes = bodyElement.getElementsByTagName("detail");
			Element detailElement = (Element) detailNodes.item(0);
			System.out.println("detailElement: " + detailElement.getNodeName());
			
			NodeList spectrumExceptionNodes = bodyElement.getElementsByTagName("ns2:SpectrumException");
//			Element detailElement = (Element) spectrumExceptionNodes.item(0);
//			System.out.println("detailElement: " + detailElement.getNodeName());
			
//			Node defaultNode = nodeList.item(0);
//			System.out.println("defaultNode: " + defaultNode.getNodeName());

			
			
			NodeList nList = doc.getElementsByTagName("S:Envelope");

			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					System.out.println("Staff id : " + eElement.getAttribute("id"));
					System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
					System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
					System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
