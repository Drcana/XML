package rs.ac.uns.ftn.portal_poverenika.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DocumentDto {

    @XmlElement
    private String documentId;

    public DocumentDto() {
    }

    public DocumentDto(String documentId) {
        this.documentId = documentId;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }
}
