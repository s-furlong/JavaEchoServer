package server;

import java.io.*;
import java.net.ServerSocket;

public class EchoServer {

    public static void main(String[] args) throws IOException {
        int clientPort = (args.length > 0) ? Integer.parseInt(args[0]) : 4444;
        ServerSocket serverSocket = new ServerSocket(clientPort);
        System.err.println("ESTABLISHED ON LOCALHOST: " + clientPort);
        var echoServerWrappers = new EchoServerWrappers(serverSocket);

        while(true) {
            run(echoServerWrappers);
        }
    }
    static void run(EchoServerInterfaces echoServerWrappers) throws IOException {
        var clientSocket = echoServerWrappers.acceptClient();
        echoServerWrappers.createInputStream(clientSocket);
        echoServerWrappers.createOutputStream(clientSocket);
        String s;
        while ((s = echoServerWrappers.receivedMessage()) != null) {
            echoServerWrappers.echoedMessage(s);
        }
        echoServerWrappers.closeClientConnection(clientSocket);
    }


}