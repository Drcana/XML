package rs.ac.uns.ftn.portal_poverenika.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rs.ac.uns.ftn.portal_poverenika.db.ExistManager;
import rs.ac.uns.ftn.portal_poverenika.model.zahtev.DokumentZahtev;
import rs.ac.uns.ftn.portal_poverenika.model.zahtev.Zahtev;

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
