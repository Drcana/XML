package rs.ac.uns.ftn.portal_organa_vlasti.repository;

import org.exist.xupdate.XUpdateProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rs.ac.uns.ftn.portal_organa_vlasti.db.ExistManager;
import rs.ac.uns.ftn.portal_organa_vlasti.dto.ZahtevCollection;
import rs.ac.uns.ftn.portal_organa_vlasti.service.JAXBService;
import rs.ac.uns.ftn.zahtev.DokumentZahtev;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ZahtevRepository {

    private static final String COLLECTION_URI = "db/organ_vlasti/zahtev";

    private static final String TARGET_NAMESPACE = "http://www.ftn.uns.ac.rs/zahtev";

    private static final String TARGET_NAMESPACE_PREFIX = "zah";

    private static final String UPDATE = "<xu:modifications version=\"1.0\" xmlns:xu=\"" + XUpdateProcessor.XUPDATE_NS
            + "\" xmlns=\"" + TARGET_NAMESPACE + "\">" + "<xu:update select=\"%1$s\">%2$s</xu:update>"
            + "</xu:modifications>";

    private static final String APPEND = "<xu:modifications version=\"1.0\" xmlns:xu=\"" + XUpdateProcessor.XUPDATE_NS
            + "\" xmlns=\"" + TARGET_NAMESPACE + "\">" + "<xu:append select=\"%1$s\" child=\"last()\">%2$s</xu:append>"
            + "</xu:modifications>";

    @Autowired
    private ExistManager existManager;

    @Autowired
    private JAXBService jaxbService;

    public void create(DokumentZahtev dokumentZahtev) throws Exception {
        existManager.store(COLLECTION_URI, dokumentZahtev.getId(), dokumentZahtev);
    }

    public DokumentZahtev get(String documentId) {
        return existManager.get(COLLECTION_URI, documentId, DokumentZahtev.class);
    }

    public ZahtevCollection getAll() {
        List<DokumentZahtev> list = new ArrayList<>();

        try {
            list = existManager.getList(COLLECTION_URI, "/", TARGET_NAMESPACE, DokumentZahtev.class);

            return new ZahtevCollection(list);
        } catch (Exception e) {
            return new ZahtevCollection(list);
        }
    }

    public boolean delete(String documentId) throws Exception {
        return existManager.remove(COLLECTION_URI, documentId);
    }

    public ZahtevCollection getAllByUserId(String emailOfLoggedUser) {
        List<DokumentZahtev> list = new ArrayList<>();
        String xPath = "/dokument_zahtev[@userId=\"" + emailOfLoggedUser + "\"]";

        try {
            list = existManager.getList(COLLECTION_URI, xPath, TARGET_NAMESPACE, DokumentZahtev.class);

            return new ZahtevCollection(list);
        } catch (Exception e) {
            return new ZahtevCollection(list);
        }
    }

    public ZahtevCollection searchAll(String term) {
        List<DokumentZahtev> list = new ArrayList<>();
        String xPath = "/zah:dokument_zahtev[zah:organ_vlasti[contains(types:naziv_organa, '" + term + "')]" +
                " or zah:organ_vlasti/types:adresa/types:mesto[contains(.,'" + term + "')]" +
                " or zah:organ_vlasti/types:adresa/types:ulica[contains(.,'" + term + "')]" +
                " or zah:mesto_i_datum/types:mesto[contains(.,'" + term + "')]" +
                " or zah:mesto_i_datum/types:datum[contains(.,'" + term + "')]" +
                " or zah:podnosilac_zahteva/types:ime[contains(.,'" + term + "')]" +
                " or zah:podnosilac_zahteva/types:prezime[contains(.,'" + term + "')]" +
                " or zah:podnosilac_zahteva/types:adresa/types:mesto[contains(.,'" + term + "')]" +
                " or zah:podnosilac_zahteva/types:adresa/types:ulica[contains(.,'" + term + "')]" +
                " or zah:podnosilac_zahteva/types:drugi_podaci_za_kontakt[contains(.,'" + term + "')]" + "]";
        try {
            list = existManager.getListWithNamespace(COLLECTION_URI, xPath, TARGET_NAMESPACE, TARGET_NAMESPACE_PREFIX, DokumentZahtev.class);

            return new ZahtevCollection(list);
        } catch (Exception e) {
            return new ZahtevCollection(list);
        }
    }
}
