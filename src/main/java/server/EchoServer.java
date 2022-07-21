package server;
import java.net.*;
import java.io.*;
public class EchoServer {
    public static void main(String[] args) throws IOException {
        int portNumber = 4444;
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Started server on port " + portNumber);

        while (true) {
            Socket clientSocket = serverSocket.accept();

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("Welcome to echo server. Please Enter a Message");
            String s;
            while ((s = in.readLine()) != null) {
                out.println(s);
            }

            System.out.println("Closing connection with client");
            out.close();
            in.close();
            clientSocket.close();
        }
    }
}