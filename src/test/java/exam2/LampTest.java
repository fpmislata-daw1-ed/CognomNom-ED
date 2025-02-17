package exam2;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LampTest {
    @Nested
    class ConstructorTests {
        @Test
        void testConstructor() {
            Lamp lamp = new Lamp(10);
            assertAll(
                    () -> assertEquals(10, lamp.getConsumption()),
                    () -> assertFalse(lamp.isOn())
            );
        }

        @Test
        void testConstructorWithOn() {
            Lamp lamp = new Lamp(0.1, true);
            assertAll(
                    () -> assertEquals(0.1, lamp.getConsumption()),
                    () -> assertTrue(lamp.isOn())
            );
        }
    }

    @Nested
    class TurnOnTests {
        @Test
        void testTurnOn() {
            Lamp lamp = new Lamp(10, false);
            lamp.turnOn();
            assertTrue(lamp.isOn());
        }

        @Test
        void testTurnOnAlreadyOn() {
            Lamp lamp = new Lamp(10, true);
            lamp.turnOn();
            assertTrue(lamp.isOn());
        }
    }

    @Nested
    class TurnOffTests {
        @Test
        void testTurnOff() {
            Lamp lamp = new Lamp(10, true);
            lamp.turnOff();
            assertFalse(lamp.isOn());
        }

        @Test
        void testTurnOffAlreadyOff() {
            Lamp lamp = new Lamp(10, false);
            lamp.turnOff();
            assertFalse(lamp.isOn());
        }
    }

    @Nested
    class ToggleTests {
        @Test
        void testToggleOn() {
            Lamp lamp = new Lamp(10, false);
            lamp.toggle();
            assertTrue(lamp.isOn());
        }

        @Test
        void testToggleOff() {
            Lamp lamp = new Lamp(10, true);
            lamp.toggle();
            assertFalse(lamp.isOn());
        }
    }

    @ParameterizedTest
    @CsvSource({
            "10, false, 3600, 0",
            "10, true, 3600, 10",
            "10, true, 7200, 20",
            "20, true, 3600, 20"
    })
    void testConsume(double consumption, boolean on, double seconds, double expected) {
        Lamp lamp = new Lamp(consumption, on);
        double actual = lamp.consume(seconds);

        assertEquals(expected, actual);
    }
}