package org.testng;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.custommonkey.xmlunit.XMLAssert;
import org.custommonkey.xmlunit.XMLUnit;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class CompareXmls {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		DocumentBuilder db = dbf.newDocumentBuilder();
		
		Document doc1 = db.parse(new File("C:\\Users\\gopin\\Downloads\\SOLP0000005381-Urenbriefje_verzonden_2022_08_Candela_C._Grima_Rufete.xml"));
		Document doc2 = db.parse(new File("C:\\Users\\gopin\\Downloads\\SOLT0000008123-Urenbriefje_2022_08_Candela_C._Grima_Rufete.xml"));
		
		NodeList timeintervallist = doc1.getElementsByTagName("TimeInterval");
		NodeList timeintervallist1 = doc2.getElementsByTagName("TimeInterval");
		
		for (int i = 0; i < timeintervallist.getLength(); i++) {
			Node timeintervals = timeintervallist.item(i);
			Node timeintervals1 = timeintervallist1.item(i);
			
			if (timeintervals.getNodeType()==Node.ELEMENT_NODE && timeintervals1.getNodeType()==Node.ELEMENT_NODE) {
				Element timeintervalsElement=(Element) timeintervals;
				System.out.println(timeintervalsElement.getTagName()+":"+timeintervalsElement.getAttribute("type"));
				
				Element timeintervalsElement1=(Element) timeintervals1;
				System.out.println(timeintervalsElement1.getTagName()+":"+timeintervalsElement1.getAttribute("type"));
				
				NodeList timeDetails = timeintervals.getChildNodes();
				NodeList timeDetails1 = timeintervals1.getChildNodes();
				
				
				for (int j = 0; j < timeDetails.getLength(); j++) {
					
					Node detail = timeDetails.item(j);
					Node detail1 = timeDetails1.item(j);
					
					 
					if (detail.getNodeType()==Node.ELEMENT_NODE && detail1.getNodeType()==Node.ELEMENT_NODE) {
						
						Element detailElement=(Element) detail;
						System.out.println("    "+detailElement.getTagName()+":"+detailElement.getTextContent()+detailElement.getAttribute("currency"));
						
						Element detailElement1=(Element) detail1;
						System.out.println("    "+detailElement1.getTagName()+":"+detailElement1 .getTextContent()+detailElement1.getAttribute("currency"));
						
						if (detailElement.getTextContent().equals(detailElement1 .getTextContent())) {
							
						} else {
							System.out.println(detailElement1.getTagName()+"s Does not Match");

						}
					}
				}
				
			}
		}
//		Document doc2 = db.parse(new File("C:\\Users\\gopin\\Downloads\\SOLT0000008123-Urenbriefje_2022_08_Candela_C._Grima_Rufete.xml"));
//
//		
//		NodeList timeintervallist1 = doc1.getElementsByTagName("TimeInterval");
//		for (int i = 0; i < timeintervallist1.getLength(); i++) {
//			Node timeintervals1 = timeintervallist1.item(i);
//			
//			if (timeintervals1.getNodeType()==Node.ELEMENT_NODE) {
//				Element timeintervalsElement1=(Element) timeintervals1;
//				System.out.println("Interval Type:"+timeintervalsElement1.getAttribute("type"));
//				
//				NodeList timeDetails1 = timeintervals1.getChildNodes();
//				for (int j = 0; j < timeDetails1.getLength(); j++) {
//					
//					Node detail1 = timeDetails1.item(j);
//					if (detail1.getNodeType()==Node.ELEMENT_NODE) {
//						Element detailElement1=(Element) detail1;
//						System.out.println("    "+detailElement1.getTagName()+":"+detailElement1 .getTextContent());
//					}
//				}
//				
//			}
//		}
	}
	
}
