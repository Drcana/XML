package rs.ac.uns.ftn.email_service.config;


import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rs.ac.uns.ftn.email_service.soap.organ_vlasti.OrganVlastiEmailServiceImpl;

import javax.xml.ws.Endpoint;

@Configuration
public class EndpointConfig {

    @Bean
    public Endpoint endpoint(SpringBus springBus, OrganVlastiEmailServiceImpl organVlastiEmailService) {
        EndpointImpl endpoint = new EndpointImpl(springBus, organVlastiEmailService);
        endpoint.publish("/email/organ_vlasti");

        return endpoint;
    }
}
