package rs.ac.uns.ftn.portal_organa_vlasti.soap.zahtev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.portal_organa_vlasti.service.ZahtevService;
import rs.ac.uns.ftn.zahtev.DokumentZahtev;

import javax.jws.WebService;

@Service
@WebService(endpointInterface = "rs.ac.uns.ftn.portal_organa_vlasti.soap.zahtev.ZahtevSoapService")
public class ZahtevSoapServiceImpl implements ZahtevSoapService {

    @Autowired
    ZahtevService zahtevService;

    @Override
    public DokumentZahtev getZahtevById(String id) {
        return zahtevService.get(id);
    }
}
