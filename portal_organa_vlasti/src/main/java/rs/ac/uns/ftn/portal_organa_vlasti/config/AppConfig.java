package rs.ac.uns.ftn.portal_organa_vlasti.config;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.client.RestTemplate;
import rs.ac.uns.ftn.portal_organa_vlasti.soap.client.EmailClient;
import rs.ac.uns.ftn.portal_organa_vlasti.soap.zahtev.ZahtevSoapServiceImpl;

import javax.xml.ws.Endpoint;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("rs.ac.uns.ftn.portal_organa_vlasti.soap.model");

        return marshaller;
    }

    @Bean
    public EmailClient emailClient(Jaxb2Marshaller marshaller) {
        EmailClient client = new EmailClient();
        client.setDefaultUri("http://localhost:9000/services/email/organ_vlasti");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        return client;
    }

    @Bean
    public Endpoint endPoint(SpringBus springBus, ZahtevSoapServiceImpl zahtevSoapService){

        Endpoint endPoint = new EndpointImpl(springBus, zahtevSoapService);
        endPoint.publish("/zahtev");

        return endPoint;
    }

}
