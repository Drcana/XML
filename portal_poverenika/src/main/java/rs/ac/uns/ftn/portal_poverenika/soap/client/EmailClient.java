package rs.ac.uns.ftn.portal_poverenika.soap.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import rs.ac.uns.ftn.portal_poverenika.soap.model.Notification;
import rs.ac.uns.ftn.portal_poverenika.soap.model.ObjectFactory;
import rs.ac.uns.ftn.portal_poverenika.soap.model.SendResenje;
import rs.ac.uns.ftn.portal_poverenika.soap.model.SendResenjeResponse;
import rs.ac.uns.ftn.portal_poverenika.soap.model.SendZalba;
import rs.ac.uns.ftn.portal_poverenika.soap.model.SendZalbaResponse;

import javax.xml.bind.JAXBElement;

public class EmailClient extends WebServiceGatewaySupport {

    private static final String EMAIL_SOAP_URL = "http://localhost:9000/services/email";

    public Boolean sendResenje(Notification notification) {
        SendResenje sendResenje = new SendResenje();
        sendResenje.setResenjeNotification(notification);

        JAXBElement<SendResenje> request = new ObjectFactory().createSendResenje(sendResenje);

        JAXBElement<SendResenjeResponse> responseJAXBElement = (JAXBElement<SendResenjeResponse>)
                getWebServiceTemplate().marshalSendAndReceive(EMAIL_SOAP_URL, request);

        return responseJAXBElement.getValue().isReturn();
    }

    public Boolean sendZalba(Notification notification) {
        SendZalba sendZalba = new SendZalba();
        sendZalba.setZalbaNotification(notification);

        JAXBElement<SendZalba> request = new ObjectFactory().createSendZalba(sendZalba);

        JAXBElement<SendZalbaResponse> responseJAXBElement = (JAXBElement<SendZalbaResponse>)
                getWebServiceTemplate().marshalSendAndReceive(EMAIL_SOAP_URL, request);

        return responseJAXBElement.getValue().isReturn();
    }
}
