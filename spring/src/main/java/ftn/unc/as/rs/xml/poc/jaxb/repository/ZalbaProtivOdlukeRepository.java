package ftn.unc.as.rs.xml.poc.jaxb.repository;

import ftn.unc.as.rs.xml.poc.jaxb.db.ExistManager;
import ftn.unc.as.rs.xml.poc.jaxb.model.zalbaProtivOdluke.ZalbaProtivOdluke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ZalbaProtivOdlukeRepository {

    private static final String COLLECTION_URI = "db/poverenik/zalba-protiv-odluke";

    @Autowired
    private ExistManager existManager;

    public void create(ZalbaProtivOdluke zalbaProtivOdluke) throws Exception {
        existManager.store(COLLECTION_URI, "1", zalbaProtivOdluke);
    }

    public ZalbaProtivOdluke get(String documentId) {
        return existManager.get(COLLECTION_URI, documentId, ZalbaProtivOdluke.class);
    }
}
