package ftn.unc.as.rs.xml.poc.jaxb.controller;

import ftn.unc.as.rs.xml.poc.jaxb.service.ObavestenjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import java.io.IOException;

@Controller
@RequestMapping("/api/obavestenje")
public class ObavestenjeController {

    @Autowired
    private ObavestenjeService service;

    @GetMapping
    public ResponseEntity<String> parseXmlObavestenje() throws JAXBException {
        return new ResponseEntity<>(service.parseXmlObavestenje(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void writeXmlObavestenje(final HttpServletResponse response) throws JAXBException, IOException {
        service.writeXmlObavestenje(response);
    }
}
