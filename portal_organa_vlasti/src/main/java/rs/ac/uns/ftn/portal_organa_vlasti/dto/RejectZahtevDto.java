package rs.ac.uns.ftn.portal_organa_vlasti.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RejectZahtevDto {

    private String receiverEmail;

    private String senderEmail;

    private String zahtevId;

    public RejectZahtevDto() {
    }

    public RejectZahtevDto(String receiverEmail, String senderEmail, String zahtevId) {
        this.receiverEmail = receiverEmail;
        this.senderEmail = senderEmail;
        this.zahtevId = zahtevId;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getZahtevId() {
        return zahtevId;
    }

    public void setZahtevId(String zahtevId) {
        this.zahtevId = zahtevId;
    }
}
