package rs.ac.uns.ftn.portal_poverenika.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rs.ac.uns.ftn.portal_poverenika.db.ExistManager;
import rs.ac.uns.ftn.portal_poverenika.model.obavestenje.Obavestenje;

@Repository
public class ObavestenjeRepository {

    private static final String COLLECTION_URI = "db/poverenik/obavestenje";

    @Autowired
    private ExistManager existManager;

    public void create(Obavestenje obavestenje) throws Exception {
        existManager.store(COLLECTION_URI, obavestenje.getInformacijeOObavestenju().getId(), obavestenje);
    }

    public Obavestenje get(String documentId) {
        return existManager.get(COLLECTION_URI, documentId, Obavestenje.class);
    }
}
