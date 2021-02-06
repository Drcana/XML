package rs.ac.uns.ftn.portal_organa_vlasti.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchZahtevMap {

    private String organVlasti;

    private String mestoOrganaVlasti;

    private String datumZahteva;

    private String imePodnosioca;

    private String mestoPodnosioca;

    private boolean orOperator;

    public SearchZahtevMap() {
    }

    public String getOrganVlasti() {
        return organVlasti;
    }

    public void setOrganVlasti(String organVlasti) {
        this.organVlasti = organVlasti;
    }

    public String getMestoOrganaVlasti() {
        return mestoOrganaVlasti;
    }

    public void setMestoOrganaVlasti(String mestoOrganaVlasti) {
        this.mestoOrganaVlasti = mestoOrganaVlasti;
    }

    public boolean isOrOperator() {
        return orOperator;
    }

    public String getDatumZahteva() {
        return datumZahteva;
    }

    public void setDatumZahteva(String datumZahteva) {
        this.datumZahteva = datumZahteva;
    }

    public String getImePodnosioca() {
        return imePodnosioca;
    }

    public void setImePodnosioca(String imePodnosioca) {
        this.imePodnosioca = imePodnosioca;
    }

    public String getMestoPodnosioca() {
        return mestoPodnosioca;
    }

    public void setMestoPodnosioca(String mestoPodnosioca) {
        this.mestoPodnosioca = mestoPodnosioca;
    }

    public void setOrOperator(boolean orOperator) {
        this.orOperator = orOperator;
    }

    public int getParametersNumber() {
        return countParameters(organVlasti, mestoOrganaVlasti, datumZahteva, imePodnosioca, mestoPodnosioca);
    }

    private int countParameters(String... objects) {
        int counter = 0;

        for (String object : objects) {
            if (object != null) {
                counter++;
            }
        }

        return counter;
    }
}
