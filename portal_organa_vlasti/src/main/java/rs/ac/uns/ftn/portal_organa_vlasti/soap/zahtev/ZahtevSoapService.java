package rs.ac.uns.ftn.portal_organa_vlasti.soap.zahtev;


import rs.ac.uns.ftn.zahtev.DokumentZahtev;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ZahtevSoapService {

    @WebMethod
    DokumentZahtev getZahtevById(String id);
}
