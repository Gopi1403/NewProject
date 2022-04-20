package org.testng;

import java.io.File;
import java.io.IOException;

import javax.swing.text.html.parser.Entity;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.xmlbeans.xml.stream.Attribute;
import org.openqa.selenium.WebElement;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import com.google.common.base.Verify;

public class Sample { 
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
	
	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

	DocumentBuilder db = dbf.newDocumentBuilder();
	
Document doc1 = db.parse(new File("C:\\Users\\gopin\\Downloads\\SOLP0000005381-Urenbriefje_verzonden_2022_08_Candela_C._Grima_Rufete.xml"));
Document doc2 = db.parse(new File("C:\\Users\\gopin\\Downloads\\SOLT0000008123-Urenbriefje_2022_08_Candela_C._Grima_Rufete.xml"));	

boolean hasChildNodes = doc1.hasChildNodes();
System.out.println(hasChildNodes);

//Element elementById = doc1.getElementById("StaffingCustomer");
//System.out.println(elementById);
//
//String localName = doc1.getLocalName();
//System.out.println(localName);
//
//Element documentElement = doc1.getDocumentElement();
//System.out.println(documentElement);
//
//String baseURI = doc1.getBaseURI();
//System.out.println(baseURI);
//
//String documentURI = doc1.getDocumentURI();
//System.out.println(documentURI);
//
//DOMConfiguration domConfig = doc1.getDomConfig();
//System.out.println(domConfig);
//
//Class<? extends Document> class1 = doc1.getClass();
//System.out.println(class1);

NodeList childNodes = doc1.getChildNodes();
System.out.println(childNodes.getLength());
for (int i = 0; i < childNodes.getLength(); i++) {
	Node item = childNodes.item(i);
	if (item.getNodeType()==Node.ELEMENT_NODE) {
		Element itemEle = (Element) item;
		System.out.println(itemEle.getTagName());
	}
	else if (item.getNodeType()==Node.TEXT_NODE) {
		Text itemEleme=(Text) item;
		System.out.println(itemEleme.getLength());
	}
	else if (item.getNodeType()==Node.ATTRIBUTE_NODE) {
		Attribute iteme=(Attribute) item;
		System.out.println(iteme.getValue());
	}
	NamedNodeMap attributes = item.getAttributes(); 
	System.out.println(attributes.getLength());
	for (int j = 0; j < attributes.getLength(); j++) {
		Node item2 = attributes.item(i);
		String textContent = item2.getTextContent();
		System.out.println(textContent);
	}
}

NodeList elementsByTagName = doc1.getElementsByTagName("IdValue");
System.out.println(elementsByTagName.getLength());
for (int i = 0; i < elementsByTagName.getLength(); i++) {
	Node item = elementsByTagName.item(i);
	if (item.getNodeType()==Node.ELEMENT_NODE) {
		Element itemEle = (Element) item;
		System.out.println(itemEle.getTagName());
	}
	
}

//	NodeList idList= doc1.getElementsByTagName("Id");
//	NodeList idList1= doc2.getElementsByTagName("Id");
//	
//	for (int i = 0; i < idList.getLength(); i++) {
//		Node id = idList.item(i);
//		Node id1 = idList1.item(i);
//		
//		if (id.getNodeType()==Node.ELEMENT_NODE && id1.getNodeType()==Node.ELEMENT_NODE) {
//			Element idElement=(Element) id;
//			Element idElement1=(Element) id1;
//			
//			System.out.println(idElement.getTagName()+":"+idElement.getAttribute("idOwner"));
//			System.out.println(idElement1.getTagName()+":"+idElement1.getAttribute("idOwner"));
			
//			if (idElement.getTagName().equals(idElement1.getTagName()) && idElement.getAttribute("idOwner").equals(idElement1.getAttribute("idOwner"))) {
//				
//			} else {
//				System.out.println("Condition matches");
//			}
//			
//			NodeList idchilds = id.getChildNodes();
//			NodeList idchilds1 = id1.getChildNodes();
//			
//			for (int j = 0; j < idchilds.getLength(); j++) {
//				
//				Node detail = idchilds.item(j);
//				Node detail1 = idchilds1.item(j);
//				
//				if (detail.getNodeType()==Node.ELEMENT_NODE && detail1.getNodeType()==Node.ELEMENT_NODE) {
//					Element detailElement=(Element) detail;
//					System.out.println("    "+detailElement.getTagName()+":"+detailElement.getTextContent());
//					Element detailElement1=(Element) detail1;
//					System.out.println("    "+detailElement1.getTagName()+":"+detailElement1.getTextContent());
//					
////					Assert.assertNotEquals(detailElement.getTextContent(), detailElement1.getTextContent());
//					if (detailElement.getTextContent().equals(detailElement1.getTextContent())) {
//					System.out.println("Condition Matches");	
//					}
//					else {
//						System.out.println(detailElement1.getTagName()+"s Does not Match");
//					}
//					
//				}
//			}
//			
//		}
//	}
//Document doc2 = db.parse(new File("C:\\Users\\gopin\\Downloads\\SOLP0000005381-Urenbriefje_verzonden_2022_08_Candela_C._Grima_Rufete.xml"));
//
//	
//	NodeList idList1= doc2.getElementsByTagName("Id");
//	for (int i = 0; i < idList1.getLength(); i++) {
//		Node id1 = idList1.item(i);
//		
//		if (id1.getNodeType()==Node.ELEMENT_NODE) {
//			Element idElement1=(Element) id1;
//			System.out.println(idElement1.getTagName()+":"+idElement1.getAttribute("type"));
//			
//			NodeList idchilds1 = id1.getChildNodes();
//			for (int j = 0; j < idchilds1.getLength(); j++) {
//				
//				Node detail1 = idchilds1.item(j);
//				if (detail1.getNodeType()==Node.ELEMENT_NODE) {
//					Element detailElement1=(Element) detail1;
//					System.out.println("    "+detailElement1.getTagName()+":"+detailElement1.getTextContent()+detailElement1.getAttribute("currency"));
//				}
//			}
//			
//		}
//	}
	}
	 
	}


