package rs.ac.uns.ftn.portal_poverenika.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.portal_poverenika.dto.DocumentDto;
import rs.ac.uns.ftn.portal_poverenika.dto.ZalbaProtivOdlukeCollection;
import rs.ac.uns.ftn.portal_poverenika.model.user.User;
import rs.ac.uns.ftn.portal_poverenika.model.zalba_protiv_odluke.ZalbaProtivOdluke;
import rs.ac.uns.ftn.portal_poverenika.repository.ZalbaProtivOdlukeRepository;

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
public class ZalbaProtivOdlukeService {

    private static final String XML_PATH = "src/main/resources/static/data/xml/zalba_protiv_odluke.xml";

    private static final String XSD_PATH = "src/main/resources/static/data/xsd/zalba_protiv_odluke.xsd";

    private static final String JAXB_INSTANCE = "rs.ac.uns.ftn.portal_poverenika.model.zalba_protiv_odluke";

    private static final String TARGET_NAMESPACE = "http://www.ftn.uns.ac.rs/zalba_protiv_odluke";

    @Autowired
    private JAXBService jaxbService;

    @Autowired
    private ZalbaProtivOdlukeRepository zalbaProtivOdlukeRepository;

    public String parseXmlZalbaProtivOdlukeAsString() throws JAXBException {
        ZalbaProtivOdluke zalbaProtivOdluke = jaxbService.parseXml(JAXB_INSTANCE, XSD_PATH, XML_PATH);

        StringWriter stringWriter = new StringWriter();
        JAXB.marshal(zalbaProtivOdluke, stringWriter);

        return stringWriter.toString();
    }

    public ZalbaProtivOdluke parseXmlZalbaProtivOdlukeAsObject() throws JAXBException {
        return jaxbService.parseXml(JAXB_INSTANCE, XSD_PATH, XML_PATH);
    }

    public void writeXmlZalbaProtivOdluke(HttpServletResponse response) throws JAXBException {
        jaxbService.unmarshalXml(JAXB_INSTANCE, XML_PATH, response);
    }

    public DocumentDto create(ZalbaProtivOdluke zalbaProtivOdluke, Authentication authentication) throws Exception {
        String id = UUID.randomUUID().toString();

        zalbaProtivOdluke.setId(id);
        zalbaProtivOdluke.setUserId(getEmailOfLoggedUser(authentication));
        zalbaProtivOdluke.setDatum(getTodayDate());
        zalbaProtivOdluke.setAbout(String.format("%s/%s", TARGET_NAMESPACE, id));

        zalbaProtivOdlukeRepository.create(zalbaProtivOdluke);

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

    public ZalbaProtivOdluke get(String documentId) {
        return zalbaProtivOdlukeRepository.get(documentId);
    }

    public ZalbaProtivOdlukeCollection getAll() {
        return zalbaProtivOdlukeRepository.getAll();
    }

    public ZalbaProtivOdlukeCollection getAllByUserId(Authentication authentication) {
        return zalbaProtivOdlukeRepository.getAllByUserId(getEmailOfLoggedUser(authentication));
    }
}
