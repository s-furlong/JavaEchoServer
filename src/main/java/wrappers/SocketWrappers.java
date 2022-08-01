package wrappers;

import Interfaces.SocketInterfaces;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketWrappers implements SocketInterfaces {
    private ServerSocket serverSocket;

    @Override
    public ServerSocket createNewServerSocket(int clientPort) throws IOException {
        serverSocket = new ServerSocket(clientPort);
        System.err.println("ESTABLISHED ON LOCALHOST: " + clientPort);
        return serverSocket;
    }

    @Override
    public Socket acceptClient() throws IOException {
        Socket clientSocket = serverSocket.accept();
        System.err.println("ACCEPTED CONNECTION");
        return clientSocket;
    }

    @Override
    public void closeClientConnection(Socket clientSocket) throws IOException {
        clientSocket.close();
        System.err.println("CONNECTION WITH THE CLIENT HAS ENDED");
    }
}
