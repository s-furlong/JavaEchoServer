package server;

import Interfaces.InputOutputInterfaces;
import Interfaces.SocketInterfaces;
import wrappers.InputOutputWrappers;
import wrappers.SocketWrappers;

import java.io.*;

public class EchoServer {

    public static void main(String[] args) throws IOException {
        int clientPort = (args.length > 0) ? Integer.parseInt(args[0]) : 4444;
        var socketWrappers = new SocketWrappers();
        var echoServerWrappers = new InputOutputWrappers();

        socketWrappers.createNewServerSocket(clientPort);

        while(true) {
            run(echoServerWrappers, socketWrappers);
        }
    }
    static void run(InputOutputInterfaces inputOutputWrappers, SocketInterfaces socketWrappers) throws IOException {
        var clientSocket = socketWrappers.acceptClient();

        inputOutputWrappers.createInputStream(clientSocket);
        inputOutputWrappers.createOutputStream(clientSocket);

        String s;
        while ((s = inputOutputWrappers.receivedMessage()) != null) {
            inputOutputWrappers.echoedMessage(s);
        }

        inputOutputWrappers.closeInputOutputStreams();
        socketWrappers.closeClientConnection(clientSocket);
    }


}