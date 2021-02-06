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
import rs.ac.uns.ftn.portal_poverenika.dto.ZalbaProtivOdlukeCollection;
import rs.ac.uns.ftn.portal_poverenika.model.zalba_protiv_odluke.ZalbaProtivOdluke;
import rs.ac.uns.ftn.portal_poverenika.service.ZalbaProtivOdlukeService;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

@Controller
@RequestMapping("/api/zalbaProtivOdluke")
public class ZalbaProtivOdlukeController {

    @Autowired
    private ZalbaProtivOdlukeService service;

    @GetMapping(value = "/parse/string", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> parseXmlZalbaProtivOdlukeAsString() throws JAXBException {
        return new ResponseEntity<>(service.parseXmlZalbaProtivOdlukeAsString(), HttpStatus.OK);
    }

    @GetMapping(value = "/parse/object", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ZalbaProtivOdluke> parseXmlZalbaProtivOdlukeAsObject() throws JAXBException {
        return new ResponseEntity<>(service.parseXmlZalbaProtivOdlukeAsObject(), HttpStatus.OK);
    }

    @PostMapping("/write")
    @ResponseStatus(HttpStatus.OK)
    public void writeXmlZalbaProtivOdluke(final HttpServletResponse response) throws JAXBException {
        service.writeXmlZalbaProtivOdluke(response);
    }

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    @PreAuthorize("hasRole('ROLE_GRADJANIN')")
    public ResponseEntity<DocumentDto> create(@RequestBody ZalbaProtivOdluke zalbaProtivOdluke, Authentication authentication) throws Exception {
        return new ResponseEntity<>(service.create(zalbaProtivOdluke, authentication), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    @PreAuthorize("hasRole('ROLE_GRADJANIN')")
    public ResponseEntity<ZalbaProtivOdluke> get(@PathVariable("id") String documentId) {
        return new ResponseEntity<>(service.get(documentId), HttpStatus.OK);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_XML_VALUE)
    @PreAuthorize("hasRole('ROLE_POVERENIK')")
    public ResponseEntity<ZalbaProtivOdlukeCollection> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/all/userId", produces = MediaType.APPLICATION_XML_VALUE)
    @PreAuthorize("hasRole('ROLE_GRADJANIN')")
    public ResponseEntity<ZalbaProtivOdlukeCollection> getAllByUserId(Authentication authentication) {
        return new ResponseEntity<>(service.getAllByUserId(authentication), HttpStatus.OK);
    }
}
