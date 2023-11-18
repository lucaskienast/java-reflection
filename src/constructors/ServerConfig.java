package constructors;

import java.net.InetSocketAddress;

public class ServerConfig {

    private static ServerConfig serverConfigSingleton;

    private final InetSocketAddress serverAddress;
    private final String greetingMessage;

    private ServerConfig(int port, String greetingMessage) {
        this.greetingMessage = greetingMessage;
        this.serverAddress = new InetSocketAddress("localhost", port);

        if (serverConfigSingleton == null) {
            serverConfigSingleton = this;
        }
    }

    public static ServerConfig getSingleton() {
        return serverConfigSingleton;
    }

    public InetSocketAddress getServerAddress() {
        return this.serverAddress;
    }

    public String getGreetingMessage() {
        return this.greetingMessage;
    }

}
