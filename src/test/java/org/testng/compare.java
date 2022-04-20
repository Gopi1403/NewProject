package org.testng;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class compare {
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		DocumentBuilder db = dbf.newDocumentBuilder();
		
		Document doc1 = db.parse(new File("C:\\Users\\gopin\\Downloads\\SOLP0000005381-Urenbriefje_verzonden_2022_08_Candela_C._Grima_Rufete.xml"));
		
		Document doc2 = db.parse(new File("C:\\Users\\gopin\\Downloads\\SOLT0000008123-Urenbriefje_2022_08_Candela_C._Grima_Rufete.xml"));
//		doc2.normalizeDocument();
//		boolean equalNode = doc1.isEqualNode(doc2);
//		System.out.println(equalNode); 
//		
		NodeList timeintervallist = doc1.getElementsByTagName("TimeInterval");
		NodeList timeintervallist1 = doc2.getElementsByTagName("TimeInterval");
		
		for (int i = 0; i < timeintervallist.getLength(); i++) {
			Node timeintervals = timeintervallist.item(i);
			Node timeintervals1 = timeintervallist1.item(i);
			
			short nodeType = timeintervals.getNodeType();
			short nodeType2 = timeintervals1.getNodeType();
			System.out.println(nodeType +" and "+ nodeType2);
			
			Node nextSibling = timeintervals.getNextSibling();
			Node nextSibling2 = timeintervals.getNextSibling();
		if (nextSibling.getNodeType()==Node.TEXT_NODE & nextSibling2.getNodeType()==Node.TEXT_NODE) {
			Text ns=(Text) nextSibling;
			Text ns1=(Text) nextSibling2;
			
			int length = ns.getLength();
			int length2 = ns1.getLength();
			
			short nodeType3 = nextSibling.getNodeType();
			short nodeType4 = nextSibling2.getNodeType();
			
			String nodeName = nextSibling.getTextContent();
			System.out.println(nodeName);
			
		System.out.println("Text Node Lengths are "+length +" and "+ length2);
		System.out.println("The Node Types are "+nodeType3 +" and "+nodeType4);
		}
		else {
			System.out.println("find");
		}
//			
//			
//			if (timeintervals.getNodeType()==Node.ELEMENT_NODE && timeintervals1.getNodeType()==Node.ELEMENT_NODE) {
//				Element timeintervalsElement=(Element) timeintervals;
//				System.out.println(timeintervalsElement.getTagName()+":"+timeintervalsElement.getAttribute("type"));
//				
//				Element timeintervalsElement1=(Element) timeintervals1;
//				System.out.println(timeintervalsElement1.getTagName()+":"+timeintervalsElement1.getAttribute("type"));
//		
//		
//	}
		}
	}

}
