package rs.ac.uns.ftn.portal_organa_vlasti.controller;

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
import rs.ac.uns.ftn.portal_organa_vlasti.dto.DocumentDto;
import rs.ac.uns.ftn.portal_organa_vlasti.dto.ObavestenjeCollection;
import rs.ac.uns.ftn.portal_organa_vlasti.dto.ObavestenjeNotificationDto;
import rs.ac.uns.ftn.portal_organa_vlasti.model.obavestenje.Obavestenje;
import rs.ac.uns.ftn.portal_organa_vlasti.service.ObavestenjeService;
import rs.ac.uns.ftn.portal_organa_vlasti.soap.client.EmailClient;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

@Controller
@RequestMapping("/api/obavestenje")
public class ObavestenjeController {

    @Autowired
    private ObavestenjeService service;

    @Autowired
    private EmailClient emailClient;

    @GetMapping("/parse")
    public ResponseEntity<String> parseXmlObavestenje() throws JAXBException {
        return new ResponseEntity<>(service.parseXmlObavestenje(), HttpStatus.OK);
    }

    @PostMapping("/write")
    @ResponseStatus(HttpStatus.OK)
    public void writeXmlObavestenje(final HttpServletResponse response) throws JAXBException {
        service.writeXmlObavestenje(response);
    }

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<DocumentDto> create(@RequestBody Obavestenje obavestenje, Authentication authentication) throws Exception {
        return new ResponseEntity<>(service.create(obavestenje, authentication), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Obavestenje> get(@PathVariable("id") String documentId) {
        return new ResponseEntity<>(service.get(documentId), HttpStatus.OK);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_XML_VALUE)
    @PreAuthorize("hasRole('ROLE_SLUZBENIK')")
    public ResponseEntity<ObavestenjeCollection> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/all/userId", produces = MediaType.APPLICATION_XML_VALUE)
    @PreAuthorize("hasRole('ROLE_GRADJANIN')")
    public ResponseEntity<ObavestenjeCollection> getAllByUserId(Authentication authentication) {
        return new ResponseEntity<>(service.getAllByUserId(authentication), HttpStatus.OK);
    }

    @GetMapping("/generate/html/{id}")
    @PreAuthorize("hasRole('ROLE_GRADJANIN')")
    public ResponseEntity<byte[]> generateHTML(@PathVariable("id") String documentId) {
        return new ResponseEntity<>(service.generateHTML(documentId), HttpStatus.OK);
    }

    @GetMapping("/generate/pdf/{id}")
    @PreAuthorize("hasRole('ROLE_GRADJANIN')")
    public ResponseEntity<byte[]> generatePDF(@PathVariable("id") String documentId) {
        return new ResponseEntity<>(service.generatePDF(documentId), HttpStatus.OK);
    }

    @PostMapping(value = "/sendResponse", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    @PreAuthorize("hasRole('ROLE_SLUZBENIK')")
    public ResponseEntity<String> sendResponseToUser(
            @RequestBody ObavestenjeNotificationDto obavestenjeNotificationDto, Authentication authentication) {

        return new ResponseEntity<>(service.sendResponseToUser(obavestenjeNotificationDto, authentication), HttpStatus.OK);
    }
}
