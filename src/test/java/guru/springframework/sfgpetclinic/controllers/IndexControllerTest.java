package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @DisplayName("Test Proper View name")
    @Test
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), "Wrong View Returned");
        assertEquals("index", controller.index(), () -> "Another expensive message");
        assertThat(controller.index()).isEqualTo("index");
    }

    @Test
    void oopsHandler() {
        assertThrows(ValueNotFoundException.class, () -> controller.oopsHandler());
    }

    @Disabled
    @Test
    void testTimeOut() {
        assertTimeout(Duration.ofMillis(100), () -> Thread.sleep(5000));
        System.out.println(" I got here");
    }

    @Disabled
    @Test
    void testTimeOutPrempt() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> Thread.sleep(5000));
        System.out.println("I also got here");
    }

    @Test
    void testAssumptionTrue() {
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    @Test
    void testAssumptionTrueAssumptionIsTrue() {
        assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMACOS(){

    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testMeOnWindows() {

    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testMeOnJava8() {

    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testMeOnJava11() {

    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "maxizamora")
    @Test
    void testIfUserMax() {

    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "aliu")
    @Test
    void testIfUserFred() {

    }

}