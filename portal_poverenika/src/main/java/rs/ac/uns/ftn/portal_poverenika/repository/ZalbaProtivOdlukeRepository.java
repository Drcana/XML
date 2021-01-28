package rs.ac.uns.ftn.portal_poverenika.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rs.ac.uns.ftn.portal_poverenika.db.ExistManager;
import rs.ac.uns.ftn.portal_poverenika.dto.ZalbaProtivOdlukeCollection;
import rs.ac.uns.ftn.portal_poverenika.model.zalba_protiv_odluke.ZalbaProtivOdluke;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ZalbaProtivOdlukeRepository {

    private static final String COLLECTION_URI = "db/poverenik/zalba-protiv-odluke";

    private static final String TARGET_NAMESPACE = "http://www.ftn.uns.ac.rs/zalba_protiv_odluke";

    @Autowired
    private ExistManager existManager;

    public void create(ZalbaProtivOdluke zalbaProtivOdluke) throws Exception {
        existManager.store(COLLECTION_URI, zalbaProtivOdluke.getId(), zalbaProtivOdluke);
    }

    public ZalbaProtivOdluke get(String documentId) {
        return existManager.get(COLLECTION_URI, documentId, ZalbaProtivOdluke.class);
    }

    public ZalbaProtivOdlukeCollection getAll() {
        List<ZalbaProtivOdluke> list = new ArrayList<>();

        try {
            list = existManager.getList(COLLECTION_URI, "/", TARGET_NAMESPACE, ZalbaProtivOdluke.class);

            return new ZalbaProtivOdlukeCollection(list);
        } catch (Exception e) {
            return new ZalbaProtivOdlukeCollection(list);
        }
    }

    public ZalbaProtivOdlukeCollection getAllByUserId(String emailOfLoggedUser) {
        List<ZalbaProtivOdluke> list = new ArrayList<>();
        String xPath = "/zalba_protiv_odluke[@userId=\"" + emailOfLoggedUser + "\"]";

        try {
            list = existManager.getList(COLLECTION_URI, xPath, TARGET_NAMESPACE, ZalbaProtivOdluke.class);

            return new ZalbaProtivOdlukeCollection(list);
        } catch (Exception e) {
            return new ZalbaProtivOdlukeCollection(list);
        }
    }
}
