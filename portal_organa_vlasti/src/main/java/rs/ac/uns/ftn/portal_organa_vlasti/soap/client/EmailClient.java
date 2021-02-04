package rs.ac.uns.ftn.portal_organa_vlasti.soap.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import rs.ac.uns.ftn.portal_organa_vlasti.soap.model.ObavestenjeNotification;
import rs.ac.uns.ftn.portal_organa_vlasti.soap.model.ObjectFactory;
import rs.ac.uns.ftn.portal_organa_vlasti.soap.model.RejectNotification;
import rs.ac.uns.ftn.portal_organa_vlasti.soap.model.RejectZahtev;
import rs.ac.uns.ftn.portal_organa_vlasti.soap.model.RejectZahtevResponse;
import rs.ac.uns.ftn.portal_organa_vlasti.soap.model.SendObavestenje;
import rs.ac.uns.ftn.portal_organa_vlasti.soap.model.SendObavestenjeResponse;

import javax.xml.bind.JAXBElement;

public class EmailClient extends WebServiceGatewaySupport {

    private static final String EMAIL_SOAP_URL = "http://localhost:9000/services/email/organ_vlasti";

    public String sendObavestenje(ObavestenjeNotification obavestenjeNotification) {

        SendObavestenje sendObavestenje = new SendObavestenje();
        sendObavestenje.setObavestenjeNotification(obavestenjeNotification);

        JAXBElement<SendObavestenje> request = new ObjectFactory().createSendObavestenje(sendObavestenje);

        JAXBElement<SendObavestenjeResponse> response = (JAXBElement<SendObavestenjeResponse>)
                getWebServiceTemplate().marshalSendAndReceive(EMAIL_SOAP_URL, request);

        return response.getValue().getReturn();
    }

    public String rejectZahtev(RejectNotification rejectNotification) {
        RejectZahtev rejectZahtev = new RejectZahtev();
        rejectZahtev.setRejectNotification(rejectNotification);

        JAXBElement<RejectZahtev> request = new ObjectFactory().createRejectZahtev(rejectZahtev);

        JAXBElement<RejectZahtevResponse> response = (JAXBElement<RejectZahtevResponse>)
                getWebServiceTemplate().marshalSendAndReceive(EMAIL_SOAP_URL, request);

        return response.getValue().getReturn();
    }
}
