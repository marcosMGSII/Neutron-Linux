package neutron.capture.persistencia;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

/**
 * Jersey REST client generated for REST resource:_1 [rest/search/query=p53]<br>
 * USAGE:
 * <pre>
 *        Proxy client = new Proxy();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Marcos Arruda; Gustavo Baladão; Jonatha Daguerre
 */
public class Proxy {

    private WebResource webResource;
    private Client client;
    private static final String BASE_URI = "http://192.168.0.205/wcfservice/RestServiceImpl.svc";
    public boolean webSericeOnLine;

    public Proxy() {
        webSericeOnLine = false;
        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        client = Client.create(config);
        webResource = client.resource(BASE_URI).path("");
    }

    /**
     * @param q representa a query do Rest
     * @return retorna uma String com resultado
     */
    public String getResult(String q) throws UniformInterfaceException {
        ClientResponse clientResponse = webResource.path(java.text.MessageFormat.format("/{0}", new Object[]{q})).get(ClientResponse.class);
        return clientResponse.getEntity(String.class);
    }

    public void close() {
        client.destroy();
    }
}
