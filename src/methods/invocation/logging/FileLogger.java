package methods.invocation.logging;

import java.io.IOException;

public class FileLogger {

    public void sendRequest(String data) throws IOException {
        throw new IOException("Failed to log");
        //System.out.printf("Data: %s was logged to file system%n", data);
    }

}
