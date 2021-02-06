package rs.ac.uns.ftn.email_service.config;


import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rs.ac.uns.ftn.email_service.soap.EmailServiceImpl;

import javax.xml.ws.Endpoint;

@Configuration
public class EndpointConfig {

    @Bean
    public Endpoint endpoint(SpringBus springBus, EmailServiceImpl emailService) {
        EndpointImpl endpoint = new EndpointImpl(springBus, emailService);
        endpoint.publish("/email");

        return endpoint;
    }
}
