package rs.ac.uns.ftn.portal_poverenika.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.portal_poverenika.dto.DocumentDto;
import rs.ac.uns.ftn.portal_poverenika.dto.ZalbaProtivCutanjaCollection;
import rs.ac.uns.ftn.portal_poverenika.model.user.User;
import rs.ac.uns.ftn.portal_poverenika.model.zalba_protiv_cutanja.ZalbaProtivCutanja;
import rs.ac.uns.ftn.portal_poverenika.repository.ZalbaProtivCutanjaRepository;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.StringWriter;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

@Service
public class ZalbaProtivCutanjaService {

    private static final String TARGET_NAMESPACE = "http://www.ftn.uns.ac.rs/zalba_protiv_cutanja";

    private static final String XML_PATH = "src/main/resources/static/data/xml/zalba_protiv_cutanja.xml";

    private static final String XSD_PATH = "src/main/resources/static/data/xsd/zalba_protiv_cutanja.xsd";

    private static final String JAXB_INSTANCE = "rs.ac.uns.ftn.portal_poverenika.model.zalba_protiv_cutanja";

    @Autowired
    private JAXBService jaxbService;

    @Autowired
    private ZalbaProtivCutanjaRepository zalbaProtivCutanjaRepository;

    public String parseXmlZalbaProtivCutanjaAsString() throws JAXBException {
        ZalbaProtivCutanja zalbaProtivCutanja = jaxbService.parseXml(JAXB_INSTANCE, XSD_PATH, XML_PATH);

        StringWriter stringWriter = new StringWriter();
        JAXB.marshal(zalbaProtivCutanja, stringWriter);

        return stringWriter.toString();
    }

    public ZalbaProtivCutanja parseXmlZalbaProtivCutanjaAsObject() throws JAXBException {
        return jaxbService.parseXml(JAXB_INSTANCE, XSD_PATH, XML_PATH);
    }

    public void writeXmlZalbaProtivCutanja(HttpServletResponse response) throws JAXBException {
        jaxbService.unmarshalXml(JAXB_INSTANCE, XML_PATH, response);
    }

    public DocumentDto create(ZalbaProtivCutanja zalbaProtivCutanja, Authentication authentication) throws Exception {
        String id = UUID.randomUUID().toString();

        zalbaProtivCutanja.setId(id);
        zalbaProtivCutanja.setUserId(getEmailOfLoggedUser(authentication));
        zalbaProtivCutanja.setDatum(getTodayDate());
        zalbaProtivCutanja.setAbout(String.format("%s/%s", TARGET_NAMESPACE, id));

        zalbaProtivCutanjaRepository.create(zalbaProtivCutanja);

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

    public ZalbaProtivCutanja get(String documentId) {
        return zalbaProtivCutanjaRepository.get(documentId);
    }

    public ZalbaProtivCutanjaCollection getAll() {
        return zalbaProtivCutanjaRepository.getAll();
    }

    public ZalbaProtivCutanjaCollection getAllByUserId(Authentication authentication) {
        return zalbaProtivCutanjaRepository.getAllByUserId(getEmailOfLoggedUser(authentication));
    }

}
