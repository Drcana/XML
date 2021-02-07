package rs.ac.uns.ftn.portal_organa_vlasti.repository;

import org.apache.jena.query.ResultSet;
import org.exist.xupdate.XUpdateProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rs.ac.uns.ftn.portal_organa_vlasti.db.ExistManager;
import rs.ac.uns.ftn.portal_organa_vlasti.dto.SearchZahtevMap;
import rs.ac.uns.ftn.portal_organa_vlasti.dto.ZahtevCollection;
import rs.ac.uns.ftn.portal_organa_vlasti.service.JAXBService;
import rs.ac.uns.ftn.portal_organa_vlasti.service.MetadataExtractorService;
import rs.ac.uns.ftn.zahtev.DokumentZahtev;

import java.io.IOException;
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

    @Autowired
    private MetadataExtractorService metadataExtractorService;


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

    public ZahtevCollection getAllByIds(List<String> ids) {
        List<DokumentZahtev> list = new ArrayList<>();

        for (String id : ids) {
            DokumentZahtev dokumentZahtev = get(id);
            if (dokumentZahtev != null) {
                list.add(dokumentZahtev);
            }
        }

        return new ZahtevCollection(list);
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

    public ZahtevCollection advancedSearch(SearchZahtevMap searchZahtevMap) throws IOException {
        String query = "SELECT DISTINCT * FROM <%s>\n" + "WHERE {\n";
        List<String> params = new ArrayList<>();

        int numbOfUnion = searchZahtevMap.getParametersNumber() - 1;

        if (searchZahtevMap.getOrganVlasti() != null) {
            query += getOneRow("organ_vlasti", searchZahtevMap);

            if (isUnionValueRequired(searchZahtevMap, numbOfUnion)) {
                query += "\tUNION\n";
                numbOfUnion--;
            }

            params.add(searchZahtevMap.getOrganVlasti());
        }

        if (searchZahtevMap.getMestoOrganaVlasti() != null) {
            query += getOneRow("mesto_organa_vlasti", searchZahtevMap);

            if (isUnionValueRequired(searchZahtevMap, numbOfUnion)) {
                query += "\tUNION\n";
                numbOfUnion--;
            }

            params.add(searchZahtevMap.getMestoOrganaVlasti());
        }

        if (searchZahtevMap.getDatumZahteva() != null) {
            query += getOneRow("datum_zahteva", searchZahtevMap);
            if (isUnionValueRequired(searchZahtevMap, numbOfUnion)) {
                query += "\tUNION\n";
                numbOfUnion--;
            }
            params.add(searchZahtevMap.getDatumZahteva());
        }

        if (searchZahtevMap.getMestoPodnosioca() != null) {
            query += getOneRow("mesto_podnosioca", searchZahtevMap);
            if (isUnionValueRequired(searchZahtevMap, numbOfUnion)) {
                query += "\tUNION\n";
            }
            params.add(searchZahtevMap.getMestoPodnosioca());
        }

        if (searchZahtevMap.getImePodnosioca() != null) {
            query += getOneRow("ime_podnosioca", searchZahtevMap);
            params.add(searchZahtevMap.getImePodnosioca());
        }

        query += "}";

        List<String> listOfIds = metadataExtractorService.findAll(params, query, DokumentZahtev.class);

        return getAllByIds(listOfIds);
    }

    private String returnRowWithValue(String tagValue) {
        return "\t?zahtev <http://examples/predicate/" + tagValue + "> \"%s\" .\n";
    }

    private String getOneRow(String tagValue, SearchZahtevMap searchZahtevMap) {
        String row = "";
        row += isOrOperatorAndMoreThanOneParam(searchZahtevMap) ? "{\n\t" : "";
        row += returnRowWithValue(tagValue);
        row += isOrOperatorAndMoreThanOneParam(searchZahtevMap) ? "\t}\n" : "";

        return row;
    }

    private boolean isOrOperatorAndMoreThanOneParam(SearchZahtevMap searchZahtevMap) {
        return searchZahtevMap.isOrOperator() && searchZahtevMap.getParametersNumber() > 1;
    }

    private boolean isUnionValueRequired(SearchZahtevMap searchZahtevMap, int numbOfUnion) {
        return isOrOperatorAndMoreThanOneParam(searchZahtevMap) && numbOfUnion > 0;
    }

    public ResultSet exportAsJson(String id) throws IOException {
        return metadataExtractorService.exportAsJson(TARGET_NAMESPACE, id, DokumentZahtev.class);
    }
}
