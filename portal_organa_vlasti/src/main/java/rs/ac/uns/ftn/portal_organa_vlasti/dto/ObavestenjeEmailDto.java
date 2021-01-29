package rs.ac.uns.ftn.portal_organa_vlasti.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ObavestenjeEmailDto {

    private byte[] file;

    private String receiverEmail;

    private String senderEmail;

    private String zahtevId;

    private boolean pdfFile;

    public ObavestenjeEmailDto() {
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

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getZahtevId() {
        return zahtevId;
    }

    public void setZahtevId(String zahtevId) {
        this.zahtevId = zahtevId;
    }

    public boolean isPdfFile() {
        return pdfFile;
    }

    public void setPdfFile(boolean pdfFile) {
        this.pdfFile = pdfFile;
    }
}
