package rs.ac.uns.ftn.portal_poverenika.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.portal_poverenika.dto.DocumentDto;
import rs.ac.uns.ftn.portal_poverenika.dto.ResenjeCollection;
import rs.ac.uns.ftn.portal_poverenika.model.resenje.Resenje;
import rs.ac.uns.ftn.portal_poverenika.model.user.User;
import rs.ac.uns.ftn.portal_poverenika.repository.ResenjeRepository;

import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

@Service
public class ResenjeService {

    private static final String TARGET_NAMESPACE = "http://www.ftn.uns.ac.rs/resenje";

    @Autowired
    private DomService domService;

    @Autowired
    private ResenjeRepository resenjeRepository;

    public void writeXmlResenje(HttpServletResponse response) throws IOException {
        domService.createDocument();
        domService.generateResenje();
        domService.transform(response.getOutputStream());
    }

    public String parseXmlResenje() {
        domService.buildResenjeDocument();

        return domService.extractTreeToString(domService.getDocument());
    }
    public DocumentDto create(Resenje resenje, Authentication authentication) throws Exception {
        String id = UUID.randomUUID().toString();

        resenje.setId(id);
        resenje.setUserId(getEmailOfLoggedUser(authentication));
        resenje.setDatum(getTodayDate());
        resenje.setAbout(String.format("%s/%s", TARGET_NAMESPACE, id));

        resenjeRepository.create(resenje);

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

    public Resenje get(String documentId) {
        return resenjeRepository.get(documentId);
    }

    public ResenjeCollection getAll() {
        return resenjeRepository.getAll();
    }

    public ResenjeCollection getAllByUserId(Authentication authentication) {
        return resenjeRepository.getAllByUserId(getEmailOfLoggedUser(authentication));
    }

}
