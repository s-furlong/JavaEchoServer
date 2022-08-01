package Interfaces;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public interface SocketInterfaces {
    ServerSocket createNewServerSocket(int clientPort) throws IOException;
    Socket acceptClient() throws IOException;
    void closeClientConnection(Socket clientSocket) throws IOException;

}
