package com.example.HJWebFlux.util;
import com.example.HJWebFlux.domain.model.LinkSpeedDto;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class XmlParser {

    public List<LinkSpeedDto> parseXml(String xmlData) throws Exception {
        // XML Document 생성
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new ByteArrayInputStream(xmlData.getBytes(StandardCharsets.UTF_8)));

        NodeList itemList = document.getElementsByTagName("item");
        List<LinkSpeedDto> linkSpeedList = new ArrayList<>();

        // 각 <item> 노드 파싱
        for (int i = 0; i < itemList.getLength(); i++) {
            Node node = itemList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                LinkSpeedDto dto = new LinkSpeedDto(
                        getElementValue(element, "roadName"),
                        getElementValue(element, "linkId"),
                        getElementValue(element, "startNodeId"),
                        getElementValue(element, "endNodeId"),
                        getElementValueAsInteger(element, "speed"),
                        getElementValueAsDouble(element, "travelTime"),
                        getElementValue(element, "createdDate")
                );
                linkSpeedList.add(dto);
            }
        }
        return linkSpeedList;
    }

    private String getElementValue(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent();
        }
        return null;
    }

    private Integer getElementValueAsInteger(Element element, String tagName) {
        String value = getElementValue(element, tagName);
        return value != null ? Integer.parseInt(value) : null;
    }

    private Double getElementValueAsDouble(Element element, String tagName) {
        String value = getElementValue(element, tagName);
        return value != null ? Double.parseDouble(value) : null;
    }
}

