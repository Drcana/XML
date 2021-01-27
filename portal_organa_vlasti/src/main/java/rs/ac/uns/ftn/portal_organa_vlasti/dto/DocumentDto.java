package rs.ac.uns.ftn.portal_organa_vlasti.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DocumentDto {

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
