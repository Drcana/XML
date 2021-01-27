package rs.ac.uns.ftn.portal_organa_vlasti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.portal_organa_vlasti.dto.DocumentDto;
import rs.ac.uns.ftn.portal_organa_vlasti.dto.ZahtevCollection;
import rs.ac.uns.ftn.portal_organa_vlasti.model.user.User;
import rs.ac.uns.ftn.portal_organa_vlasti.model.zahtev.DokumentZahtev;
import rs.ac.uns.ftn.portal_organa_vlasti.repository.ZahtevRepository;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

@Service
public class ZahtevService {

    private static final String XML_PATH = "src/main/resources/static/data/xml/zahtev.xml";

    private static final String XSD_PATH = "src/main/resources/static/data/xsd/zahtev.xsd";

    private static final String JAXB_INSTANCE = "rs.ac.uns.ftn.portal_organa_vlasti.model.zahtev";

    @Autowired
    private JAXBService jaxbService;

    @Autowired
    private ZahtevRepository zahtevRepository;

    public String parseXmlZahtev() throws JAXBException {
        return jaxbService.parseXml(JAXB_INSTANCE, XSD_PATH, XML_PATH);
    }

    public void writeXmlZahtev(HttpServletResponse response) throws JAXBException {
        jaxbService.unmarshalXml(JAXB_INSTANCE, XML_PATH, response);
    }

    public DocumentDto create(DokumentZahtev dokumentZahtev, Authentication authentication) throws Exception {
        dokumentZahtev.setId(UUID.randomUUID().toString());
        dokumentZahtev.setUserId(getEmailOfLoggedUser(authentication));
        dokumentZahtev.setDatum(getTodayDate());

        zahtevRepository.create(dokumentZahtev);

        return new DocumentDto(dokumentZahtev.getId());
    }

    private String getEmailOfLoggedUser(Authentication authentication) {
        return ((User) authentication.getPrincipal()).getEmail();
    }

    private XMLGregorianCalendar getTodayDate() throws DatatypeConfigurationException {
        GregorianCalendar gregory = new GregorianCalendar();
        gregory.setTime(new Date());

        return DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory);
    }

    public DokumentZahtev get(String documentId) {
        return zahtevRepository.get(documentId);
    }

    public ZahtevCollection getAll() {
        return zahtevRepository.getAll();
    }

    public boolean delete(String documentId) throws Exception {
        return zahtevRepository.delete(documentId);
    }

    public ZahtevCollection getAllByUserId(Authentication authentication) {
        return zahtevRepository.getAllByUserId(getEmailOfLoggedUser(authentication));
    }
}
