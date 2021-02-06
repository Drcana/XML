package rs.ac.uns.ftn.portal_poverenika.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import rs.ac.uns.ftn.portal_poverenika.soap.client.EmailClient;
import rs.ac.uns.ftn.portal_poverenika.soap.client.OrganVlastiClient;

@Configuration
public class AppConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("rs.ac.uns.ftn.portal_poverenika.soap.model.email");

        return marshaller;
    }

    @Bean
    public OrganVlastiClient organVlastiClient() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("rs.ac.uns.ftn.portal_poverenika.soap.model.zahtev");

        OrganVlastiClient client = new OrganVlastiClient();
        client.setDefaultUri("http://localhost:9001/services/zahtev");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        return client;
    }


    @Bean
    public EmailClient emailClient(Jaxb2Marshaller marshaller) {
        EmailClient client = new EmailClient();
        client.setDefaultUri("http://localhost:9000/services/email");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        return client;
    }
}
