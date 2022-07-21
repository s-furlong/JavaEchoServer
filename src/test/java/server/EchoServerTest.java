package server;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class EchoServerTest {
    @Test void walkingSkeletonTest() {
        EchoServer classUnderTest = new EchoServer();
        assertEquals(classUnderTest, "echo Server");
    }
}