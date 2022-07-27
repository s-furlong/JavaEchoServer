package server;



import java.io.IOException;
import java.net.Socket;

public interface EchoServerInterfaces {
    Socket acceptClient() throws IOException;
    void createInputStream(Socket clientSocket) throws IOException;
    void createOutputStream(Socket clientSocket) throws IOException;
    String receivedMessage() throws IOException;
    void echoedMessage(String s) throws IOException;
    void closeClientConnection(Socket clientSocket) throws IOException;
}
