package rs.ac.uns.ftn.portal_organa_vlasti.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ObavestenjeNotificationDto {

    private String obavestenjeId;

    public ObavestenjeNotificationDto() {
    }

    public ObavestenjeNotificationDto(String obavestenjeId, Boolean pdfFile) {
        this.obavestenjeId = obavestenjeId;
    }

    public String getObavestenjeId() {
        return obavestenjeId;
    }

    public void setObavestenjeId(String obavestenjeId) {
        this.obavestenjeId = obavestenjeId;
    }
}
