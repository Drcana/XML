package rs.ac.uns.ftn.portal_poverenika.repository;

import org.exist.xupdate.XUpdateProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rs.ac.uns.ftn.portal_poverenika.db.ExistManager;
import rs.ac.uns.ftn.portal_poverenika.dto.ResenjeCollection;
import rs.ac.uns.ftn.portal_poverenika.model.resenje.Resenje;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ResenjeRepository {

    private static final String COLLECTION_URI = "db/poverenik/resenje";

    private static final String TARGET_NAMESPACE = "http://ftn.uns.ac.rs/resenje";

    private static final String UPDATE = "<xu:modifications version=\"1.0\" xmlns:xu=\"" + XUpdateProcessor.XUPDATE_NS
            + "\" xmlns=\"" + TARGET_NAMESPACE + "\">" + "<xu:update select=\"%1$s\">%2$s</xu:update>"
            + "</xu:modifications>";

    private static final String APPEND = "<xu:modifications version=\"1.0\" xmlns:xu=\"" + XUpdateProcessor.XUPDATE_NS
            + "\" xmlns=\"" + TARGET_NAMESPACE + "\">" + "<xu:append select=\"%1$s\" child=\"last()\">%2$s</xu:append>"
            + "</xu:modifications>";


    @Autowired
    private ExistManager existManager;

    public void create(Resenje resenje) throws Exception {
        existManager.store(COLLECTION_URI, resenje.getId(), resenje);
    }

    public Resenje get(String documentId) {
        return existManager.get(COLLECTION_URI, documentId, Resenje.class);
    }


    public ResenjeCollection getAll() {
        List<Resenje> list = new ArrayList<>();

        try {
            list = existManager.getList(COLLECTION_URI, "/", TARGET_NAMESPACE, Resenje.class);

            return new ResenjeCollection(list);
        } catch (Exception e) {
            return new ResenjeCollection(list);
        }
    }

    public ResenjeCollection getAllByUserId(String emailOfLoggedUser) {
        List<Resenje> list = new ArrayList<>();
        String xPath = "/resenje[@userId=\"" + emailOfLoggedUser + "\"]";

        try {
            list = existManager.getList(COLLECTION_URI, xPath, TARGET_NAMESPACE, Resenje.class);

            return new ResenjeCollection(list);
        } catch (Exception e) {
            return new ResenjeCollection(list);
        }
    }
}
