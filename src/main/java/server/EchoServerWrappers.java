package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerWrappers implements EchoServerInterfaces{
    private final ServerSocket serverSocket;
    public BufferedReader input;
    public PrintWriter output;


    public EchoServerWrappers(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
        this.input = null;
        this.output = null;
    }


    @Override
    public Socket acceptClient() throws IOException {
        Socket clientSocket = serverSocket.accept();
        System.err.println("ACCEPTED CONNECTION");
        return clientSocket;
    }

    public void createInputStream(Socket clientSocket) throws IOException {
        input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public void createOutputStream(Socket clientSocket) throws IOException {
        output = new PrintWriter(clientSocket.getOutputStream(), true);
        output.println("Enter a Message: ");
    }

    @Override
    public String receivedMessage() throws IOException {
        return input.readLine();
    }

    @Override
    public void echoedMessage(String s) {
        output.println(s);
    }

    @Override
    public void closeClientConnection(Socket clientSocket) throws IOException {
        input.close();
        output.close();
        clientSocket.close();
        System.err.println("CONNECTION WITH THE CLIENT HAS ENDED");
    }


}
