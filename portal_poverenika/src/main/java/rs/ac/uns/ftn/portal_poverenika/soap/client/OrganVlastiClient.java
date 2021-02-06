package rs.ac.uns.ftn.portal_poverenika.soap.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class OrganVlastiClient extends WebServiceGatewaySupport {

    private static final String ORGAN_VLASTI_SOAP_URL = "http://localhost:9001/services/zahtev";

//    public GetZahtevByIdResponse.Return getZahtevById(String zahtevId) {
//        GetZahtevById getZahtevById = new GetZahtevById();
//        getZahtevById.setArg0(zahtevId);
//
//        JAXBElement<GetZahtevById> request = new ObjectFactory().createGetZahtevById(getZahtevById);
//
//        JAXBElement<GetZahtevByIdResponse> responseJAXBElement = (JAXBElement<GetZahtevByIdResponse>)
//                getWebServiceTemplate().marshalSendAndReceive(ORGAN_VLASTI_SOAP_URL, request);
//
//        return responseJAXBElement.getValue().getReturn();
//    }
}
