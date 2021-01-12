package ftn.unc.as.rs.xml.poc.jaxb.repository;

import ftn.unc.as.rs.xml.poc.jaxb.db.ExistManager;
import ftn.unc.as.rs.xml.poc.jaxb.model.zahtev.DokumentZahtev;
import ftn.unc.as.rs.xml.poc.jaxb.model.zahtev.Zahtev;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ZahtevRepository {

    private static final String COLLECTION_URI = "db/poverenik/zahtev";

    @Autowired
    private ExistManager existManager;

    public void create(DokumentZahtev dokumentZahtev) throws Exception {
        existManager.store(COLLECTION_URI, "2", dokumentZahtev);
    }

    public DokumentZahtev get(String documentId) {
        return existManager.get(COLLECTION_URI, documentId, Zahtev.class);
    }
}
