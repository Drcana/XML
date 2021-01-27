package rs.ac.uns.ftn.portal_organa_vlasti.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rs.ac.uns.ftn.portal_organa_vlasti.db.ExistManager;
import rs.ac.uns.ftn.portal_organa_vlasti.model.zahtev.DokumentZahtev;
import rs.ac.uns.ftn.portal_organa_vlasti.model.zahtev.Zahtev;

import java.util.UUID;

@Repository
public class ZahtevRepository {

    private static final String COLLECTION_URI = "db/organ_vlasti/zahtev";

    @Autowired
    private ExistManager existManager;

    public void create(DokumentZahtev dokumentZahtev) throws Exception {
        existManager.store(COLLECTION_URI, UUID.randomUUID().toString(), dokumentZahtev);
    }

    public DokumentZahtev get(String documentId) {
        return existManager.get(COLLECTION_URI, documentId, Zahtev.class);
    }
}
