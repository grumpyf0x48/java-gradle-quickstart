package org.grumpyf0x48.pkg;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test void appHasAGreeting() {
        App app = new App();
        assertNotNull(app.getGreeting(), "app should have a greeting");
    }
}
