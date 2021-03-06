package org.amityas.customerorder;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.0.2
 * 2017-01-23T17:43:03.311-08:00
 * Generated source version: 3.0.2
 * 
 */
@WebServiceClient(name = "CustomerOrder", 
                  wsdlLocation = "file:/C:/Users/Amit/git/SOAPWebServices-CXF/CustomerOrderClient/src/main/webapp/WEB-INF/wsdl/CustomerOrder.wsdl",
                  targetNamespace = "http://www.amityas.org/CustomerOrder/") 
public class CustomerOrder extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.amityas.org/CustomerOrder/", "CustomerOrder");
    public final static QName CustomerOrderSOAP = new QName("http://www.amityas.org/CustomerOrder/", "CustomerOrderSOAP");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/Users/Amit/git/SOAPWebServices-CXF/CustomerOrderClient/src/main/webapp/WEB-INF/wsdl/CustomerOrder.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(CustomerOrder.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/C:/Users/Amit/git/SOAPWebServices-CXF/CustomerOrderClient/src/main/webapp/WEB-INF/wsdl/CustomerOrder.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public CustomerOrder(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CustomerOrder(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CustomerOrder() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public CustomerOrder(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public CustomerOrder(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public CustomerOrder(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    

    /**
     *
     * @return
     *     returns CustomerOrderPortType
     */
    @WebEndpoint(name = "CustomerOrderSOAP")
    public CustomerOrderPortType getCustomerOrderSOAP() {
        return super.getPort(CustomerOrderSOAP, CustomerOrderPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CustomerOrderPortType
     */
    @WebEndpoint(name = "CustomerOrderSOAP")
    public CustomerOrderPortType getCustomerOrderSOAP(WebServiceFeature... features) {
        return super.getPort(CustomerOrderSOAP, CustomerOrderPortType.class, features);
    }

}
