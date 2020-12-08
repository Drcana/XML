package ftn.unc.as.rs.xml.poc.jaxb.controller;

import ftn.unc.as.rs.xml.poc.jaxb.service.ZalbaProtivOdlukeService;
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
}