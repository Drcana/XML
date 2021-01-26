package rs.ac.uns.ftn.portal_poverenika.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rs.ac.uns.ftn.portal_poverenika.db.ExistManager;
import rs.ac.uns.ftn.portal_poverenika.model.zalbaProtivOdluke.ZalbaProtivOdluke;

@Repository
public class ZalbaProtivOdlukeRepository {

    private static final String COLLECTION_URI = "db/poverenik/zalba-protiv-odluke";

    @Autowired
    private ExistManager existManager;

    public void create(ZalbaProtivOdluke zalbaProtivOdluke) throws Exception {
        existManager.store(COLLECTION_URI, zalbaProtivOdluke.getId().getValue(), zalbaProtivOdluke);
    }

    public ZalbaProtivOdluke get(String documentId) {
        return existManager.get(COLLECTION_URI, documentId, ZalbaProtivOdluke.class);
    }
}
