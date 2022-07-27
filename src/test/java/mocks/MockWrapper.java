package mocks;

import server.EchoServerInterfaces;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MockWrapper implements EchoServerInterfaces {
    public ServerSocket serverSocket;
    private int getNumberOfCallsToAcceptClient = 0;
    private int getNumberOfCallsToCreateInputStream = 0;
    private int getNumberOfCallsToCreateOutStream = 0;
    private int getNumberOfCallsReceiveMessages = 0;
    private int getNumberOfCallsEchoedMessage = 0;
    private String receivedMessage;

    public MockWrapper(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public Socket acceptClient() throws IOException {
        getNumberOfCallsToAcceptClient++;
        return null;
    }

    @Override
    public void createInputStream(Socket clientSocket) throws IOException {
        getNumberOfCallsToCreateInputStream++;
    }

    @Override
    public void createOutputStream(Socket clientSocket) throws IOException {
        getNumberOfCallsToCreateOutStream++;
    }

    @Override
    public String receivedMessage() throws IOException {
        getNumberOfCallsReceiveMessages++;
        return receivedMessage;
    }

    @Override
    public void echoedMessage(String s) throws IOException {
        getNumberOfCallsEchoedMessage++;
    }

    public void setReceivedMessage(String s) {
        receivedMessage = s;
    }

    @Override
    public void closeClientConnection(Socket clientSocket) throws IOException {

    }

    public int getNumberOfCallsToAcceptClient() {
        return getNumberOfCallsToAcceptClient;
    }

    public int getNumberOfCallsToCreateInputStream() {
        return getNumberOfCallsToCreateInputStream;
    }

    public int getNumberOfCallsToCreateOutStream() {
        return getNumberOfCallsToCreateOutStream;
    }

    public int getNumberOfCallsReceiveMessages() {
        return getNumberOfCallsReceiveMessages;
    }

    public int getNumberOfCallsEchoedMessage() {
        return getNumberOfCallsEchoedMessage;
    }


}
