package rs.ac.uns.ftn.portal_poverenika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.uns.ftn.portal_poverenika.dto.DocumentDto;
import rs.ac.uns.ftn.portal_poverenika.dto.ResenjeCollection;
import rs.ac.uns.ftn.portal_poverenika.model.resenje.Resenje;
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

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    @PreAuthorize("hasRole('ROLE_GRADJANIN')")
    public ResponseEntity<DocumentDto> create(@RequestBody Resenje resenje, Authentication authentication) throws Exception {
        return new ResponseEntity<>(service.create(resenje, authentication), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    @PreAuthorize("hasRole('ROLE_GRADJANIN')")
    public ResponseEntity<Resenje> get(@PathVariable("id") String documentId) {
        return new ResponseEntity<>(service.get(documentId), HttpStatus.OK);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_XML_VALUE)
    @PreAuthorize("hasRole('ROLE_POVERENIK')")
    public ResponseEntity<ResenjeCollection> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/all/userId", produces = MediaType.APPLICATION_XML_VALUE)
    @PreAuthorize("hasRole('ROLE_GRADJANIN')")
    public ResponseEntity<ResenjeCollection> getAllByUserId(Authentication authentication) {
        return new ResponseEntity<>(service.getAllByUserId(authentication), HttpStatus.OK);
    }
}
