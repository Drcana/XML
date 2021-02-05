package rs.ac.uns.ftn.portal_organa_vlasti.dto;


import rs.ac.uns.ftn.zahtev.DokumentZahtev;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlSeeAlso(DokumentZahtev.class)
public class ZahtevCollection {

    private List<DokumentZahtev> zahtevList = new ArrayList<>();

    public ZahtevCollection() {
    }

    public ZahtevCollection(List<DokumentZahtev> zahtevList) {
        this.zahtevList = zahtevList;
    }

    @XmlAnyElement
    public List<DokumentZahtev> getZahtevList() {
        return zahtevList;
    }

    public void setZahtevList(List<DokumentZahtev> zahtevList) {
        this.zahtevList = zahtevList;
    }
}
