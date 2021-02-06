package rs.ac.uns.ftn.portal_organa_vlasti.controller;

import org.exist.http.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import rs.ac.uns.ftn.portal_organa_vlasti.dto.DocumentDto;
import rs.ac.uns.ftn.portal_organa_vlasti.dto.SearchZahtevMap;
import rs.ac.uns.ftn.portal_organa_vlasti.dto.WrapperResponse;
import rs.ac.uns.ftn.portal_organa_vlasti.dto.ZahtevCollection;
import rs.ac.uns.ftn.portal_organa_vlasti.service.ZahtevService;
import rs.ac.uns.ftn.zahtev.DokumentZahtev;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Base64;

@Controller
@RequestMapping("/api/zahtev")
public class ZahtevController {

    @Autowired
    private ZahtevService service;

    @GetMapping(value = "/parse/string", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> parseXmlZahtevToString() throws JAXBException {
        return new ResponseEntity<>(service.parseXmlZahtevToString(), HttpStatus.OK);
    }

    @GetMapping(value = "/parse/object", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<DokumentZahtev> parseXmlZahtevToObject() throws JAXBException {
        return new ResponseEntity<>(service.parseXmlZahtevToObject(), HttpStatus.OK);
    }

    @PostMapping("/write")
    @ResponseStatus(HttpStatus.OK)
    public void writeXmlZahtev(final HttpServletResponse response) throws JAXBException {
        service.writeXmlZahtev(response);
    }

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    @PreAuthorize("hasRole('ROLE_GRADJANIN')")
    public ResponseEntity<DocumentDto> create(@RequestBody DokumentZahtev dokumentZahtev, Authentication authentication) throws Exception {
        return new ResponseEntity<>(service.create(dokumentZahtev, authentication), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    @PreAuthorize("hasRole('ROLE_GRADJANIN')")
    public ResponseEntity<DokumentZahtev> get(@PathVariable("id") String documentId) {
        return new ResponseEntity<>(service.get(documentId), HttpStatus.OK);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_XML_VALUE)
    @PreAuthorize("hasRole('ROLE_SLUZBENIK')")
    public ResponseEntity<ZahtevCollection> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/all/userId", produces = MediaType.APPLICATION_XML_VALUE)
    @PreAuthorize("hasRole('ROLE_GRADJANIN')")
    public ResponseEntity<ZahtevCollection> getAllByUserId(Authentication authentication) {
        return new ResponseEntity<>(service.getAllByUserId(authentication), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    @PreAuthorize("hasRole('ROLE_GRADJANIN')")
    public ResponseEntity<WrapperResponse<Boolean>> delete(@PathVariable("id") String documentId) throws Exception {
        return new ResponseEntity<>(service.delete(documentId), HttpStatus.OK);
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

    @PostMapping(value = "/reject/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    @PreAuthorize("hasRole('ROLE_SLUZBENIK')")
    public ResponseEntity<WrapperResponse<Boolean>> reject(@PathVariable("id") String documentId,
                                                           Authentication authentication) throws NotFoundException {

        return new ResponseEntity<>(service.reject(documentId, authentication), HttpStatus.OK);
    }

    @GetMapping(value = "/search/{term}", produces = MediaType.APPLICATION_XML_VALUE)
    @PreAuthorize("hasRole('ROLE_SLUZBENIK')")
    public ResponseEntity<ZahtevCollection> searchAll(@PathVariable("term") String term) {
        return new ResponseEntity<>(service.searchAll(term), HttpStatus.OK);
    }

    @PostMapping(value = "/advancedSearch", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    @PreAuthorize("hasRole('ROLE_SLUZBENIK')")
    public ResponseEntity<ZahtevCollection> advancedSearch(@RequestBody SearchZahtevMap searchMap) throws IOException {
        return new ResponseEntity<>(service.advancedSearch(searchMap), HttpStatus.OK);
    }

    @GetMapping(value = "/export/rdf/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    @PreAuthorize("hasRole('ROLE_SLUZBENIK')")
    public ResponseEntity<byte[]> exportAsRdf(@PathVariable("id") String id) throws IOException {
        return new ResponseEntity<>(service.exportAsRdf(id), HttpStatus.OK);
    }
}
