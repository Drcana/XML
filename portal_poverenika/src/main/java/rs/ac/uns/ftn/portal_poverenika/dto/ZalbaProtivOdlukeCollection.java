package rs.ac.uns.ftn.portal_poverenika.dto;

import rs.ac.uns.ftn.portal_poverenika.model.zalba_protiv_odluke.ZalbaProtivOdluke;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlSeeAlso(ZalbaProtivOdluke.class)
public class ZalbaProtivOdlukeCollection {

    private List<ZalbaProtivOdluke> zalbaProtivOdlukeList = new ArrayList<>();

    public ZalbaProtivOdlukeCollection() {
    }

    public ZalbaProtivOdlukeCollection(List<ZalbaProtivOdluke> zalbaProtivOdlukeList) {
        this.zalbaProtivOdlukeList = zalbaProtivOdlukeList;
    }

    @XmlAnyElement
    public List<ZalbaProtivOdluke> getZalbaProtivOdlukeList() {
        return zalbaProtivOdlukeList;
    }

    public void setZalbaProtivOdlukeList(List<ZalbaProtivOdluke> zalbaProtivOdlukeList) {
        this.zalbaProtivOdlukeList = zalbaProtivOdlukeList;
    }
}
