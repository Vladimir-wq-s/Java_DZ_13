package vladimir.java_dz_13;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;

@Endpoint
public class FractionEndpoint {
    private static final String NAMESPACE_URI = "http://vladimir/soap";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ReduceFractionRequest")
    @ResponsePayload
    public Element handleReduceRequest(@RequestPayload Element request) throws Exception {
        NodeList numList = request.getElementsByTagNameNS(NAMESPACE_URI, "numerator");
        NodeList denList = request.getElementsByTagNameNS(NAMESPACE_URI, "denominator");

        int num = Integer.parseInt(numList.item(0).getTextContent());
        int den = Integer.parseInt(denList.item(0).getTextContent());

        Fraction fraction = new Fraction(num, den);

        org.w3c.dom.Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element response = doc.createElementNS(NAMESPACE_URI, "ReduceFractionResponse");

        Element numeratorNode = doc.createElementNS(NAMESPACE_URI, "numerator");
        numeratorNode.setTextContent(String.valueOf(fraction.getNumerator()));
        response.appendChild(numeratorNode);

        Element denominatorNode = doc.createElementNS(NAMESPACE_URI, "denominator");
        denominatorNode.setTextContent(String.valueOf(fraction.getDenominator()));
        response.appendChild(denominatorNode);

        return response;
    }
}
