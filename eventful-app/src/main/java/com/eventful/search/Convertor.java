package com.eventful.search;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;


public class Convertor {
    public static List<Event> convert(String xml) throws XPathExpressionException {
        List<Event> eventList=new ArrayList<>();
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();

        InputSource source = new InputSource(new StringReader(xml));
        Node nodeEvents = (Node) xpath.evaluate("/search/events", source, XPathConstants.NODE);
        if(nodeEvents==null){
            return eventList;
        }
        NodeList nodeList=nodeEvents.getChildNodes();

        for (int index = 0; index < nodeList.getLength(); index++) {
            Node node = nodeList.item(index);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                Event event=new Event();
                event.setId(eElement.getAttribute("id"));
                event.setTitle(eElement.getElementsByTagName("title").item(0).getTextContent());
                event.setCity_name(eElement.getElementsByTagName("city_name").item(0).getTextContent());
                event.setUrl(eElement.getElementsByTagName("url").item(0).getTextContent());
                event.setStart_time(eElement.getElementsByTagName("start_time").item(0).getTextContent());
                eventList.add(event);
            }
        }
        return eventList;
    }
}
