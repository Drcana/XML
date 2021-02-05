package rs.ac.uns.ftn.portal_poverenika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.uns.ftn.portal_poverenika.service.ResenjeService;
import rs.ac.uns.ftn.portal_poverenika.soap.client.OrganVlastiClient;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api/resenje")
public class ResenjeController {

    @Autowired
    private ResenjeService service;

    @Autowired
    private OrganVlastiClient organVlastiClient;

    @GetMapping
    public ResponseEntity<String> parseXmlResenje() {
        return new ResponseEntity<>(service.parseXmlResenje(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void writeXmlResenje(final HttpServletResponse response) throws IOException {
        service.writeXmlResenje(response);
    }

    @GetMapping("/zahtev/{id}")
    public String getZahtev(@PathVariable("id") String id) {
        return organVlastiClient.getZahtevId(id);
    }
}
