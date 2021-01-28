package rs.ac.uns.ftn.portal_poverenika.repository;

import org.exist.xupdate.XUpdateProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rs.ac.uns.ftn.portal_poverenika.db.ExistManager;
import rs.ac.uns.ftn.portal_poverenika.dto.ZalbaProtivCutanjaCollection;
import rs.ac.uns.ftn.portal_poverenika.model.zalba_protiv_cutanja.ZalbaProtivCutanja;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ZalbaProtivCutanjaRepository {

    private static final String COLLECTION_URI = "db/poverenik/zalba-protiv-cutanja";

    private static final String TARGET_NAMESPACE = "http://ftn.uns.ac.rs/zalba_protiv_cutanja";

    private static final String UPDATE = "<xu:modifications version=\"1.0\" xmlns:xu=\"" + XUpdateProcessor.XUPDATE_NS
            + "\" xmlns=\"" + TARGET_NAMESPACE + "\">" + "<xu:update select=\"%1$s\">%2$s</xu:update>"
            + "</xu:modifications>";

    private static final String APPEND = "<xu:modifications version=\"1.0\" xmlns:xu=\"" + XUpdateProcessor.XUPDATE_NS
            + "\" xmlns=\"" + TARGET_NAMESPACE + "\">" + "<xu:append select=\"%1$s\" child=\"last()\">%2$s</xu:append>"
            + "</xu:modifications>";


    @Autowired
    private ExistManager existManager;

    public void create(ZalbaProtivCutanja zalbaProtivCutanja) throws Exception {
        existManager.store(COLLECTION_URI, zalbaProtivCutanja.getId(), zalbaProtivCutanja);
    }

    public ZalbaProtivCutanja get(String documentId) {
        return existManager.get(COLLECTION_URI, documentId, ZalbaProtivCutanja.class);
    }


    public ZalbaProtivCutanjaCollection getAll() {
        List<ZalbaProtivCutanja> list = new ArrayList<>();

        try {
            list = existManager.getList(COLLECTION_URI, "/", TARGET_NAMESPACE, ZalbaProtivCutanja.class);

            return new ZalbaProtivCutanjaCollection(list);
        } catch (Exception e) {
            return new ZalbaProtivCutanjaCollection(list);
        }
    }

    public ZalbaProtivCutanjaCollection getAllByUserId(String emailOfLoggedUser) {
        List<ZalbaProtivCutanja> list = new ArrayList<>();
//        String xPath = "/zalba_protiv_cutanja[@userId=\"" + emailOfLoggedUser + "\"]";
        String xPath = "/zalba_protiv_cutanja[@userId=\"" + emailOfLoggedUser + "\"]";

        try {
            list = existManager.getList(COLLECTION_URI, xPath, TARGET_NAMESPACE, ZalbaProtivCutanja.class);

            return new ZalbaProtivCutanjaCollection(list);
        } catch (Exception e) {
            return new ZalbaProtivCutanjaCollection(list);
        }
    }
}
