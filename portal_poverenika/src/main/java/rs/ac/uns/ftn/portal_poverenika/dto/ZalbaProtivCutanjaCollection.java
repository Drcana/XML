package rs.ac.uns.ftn.portal_poverenika.dto;

import rs.ac.uns.ftn.portal_poverenika.model.zalba_protiv_cutanja.ZalbaProtivCutanja;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlSeeAlso(ZalbaProtivCutanja.class)
public class ZalbaProtivCutanjaCollection {

    private List<ZalbaProtivCutanja> zalbaProtivCutanjaList = new ArrayList<>();

    public ZalbaProtivCutanjaCollection() {
    }

    public ZalbaProtivCutanjaCollection(List<ZalbaProtivCutanja> zalbaProtivCutanjaList) {
        this.zalbaProtivCutanjaList = zalbaProtivCutanjaList;
    }

    @XmlAnyElement
    public List<ZalbaProtivCutanja> getZalbaProtivCutanjaList() {
        return zalbaProtivCutanjaList;
    }

    public void setZalbaProtivCutanjaList(List<ZalbaProtivCutanja> zalbaProtivCutanjaList) {
        this.zalbaProtivCutanjaList = zalbaProtivCutanjaList;
    }
}
