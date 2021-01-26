package rs.ac.uns.ftn.portal_poverenika.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.portal_poverenika.repository.ResenjeRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class ResenjeService {

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
}
