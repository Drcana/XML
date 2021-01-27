package rs.ac.uns.ftn.portal_organa_vlasti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.portal_organa_vlasti.model.zahtev.DokumentZahtev;
import rs.ac.uns.ftn.portal_organa_vlasti.repository.ZahtevRepository;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

@Service
public class ZahtevService {

    private static final String XML_PATH = "src/main/resources/static/data/xml/zahtev.xml";

    private static final String XSD_PATH = "src/main/resources/static/data/xsd/zahtev.xsd";

    private static final String JAXB_INSTANCE = "rs.ac.uns.ftn.portal_organa_vlasti.model.zahtev";

    @Autowired
    private JAXBService JAXBService;

    @Autowired
    private ZahtevRepository zahtevRepository;

    public String parseXmlZahtev() throws JAXBException {
        return JAXBService.parseXml(JAXB_INSTANCE, XSD_PATH, XML_PATH);
    }

    public void writeXmlZahtev(HttpServletResponse response) throws JAXBException {
        JAXBService.unmarshalXml(JAXB_INSTANCE, XML_PATH, response);
    }

    public void create(DokumentZahtev dokumentZahtev) throws Exception {
        zahtevRepository.create(dokumentZahtev);
    }

    public DokumentZahtev get(String documentId) {
        return zahtevRepository.get(documentId);
    }
}
