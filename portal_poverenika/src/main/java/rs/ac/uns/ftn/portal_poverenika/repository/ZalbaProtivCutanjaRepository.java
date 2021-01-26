package rs.ac.uns.ftn.portal_poverenika.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rs.ac.uns.ftn.portal_poverenika.db.ExistManager;
import rs.ac.uns.ftn.portal_poverenika.model.zalbaProtivCutanja.ZalbaProtivCutanja;

@Repository
public class ZalbaProtivCutanjaRepository {

    private static final String COLLECTION_URI = "db/poverenik/zalba-protiv-cutanja";

    @Autowired
    private ExistManager existManager;

    public void create(ZalbaProtivCutanja zalbaProtivCutanja) throws Exception {
        existManager.store(COLLECTION_URI, "2", zalbaProtivCutanja);
    }

    public ZalbaProtivCutanja get(String documentId) {
        return existManager.get(COLLECTION_URI, documentId, ZalbaProtivCutanja.class);
    }
}
