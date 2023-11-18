package constructors.web;

import com.sun.net.httpserver.HttpServer;
import constructors.ServerConfig;

import java.io.IOException;
import java.io.OutputStream;

public class WebServer {

    public void startServer() throws IOException {
        HttpServer httpServer = HttpServer.create(ServerConfig.getSingleton().getServerAddress(), 0);

        httpServer.createContext("/greeting").setHandler(exchange -> {

            String responseMessage = ServerConfig.getSingleton().getGreetingMessage();
            exchange.sendResponseHeaders(200, responseMessage.length());

            OutputStream responseBody = exchange.getResponseBody();
            responseBody.write(responseMessage.getBytes());
            responseBody.flush();
            responseBody.close();

        });

        System.out.println(String.format("Starting server on address %s:%d",
                ServerConfig.getSingleton().getServerAddress().getHostName(),
                ServerConfig.getSingleton().getServerAddress().getPort()));

        httpServer.start();
    }

}
