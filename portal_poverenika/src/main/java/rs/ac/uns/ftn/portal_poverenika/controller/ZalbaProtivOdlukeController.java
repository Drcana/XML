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
import rs.ac.uns.ftn.portal_poverenika.model.zalbaProtivOdluke.ZalbaProtivOdluke;
import rs.ac.uns.ftn.portal_poverenika.service.ZalbaProtivOdlukeService;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

@Controller
@RequestMapping("/api/zalbaProtivOdluke")
public class ZalbaProtivOdlukeController {

    @Autowired
    private ZalbaProtivOdlukeService service;

    @GetMapping
    public ResponseEntity<String> parseXmlZalbaProtivOdluke() throws JAXBException {
        return new ResponseEntity<>(service.parseXmlZalbaProtivOdluke(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void writeXmlZalbaProtivOdluke(final HttpServletResponse response) throws JAXBException {
        service.writeXmlZalbaProtivOdluke(response);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ZalbaProtivOdluke zalbaProtivOdluke) throws Exception {
        service.create(zalbaProtivOdluke);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ZalbaProtivOdluke> get(@PathVariable("id") String documentId) {
        return new ResponseEntity<>(service.get(documentId), HttpStatus.OK);
    }
}
