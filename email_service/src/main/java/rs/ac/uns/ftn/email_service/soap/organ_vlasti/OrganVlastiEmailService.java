package rs.ac.uns.ftn.email_service.soap.organ_vlasti;


import rs.ac.uns.ftn.obavestenje_notification.ObavestenjeNotification;
import rs.ac.uns.ftn.reject_notification.RejectNotification;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface OrganVlastiEmailService {

    @WebMethod
    String sendObavestenje(@WebParam(name = "obavestenjeNotification") ObavestenjeNotification notification);

    @WebMethod
    String rejectZahtev(@WebParam(name = "rejectNotification") RejectNotification rejectNotification);
}
