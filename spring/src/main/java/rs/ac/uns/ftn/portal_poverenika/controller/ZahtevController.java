package rs.ac.uns.ftn.portal_poverenika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import rs.ac.uns.ftn.portal_poverenika.model.zahtev.DokumentZahtev;
import rs.ac.uns.ftn.portal_poverenika.service.ZahtevService;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

@Controller
@RequestMapping("/api/zahtev")
public class ZahtevController {

    @Autowired
    private ZahtevService service;

    @GetMapping
    public ResponseEntity<String> parseXmlZahtev() throws JAXBException {
        return new ResponseEntity<>(service.parseXmlZahtev(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void writeXmlZahtev(final HttpServletResponse response) throws JAXBException {
        service.writeXmlZahtev(response);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody DokumentZahtev dokumentZahtev) throws Exception {
        service.create(dokumentZahtev);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<DokumentZahtev> get(@PathVariable("id") String documentId) {
        return new ResponseEntity<>(service.get(documentId), HttpStatus.OK);
    }
}
