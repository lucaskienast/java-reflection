package dynamicProxies.external;

public interface HttpClient {

    void initialize();

    String sendRequest(String request);

}
