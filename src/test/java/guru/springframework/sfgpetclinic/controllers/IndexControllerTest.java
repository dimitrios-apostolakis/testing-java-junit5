package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @Test
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), "Wrong view returned");
        assertEquals("index", controller.index(), () -> "Another expensive message");
    }

    @DisplayName("Test exception")
    @Test
    void oupsHandler() {
        assertThrows(ValueNotFoundException.class, () -> controller.oupsHandler());
    }

    @Disabled("Demo of timeout")
    @Test
    void testTimeOut() {
        assertTimeout(Duration.ofMillis(100), () -> Thread.sleep(2000));
        System.out.println("Finished testTimeOut");
    }

    @Disabled("Demo of timeout preemptively")
    @Test
    void testTimeOutPreemptively() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> Thread.sleep(2000));
        System.out.println("Finished testTimeOutPreemptively");
    }

    @Test
    void testAssumptionTrue() {
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    @Test
    void testAssumptionTruePositive() {
        assumeTrue("GURU".equals("GURU"));
    }

}