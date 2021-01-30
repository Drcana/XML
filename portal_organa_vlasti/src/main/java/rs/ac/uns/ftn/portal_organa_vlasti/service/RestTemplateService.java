package rs.ac.uns.ftn.portal_organa_vlasti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import rs.ac.uns.ftn.portal_organa_vlasti.dto.ObavestenjeEmailDto;
import rs.ac.uns.ftn.portal_organa_vlasti.dto.RejectZahtevDto;

@Component
class RestTemplateService {

    private static final String EMAIL_SERVICE_URL = "http://localhost:9000/api/email";

    @Autowired
    private RestTemplate restTemplate;

    String rejectZahtev(RejectZahtevDto rejectZahtevDto) {
        String url = String.format("%s/reject", EMAIL_SERVICE_URL);
        try {
            return restTemplate.postForObject(url, rejectZahtevDto, String.class);
        } catch (Exception ex) {
            return "Sending email has failed.";
        }
    }

    String sendResponseToUser(ObavestenjeEmailDto obavestenjeEmailDto) {
        String url = String.format("%s/obavestenje", EMAIL_SERVICE_URL);
        try {
            return restTemplate.postForObject(url, obavestenjeEmailDto, String.class);
        } catch (Exception ex) {
            return "Sending email has failed.";
        }
    }
}
