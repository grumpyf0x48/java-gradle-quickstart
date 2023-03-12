package org.grumpyf0x48.myapplication;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationTest {

    @Test
    public void appSaysHello() {
        Application application = new Application();
        assertEquals("Hello World!", application.getGreeting());
    }
}
