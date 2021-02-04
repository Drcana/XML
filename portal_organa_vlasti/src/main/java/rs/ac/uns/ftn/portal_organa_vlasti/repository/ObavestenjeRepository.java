package rs.ac.uns.ftn.portal_organa_vlasti.repository;

import org.exist.xupdate.XUpdateProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rs.ac.uns.ftn.portal_organa_vlasti.db.ExistManager;
import rs.ac.uns.ftn.portal_organa_vlasti.dto.ObavestenjeCollection;
import rs.ac.uns.ftn.portal_organa_vlasti.model.obavestenje.Obavestenje;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ObavestenjeRepository {

    private static final String COLLECTION_URI = "db/organ_vlasti/obavestenje";

    private static final String TARGET_NAMESPACE = "http://www.ftn.uns.ac.rs/obavestenje";

    private static final String UPDATE = "<xu:modifications version=\"1.0\" xmlns:xu=\"" + XUpdateProcessor.XUPDATE_NS
            + "\" xmlns=\"" + TARGET_NAMESPACE + "\">" + "<xu:update select=\"%1$s\">%2$s</xu:update>"
            + "</xu:modifications>";

    private static final String APPEND = "<xu:modifications version=\"1.0\" xmlns:xu=\"" + XUpdateProcessor.XUPDATE_NS
            + "\" xmlns=\"" + TARGET_NAMESPACE + "\">" + "<xu:append select=\"%1$s\" child=\"last()\">%2$s</xu:append>"
            + "</xu:modifications>";

    @Autowired
    private ExistManager existManager;

    public void create(Obavestenje obavestenje) throws Exception {
        existManager.store(COLLECTION_URI, obavestenje.getId(), obavestenje);
    }

    public Obavestenje get(String documentId) {
        return existManager.get(COLLECTION_URI, documentId, Obavestenje.class);
    }

    public ObavestenjeCollection getAll() {
        List<Obavestenje> list = new ArrayList<>();

        try {
            list = existManager.getList(COLLECTION_URI, "/", TARGET_NAMESPACE, Obavestenje.class);

            return new ObavestenjeCollection(list);
        } catch (Exception e) {
            return new ObavestenjeCollection(list);
        }
    }

    public ObavestenjeCollection getAllByUserId(String emailOfLoggedUser) {
        List<Obavestenje> list = new ArrayList<>();
        String xPath = "/obavestenje[@userId=\"" + emailOfLoggedUser + "\"]";

        try {
            list = existManager.getList(COLLECTION_URI, xPath, TARGET_NAMESPACE, Obavestenje.class);

            return new ObavestenjeCollection(list);
        } catch (Exception e) {
            return new ObavestenjeCollection(list);
        }
    }

    public boolean delete(String documentId) throws Exception {
        return existManager.remove(COLLECTION_URI, documentId);
    }
}
