package mocks;

import Interfaces.InputOutputInterfaces;
import java.net.Socket;

public class MockInputOutWrapper implements InputOutputInterfaces {
    private int getNumberOfCallsToCreateInputStream = 0;
    private int getNumberOfCallsToCreateOutStream = 0;
    private int getNumberOfCallsReceiveMessages = 0;
    private String receivedMessage;


    @Override
    public void createInputStream(Socket clientSocket) {
        getNumberOfCallsToCreateInputStream++;
    }

    @Override
    public void createOutputStream(Socket clientSocket) {
        getNumberOfCallsToCreateOutStream++;
    }

    @Override
    public String receivedMessage() {
        getNumberOfCallsReceiveMessages++;
        return receivedMessage;
    }

    @Override
    public void echoedMessage(String s) {

    }

    @Override
    public void closeInputOutputStreams() {

    }

    public String setReceivedMessage(String s) {
        receivedMessage = s;
        getNumberOfCallsReceiveMessages++;
        return s;
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



}
