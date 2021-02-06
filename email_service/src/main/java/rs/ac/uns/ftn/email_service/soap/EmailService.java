package rs.ac.uns.ftn.email_service.soap;


import rs.ac.uns.ftn.notification.Notification;
import rs.ac.uns.ftn.reject_notification.RejectNotification;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface EmailService {

    @WebMethod
    Boolean sendObavestenje(@WebParam(name = "obavestenjeNotification") Notification notification);

    @WebMethod
    Boolean rejectZahtev(@WebParam(name = "rejectNotification") RejectNotification rejectNotification);

    @WebMethod
    Boolean sendResenje(@WebParam(name = "resenjeNotification") Notification notification);

    @WebMethod
    Boolean sendZalba(@WebParam(name = "zalbaNotification") Notification notification);
}
