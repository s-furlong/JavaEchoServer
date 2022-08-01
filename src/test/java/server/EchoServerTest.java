package server;


import mocks.MockInputOutWrapper;
import mocks.MockSocketWrapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


class EchoServerTests {

    @Test
    public void testRunAcceptsClient() throws IOException {
        MockInputOutWrapper mockInputOutputWrapper = new MockInputOutWrapper();
        MockSocketWrapper mockSocketWrapper = new MockSocketWrapper();

        EchoServer.run(mockInputOutputWrapper, mockSocketWrapper);

        assertEquals(1, mockSocketWrapper.getNumberOfCallsToAcceptClient());
    }

    @Test
    public void testRunCreatesInputStream() throws IOException {
        MockInputOutWrapper mockInputOutputWrapper = new MockInputOutWrapper();
        MockSocketWrapper mockSocketWrapper = new MockSocketWrapper();

        EchoServer.run(mockInputOutputWrapper, mockSocketWrapper);

        assertEquals(1, mockInputOutputWrapper.getNumberOfCallsToCreateInputStream());
    }

    @Test
    public void testRunCreatesOutputStream() throws IOException {
        MockInputOutWrapper mockInputOutputWrapper = new MockInputOutWrapper();
        MockSocketWrapper mockSocketWrapper = new MockSocketWrapper();

        EchoServer.run(mockInputOutputWrapper, mockSocketWrapper);

        assertEquals(1, mockInputOutputWrapper.getNumberOfCallsToCreateOutStream());
    }

    @Test
    public void testRunReceivesMessages() throws IOException {
        MockInputOutWrapper mockInputOutputWrapper = new MockInputOutWrapper();
        MockSocketWrapper mockSocketWrapper = new MockSocketWrapper();

        EchoServer.run(mockInputOutputWrapper, mockSocketWrapper);
        String s = "hello";

        assertEquals("hello", mockInputOutputWrapper.setReceivedMessage(s));
    }

    @Test
    public void testRunCallsReceivedMessage() throws IOException {
        MockInputOutWrapper mockInputOutputWrapper = new MockInputOutWrapper();
        MockSocketWrapper mockSocketWrapper = new MockSocketWrapper();

        EchoServer.run(mockInputOutputWrapper, mockSocketWrapper);

        assertEquals(1, mockInputOutputWrapper.getNumberOfCallsReceiveMessages());
    }
}