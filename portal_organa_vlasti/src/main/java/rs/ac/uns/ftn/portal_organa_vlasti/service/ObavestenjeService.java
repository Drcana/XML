package rs.ac.uns.ftn.portal_organa_vlasti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.portal_organa_vlasti.dto.DocumentDto;
import rs.ac.uns.ftn.portal_organa_vlasti.dto.ObavestenjeCollection;
import rs.ac.uns.ftn.portal_organa_vlasti.model.obavestenje.Obavestenje;
import rs.ac.uns.ftn.portal_organa_vlasti.model.user.User;
import rs.ac.uns.ftn.portal_organa_vlasti.repository.ObavestenjeRepository;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

@Service
public class ObavestenjeService {

    private static final String TARGET_NAMESPACE = "http://www.ftn.uns.ac.rs/obavestenje";

    private static final String XML_PATH = "src/main/resources/static/data/xml/obavestenje.xml";

    private static final String XSD_PATH = "src/main/resources/static/data/xsd/obavestenje.xsd";

    private static final String JAXB_INSTANCE = "rs.ac.uns.ftn.portal_poverenika.model.obavestenje";

    @Autowired
    private JAXBService jaxbService;

    @Autowired
    private ObavestenjeRepository obavestenjeRepository;

    public String parseXmlObavestenje() throws JAXBException {
        return jaxbService.parseXml(JAXB_INSTANCE, XSD_PATH, XML_PATH);
    }

    public void writeXmlObavestenje(HttpServletResponse response) throws JAXBException {
        jaxbService.unmarshalXml(JAXB_INSTANCE, XML_PATH, response);
    }

    public DocumentDto create(Obavestenje obavestenje, Authentication authentication) throws Exception {
        String id = UUID.randomUUID().toString();

        obavestenje.setId(id);
        obavestenje.setUserId(getEmailOfLoggedUser(authentication));
        obavestenje.setDatum(getTodayDate());
        obavestenje.setAbout(String.format("%s/%s", TARGET_NAMESPACE, id));

        obavestenjeRepository.create(obavestenje);

        return new DocumentDto(id);
    }

    private String getEmailOfLoggedUser(Authentication authentication) {
        return ((User) authentication.getPrincipal()).getEmail();
    }

    private XMLGregorianCalendar getTodayDate() throws DatatypeConfigurationException {
        GregorianCalendar gregory = new GregorianCalendar();
        gregory.setTime(new Date());

        return DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory);
    }

    public Obavestenje get(String documentId) {
        return obavestenjeRepository.get(documentId);
    }

    public ObavestenjeCollection getAll() {
        return obavestenjeRepository.getAll();
    }

    public ObavestenjeCollection getAllByUserId(Authentication authentication) {
        return obavestenjeRepository.getAllByUserId(getEmailOfLoggedUser(authentication));
    }

}
