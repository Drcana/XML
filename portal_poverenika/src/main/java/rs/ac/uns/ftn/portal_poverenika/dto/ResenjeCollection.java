package rs.ac.uns.ftn.portal_poverenika.dto;

import rs.ac.uns.ftn.portal_poverenika.model.resenje.Resenje;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlSeeAlso(Resenje.class)
public class ResenjeCollection {

    private List<Resenje> resenjeList = new ArrayList<>();

    public ResenjeCollection() {
    }

    public ResenjeCollection(List<Resenje> resenjeList) {
        this.resenjeList = resenjeList;
    }

    @XmlAnyElement
    public List<Resenje> getResenjeList() {
        return resenjeList;
    }

    public void setResenjeList(List<Resenje> resenjeList) {
        this.resenjeList = resenjeList;
    }
}
