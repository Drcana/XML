package rs.ac.uns.ftn.portal_poverenika.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.portal_poverenika.model.zalbaProtivCutanja.ZalbaProtivCutanja;
import rs.ac.uns.ftn.portal_poverenika.repository.ZalbaProtivCutanjaRepository;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

@Service
public class ZalbaProtivCutanjaService {

    private static final String XML_PATH = "src/main/resources/static/data/xml/zalbaProtivCutanja.xml";

    private static final String XSD_PATH = "src/main/resources/static/data/xsd/zalbaProtivCutanja.xsd";

    private static final String JAXB_INSTANCE = "rs.ac.uns.ftn.portal_poverenika.model.zalbaProtivCutanja";

    @Autowired
    private JAXBService JAXBService;

    @Autowired
    private ZalbaProtivCutanjaRepository zalbaProtivCutanjaRepository;

    public String parseXmlZalbaProtivCutanja() throws JAXBException {
        return JAXBService.parseXml(JAXB_INSTANCE, XSD_PATH, XML_PATH);
    }

    public void writeXmlZalbaProtivCutanja(HttpServletResponse response) throws JAXBException {
        JAXBService.unmarshalXml(JAXB_INSTANCE, XML_PATH, response);
    }

    public void create(ZalbaProtivCutanja zalbaProtivCutanja) throws Exception {
        zalbaProtivCutanjaRepository.create(zalbaProtivCutanja);
    }

    public ZalbaProtivCutanja get(String documentId) {
        return zalbaProtivCutanjaRepository.get(documentId);
    }
}
