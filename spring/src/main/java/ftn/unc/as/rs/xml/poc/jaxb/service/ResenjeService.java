package ftn.unc.as.rs.xml.poc.jaxb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class ResenjeService {

    @Autowired
    private DomService domService;

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
