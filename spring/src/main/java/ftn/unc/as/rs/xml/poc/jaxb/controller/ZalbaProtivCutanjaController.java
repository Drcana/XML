package ftn.unc.as.rs.xml.poc.jaxb.controller;

import ftn.unc.as.rs.xml.poc.jaxb.model.zalbaProtivCutanja.ZalbaProtivCutanja;
import ftn.unc.as.rs.xml.poc.jaxb.service.ZalbaProtivCutanjaService;
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

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

@Controller
@RequestMapping("/api/zalbaProtivCutanja")
public class ZalbaProtivCutanjaController {

    @Autowired
    private ZalbaProtivCutanjaService service;

    @GetMapping
    public ResponseEntity<String> parseXmlZalbaProtivCutanja() throws JAXBException {
        return new ResponseEntity<>(service.parseXmlZalbaProtivCutanja(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void writeXmlZalbaProtivCutanja(final HttpServletResponse response) throws JAXBException {
        service.writeXmlZalbaProtivCutanja(response);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ZalbaProtivCutanja zalbaProtivCutanja) throws Exception {
        service.create(zalbaProtivCutanja);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ZalbaProtivCutanja> get(@PathVariable("id") String documentId) {
        return new ResponseEntity<>(service.get(documentId), HttpStatus.OK);
    }
}
