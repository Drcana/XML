package ftn.unc.as.rs.xml.poc.jaxb.service;

import ftn.unc.as.rs.xml.poc.jaxb.model.zalbaProtivOdluke.ZalbaProtivOdluke;
import ftn.unc.as.rs.xml.poc.jaxb.repository.ZalbaProtivOdlukeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

@Service
public class ZalbaProtivOdlukeService {

    private static final String XML_PATH = "src/main/resources/static/data/xml/zalbaProtivOdluke.xml";

    private static final String XSD_PATH = "src/main/resources/static/data/schemas/zalbaProtivOdluke.xsd";

    private static final String JAXB_INSTANCE = "ftn.unc.as.rs.xml.poc.jaxb.model.zalbaProtivOdluke";

    @Autowired
    private MarshallerService marshallerService;

    @Autowired
    private ZalbaProtivOdlukeRepository zalbaProtivOdlukeRepository;

    public String parseXmlZalbaProtivOdluke() throws JAXBException {
        return marshallerService.parseXml(JAXB_INSTANCE, XSD_PATH, XML_PATH);
    }

    public void writeXmlZalbaProtivOdluke(HttpServletResponse response) throws JAXBException {
        marshallerService.unmarshalXml(JAXB_INSTANCE, XML_PATH, response);
    }

    public void create(ZalbaProtivOdluke zalbaProtivOdluke) throws Exception {
        zalbaProtivOdlukeRepository.create(zalbaProtivOdluke);
    }

    public ZalbaProtivOdluke get(String documentId) {
       return zalbaProtivOdlukeRepository.get(documentId);
    }
}
