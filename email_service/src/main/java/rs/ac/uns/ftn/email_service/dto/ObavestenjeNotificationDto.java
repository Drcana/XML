package rs.ac.uns.ftn.email_service.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "obavestenje_notification")
@XmlAccessorType(XmlAccessType.FIELD)
public class ObavestenjeNotificationDto {

    private byte[] pdfFile;

    private byte[] htmlFile;

    private String receiverEmail;

    private String senderEmail;

    private String zahtevId;

    public ObavestenjeNotificationDto() {
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

    public byte[] getPdfFile() {
        return pdfFile;
    }

    public void setPdfFile(byte[] pdfFile) {
        this.pdfFile = pdfFile;
    }

    public String getZahtevId() {
        return zahtevId;
    }

    public void setZahtevId(String zahtevId) {
        this.zahtevId = zahtevId;
    }

    public byte[] getHtmlFile() {
        return htmlFile;
    }

    public void setHtmlFile(byte[] htmlFile) {
        this.htmlFile = htmlFile;
    }
}
