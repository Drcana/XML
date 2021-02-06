package rs.ac.uns.ftn.portal_poverenika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import rs.ac.uns.ftn.portal_poverenika.dto.DocumentDto;
import rs.ac.uns.ftn.portal_poverenika.dto.ZalbaProtivCutanjaCollection;
import rs.ac.uns.ftn.portal_poverenika.model.zalba_protiv_cutanja.ZalbaProtivCutanja;
import rs.ac.uns.ftn.portal_poverenika.service.ZalbaProtivCutanjaService;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

@Controller
@RequestMapping("/api/zalbaProtivCutanja")
public class ZalbaProtivCutanjaController {

    @Autowired
    private ZalbaProtivCutanjaService service;

    @GetMapping(value = "/parse/string", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> parseXmlZalbaProtivCutanjaAsString() throws JAXBException {
        return new ResponseEntity<>(service.parseXmlZalbaProtivCutanjaAsString(), HttpStatus.OK);
    }

    @GetMapping(value = "/parse/object", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ZalbaProtivCutanja> parseXmlZalbaProtivCutanjaAsObject() throws JAXBException {
        return new ResponseEntity<>(service.parseXmlZalbaProtivCutanjaAsObject(), HttpStatus.OK);
    }

    @PostMapping("/write")
    @ResponseStatus(HttpStatus.OK)
    public void writeXmlZalbaProtivCutanja(final HttpServletResponse response) throws JAXBException {
        service.writeXmlZalbaProtivCutanja(response);
    }

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    @PreAuthorize("hasRole('ROLE_GRADJANIN')")
    public ResponseEntity<DocumentDto> create(@RequestBody ZalbaProtivCutanja zalbaProtivCutanja, Authentication authentication) throws Exception {
        return new ResponseEntity<>(service.create(zalbaProtivCutanja, authentication), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    @PreAuthorize("hasRole('ROLE_GRADJANIN')")
    public ResponseEntity<ZalbaProtivCutanja> get(@PathVariable("id") String documentId) {
        return new ResponseEntity<>(service.get(documentId), HttpStatus.OK);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_XML_VALUE)
    @PreAuthorize("hasRole('ROLE_POVERENIK')")
    public ResponseEntity<ZalbaProtivCutanjaCollection> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/all/userId", produces = MediaType.APPLICATION_XML_VALUE)
    @PreAuthorize("hasRole('ROLE_GRADJANIN')")
    public ResponseEntity<ZalbaProtivCutanjaCollection> getAllByUserId(Authentication authentication) {
        return new ResponseEntity<>(service.getAllByUserId(authentication), HttpStatus.OK);
    }
}
