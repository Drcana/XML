package rs.ac.uns.ftn.portal_organa_vlasti.service;

import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import rs.ac.uns.ftn.portal_organa_vlasti.util.MyValidationEventHandler;

import javax.servlet.http.HttpServletResponse;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;

@Component
public class JAXBService {

    <T> String parseXml(String jaxbInstance, String xsdPath, String xmlPath) throws JAXBException {

        T object;

        try {
            JAXBContext context = JAXBContext.newInstance(jaxbInstance);

            Unmarshaller unmarshaller = context.createUnmarshaller();

            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File(xsdPath));

            object = (T) unmarshaller.unmarshal(new File(xmlPath));

            unmarshaller.setSchema(schema);
            unmarshaller.setEventHandler(new MyValidationEventHandler());

        } catch (SAXException | JAXBException e) {
            throw new JAXBException(e.getMessage());
        }

        StringWriter stringWriter = new StringWriter();
        JAXB.marshal(object, stringWriter);

        return stringWriter.toString();
    }

    <T> void unmarshalXml(String jaxbInstance, String xmlPath, HttpServletResponse response)
            throws JAXBException {

        JAXBContext context;
        T object;

        try {
            context = JAXBContext.newInstance(jaxbInstance);

            Unmarshaller unmarshaller = context.createUnmarshaller();
            object = (T) unmarshaller.unmarshal(new File(xmlPath));

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(object, response.getOutputStream());

        } catch (JAXBException | IOException e) {
            throw new JAXBException(e.getMessage());
        }
    }

    public <T> T getObjectFromNode(Node node, Class<?> classToMap) {
        JAXBContext context;

        try {
            context = JAXBContext.newInstance(classToMap);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            return (T) unmarshaller.unmarshal(node);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }

    public OutputStream getOutputStreamFromObject(Object xmlObject) {
        OutputStream os = new ByteArrayOutputStream();

        try {
            JAXBContext context = JAXBContext.newInstance(xmlObject.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty("com.sun.xml.bind.xmlHeaders",
                    " <?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            marshaller.setProperty("com.sun.xml.bind.xmlHeaders",
                    "<?xml-stylesheet type=\"text/xsl\" href=\"../xsl/grddl.xsl\"?>");
            marshaller.marshal(xmlObject, os);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return os;
    }
}
