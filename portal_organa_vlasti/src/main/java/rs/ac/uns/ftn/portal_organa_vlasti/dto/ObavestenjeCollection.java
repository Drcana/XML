package rs.ac.uns.ftn.portal_organa_vlasti.dto;

import rs.ac.uns.ftn.portal_organa_vlasti.model.obavestenje.Obavestenje;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlSeeAlso(Obavestenje.class)
public class ObavestenjeCollection {

    private List<Obavestenje> obavestenjeList = new ArrayList<>();

    public ObavestenjeCollection() {
    }

    public ObavestenjeCollection(List<Obavestenje> obavestenjeList) {
        this.obavestenjeList = obavestenjeList;
    }

    @XmlAnyElement
    public List<Obavestenje> getObavestenjeList() {
        return obavestenjeList;
    }

    public void setObavestenjeList(List<Obavestenje> obavestenjeList) {
        this.obavestenjeList = obavestenjeList;
    }
}
