package mocks;

import Interfaces.SocketInterfaces;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MockSocketWrapper implements SocketInterfaces {
    private int getNumberOfCallsToAcceptClient = 0;
    private int getCallToCreateServerSocket = 0;
    private int clientPort = 4444;

    @Override
    public ServerSocket createNewServerSocket(int clientPort) throws IOException {
        getCallToCreateServerSocket++;
        return null;
    }
    @Override
    public Socket acceptClient() {
        getNumberOfCallsToAcceptClient++;
        return null;
    }

    @Override
    public void closeClientConnection(Socket clientSocket) throws IOException {

    }
    public int getNumberOfCallsToAcceptClient() {
        return getNumberOfCallsToAcceptClient;
    }
    public int getCallToCreateSocket() {
        return getCallToCreateServerSocket;
    }
}
