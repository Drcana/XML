package ftn.unc.as.rs.xml.poc.jaxb.repository;

import ftn.unc.as.rs.xml.poc.jaxb.db.ExistManager;
import ftn.unc.as.rs.xml.poc.jaxb.model.obavestenje.Obavestenje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ObavestenjeRepository {

    private static final String COLLECTION_URI = "db/poverenik/obavestenje";

    @Autowired
    private ExistManager existManager;

    public void create(Obavestenje obavestenje) throws Exception {
        existManager.store(COLLECTION_URI, "1", obavestenje);
    }

    public Obavestenje get(String documentId) {
        return existManager.get(COLLECTION_URI, documentId, Obavestenje.class);
    }
}
