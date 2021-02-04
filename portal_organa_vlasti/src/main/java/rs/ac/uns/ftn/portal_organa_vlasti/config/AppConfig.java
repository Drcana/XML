package rs.ac.uns.ftn.portal_organa_vlasti.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.client.RestTemplate;
import rs.ac.uns.ftn.portal_organa_vlasti.soap.client.EmailClient;

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
    public EmailClient notificationClient(Jaxb2Marshaller marshaller) {
        EmailClient client = new EmailClient();
        client.setDefaultUri("http://localhost:9000/services/email/organ_vlasti");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        return client;
    }

}
