package rs.ac.uns.ftn.portal_poverenika.controller;

import org.exist.http.NotFoundException;
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
import rs.ac.uns.ftn.portal_poverenika.dto.NotificationEmailDto;
import rs.ac.uns.ftn.portal_poverenika.dto.ResenjeCollection;
import rs.ac.uns.ftn.portal_poverenika.dto.WrapperResponse;
import rs.ac.uns.ftn.portal_poverenika.model.resenje.Resenje;
import rs.ac.uns.ftn.portal_poverenika.service.ResenjeService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

@RestController
@RequestMapping("/api/resenje")
public class ResenjeController {

    @Autowired
    private ResenjeService service;

    @GetMapping
    public ResponseEntity<String> parseXmlResenje() {
        return new ResponseEntity<>(service.parseXmlResenje(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void writeXmlResenje(final HttpServletResponse response) throws IOException {
        service.writeXmlResenje(response);
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


    @GetMapping("/generate/html/{id}")
    @PreAuthorize("hasRole('ROLE_GRADJANIN')")
    public ResponseEntity<byte[]> generateHTML(@PathVariable("id") String documentId) {
        return new ResponseEntity<>(service.generateHTML(documentId), HttpStatus.OK);
    }

    @GetMapping("/generate/pdf/{id}")
    @PreAuthorize("hasRole('ROLE_GRADJANIN')")
    public ResponseEntity<byte[]> generatePDF(@PathVariable("id") String documentId) {
        return new ResponseEntity<>(Base64.getEncoder().encode(service.generatePDF(documentId)), HttpStatus.OK);
    }

    @PostMapping(value = "/sendResenje", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    @PreAuthorize("hasRole('ROLE_POVERENIK')")
    public ResponseEntity<WrapperResponse<Boolean>> sendResenjeToUser(
            @RequestBody NotificationEmailDto notificationEmailDto, Authentication authentication) throws NotFoundException {

        return new ResponseEntity<>(service.sendResenjeToUser(notificationEmailDto, authentication), HttpStatus.OK);
    }
}
