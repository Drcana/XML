package rs.ac.uns.ftn.portal_organa_vlasti.soap.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import rs.ac.uns.ftn.portal_organa_vlasti.soap.model.Notification;
import rs.ac.uns.ftn.portal_organa_vlasti.soap.model.ObjectFactory;
import rs.ac.uns.ftn.portal_organa_vlasti.soap.model.RejectNotification;
import rs.ac.uns.ftn.portal_organa_vlasti.soap.model.RejectZahtev;
import rs.ac.uns.ftn.portal_organa_vlasti.soap.model.RejectZahtevResponse;
import rs.ac.uns.ftn.portal_organa_vlasti.soap.model.SendObavestenje;
import rs.ac.uns.ftn.portal_organa_vlasti.soap.model.SendObavestenjeResponse;

import javax.xml.bind.JAXBElement;

public class EmailClient extends WebServiceGatewaySupport {

    private static final String EMAIL_SOAP_URL = "http://localhost:9000/services/email";

    public Boolean sendObavestenje(Notification notification) {

        SendObavestenje sendObavestenje = new SendObavestenje();
        sendObavestenje.setObavestenjeNotification(notification);

        JAXBElement<SendObavestenje> request = new ObjectFactory().createSendObavestenje(sendObavestenje);

        JAXBElement<SendObavestenjeResponse> response = (JAXBElement<SendObavestenjeResponse>)
                getWebServiceTemplate().marshalSendAndReceive(EMAIL_SOAP_URL, request);

        return response.getValue().isReturn();
    }

    public Boolean rejectZahtev(RejectNotification rejectNotification) {
        RejectZahtev rejectZahtev = new RejectZahtev();
        rejectZahtev.setRejectNotification(rejectNotification);

        JAXBElement<RejectZahtev> request = new ObjectFactory().createRejectZahtev(rejectZahtev);

        JAXBElement<RejectZahtevResponse> response = (JAXBElement<RejectZahtevResponse>)
                getWebServiceTemplate().marshalSendAndReceive(EMAIL_SOAP_URL, request);

        return response.getValue().isReturn();
    }
}
