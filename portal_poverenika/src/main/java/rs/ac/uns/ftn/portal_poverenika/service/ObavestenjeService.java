package rs.ac.uns.ftn.portal_poverenika.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.portal_poverenika.model.obavestenje.Obavestenje;
import rs.ac.uns.ftn.portal_poverenika.repository.ObavestenjeRepository;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

@Service
public class ObavestenjeService {
    private static final String XML_PATH = "src/main/resources/static/data/xml/obavestenje.xml";

    private static final String XSD_PATH = "src/main/resources/static/data/schemas/obavestenje.xsd";

    private static final String JAXB_INSTANCE = "ftn.unc.as.rs.xml.poc.jaxb.model.obavestenje";

    @Autowired
    private JAXBService JAXBService;

    @Autowired
    private ObavestenjeRepository obavestenjeRepository;

    public String parseXmlObavestenje() throws JAXBException {
        return JAXBService.parseXml(JAXB_INSTANCE, XSD_PATH, XML_PATH);
    }

    public void writeXmlObavestenje(HttpServletResponse response) throws JAXBException {
        JAXBService.unmarshalXml(JAXB_INSTANCE, XML_PATH, response);
    }

    public void create(Obavestenje obavestenje) throws Exception {
        obavestenjeRepository.create(obavestenje);
    }

    public Obavestenje get(String documentId) {
        return obavestenjeRepository.get(documentId);
    }
}
