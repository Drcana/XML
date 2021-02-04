package rs.ac.uns.ftn.email_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import rs.ac.uns.ftn.email_service.dto.ObavestenjeNotificationDto;
import rs.ac.uns.ftn.email_service.dto.RejectZahtevDto;
import rs.ac.uns.ftn.email_service.service.EmailServiceOld;

@Controller
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailServiceOld emailServiceOld;

    @PostMapping(value = "/obavestenje", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> sendObavestenje(@RequestBody ObavestenjeNotificationDto obavestenjeNotificationDto) {
        return new ResponseEntity<>(emailServiceOld.sendObavestenje(obavestenjeNotificationDto), HttpStatus.OK);
    }

    @PostMapping(value = "/reject", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> rejectZahtev(@RequestBody RejectZahtevDto rejectZahtevDto) {
        return new ResponseEntity<>(emailServiceOld.rejectZahtev(rejectZahtevDto), HttpStatus.OK);
    }
}
