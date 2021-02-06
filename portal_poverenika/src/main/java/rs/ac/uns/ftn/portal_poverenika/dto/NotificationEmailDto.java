package rs.ac.uns.ftn.portal_poverenika.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NotificationEmailDto {

    private String documentId;

    private boolean zalbaProtivCutanja;

    public NotificationEmailDto() {
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public boolean isZalbaProtivCutanja() {
        return zalbaProtivCutanja;
    }

    public void setZalbaProtivCutanja(boolean zalbaProtivCutanja) {
        this.zalbaProtivCutanja = zalbaProtivCutanja;
    }
}
