package ftn.unc.as.rs.xml.poc.jaxb.repository;

import ftn.unc.as.rs.xml.poc.jaxb.db.ExistManager;
import ftn.unc.as.rs.xml.poc.jaxb.model.zalbaProtivCutanja.ZalbaProtivCutanja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
