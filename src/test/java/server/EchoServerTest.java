package server;


import mocks.MockWrapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.ServerSocket;

import static org.junit.jupiter.api.Assertions.*;


class MockWrappersTests {
    @Test
    public void testRunGetsAcceptsClient() throws IOException {
        ServerSocket serverSocket = new ServerSocket(4000);
        MockWrapper mockWrapper = new MockWrapper(serverSocket);
        EchoServer testServer = new EchoServer();

        testServer.run(mockWrapper);

        assertEquals(1, mockWrapper.getNumberOfCallsToAcceptClient());
    }
    @Test
    public void testRunCreatesInputStream() throws IOException {
        ServerSocket serverSocket = new ServerSocket(4444);
        MockWrapper mockWrapper = new MockWrapper(serverSocket);
        EchoServer testServer = new EchoServer();

        testServer.run(mockWrapper);

        assertEquals(1, mockWrapper.getNumberOfCallsToCreateInputStream());
    }
    @Test
    public void testRunCreatesOutputStream() throws IOException {
        ServerSocket serverSocket = new ServerSocket(4001);
        MockWrapper mockWrapper = new MockWrapper(serverSocket);
        EchoServer testServer = new EchoServer();

        testServer.run(mockWrapper);

        assertEquals(1, mockWrapper.getNumberOfCallsToCreateOutStream());
    }
    @Test
    public void testRunReceivesMessages() throws IOException {
        ServerSocket serverSocket = new ServerSocket(4002);
        MockWrapper mockWrapper = new MockWrapper(serverSocket);
        EchoServer testServer = new EchoServer();

        testServer.run(mockWrapper);

        assertEquals(1, mockWrapper.getNumberOfCallsReceiveMessages());
    }
//    @Test
//    public void testRunEchoesMessage() throws IOException {
//        ServerSocket serverSocket = new ServerSocket(4003);
//        MockWrapper mockWrapper = new MockWrapper(serverSocket);
//        EchoServer testServer = new EchoServer();
//        String s = "Hello World";
//        mockWrapper.setReceivedMessage(s);
//        testServer.run(mockWrapper);
//
//        assertEquals(1, mockWrapper.getNumberOfCallsEchoedMessage());
//    }
}