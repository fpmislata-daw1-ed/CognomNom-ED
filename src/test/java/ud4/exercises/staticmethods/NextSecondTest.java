package ud4.exercises.staticmethods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NextSecondTest {
    @Test
    void given000000_shouldBe000001(){
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        String expected = "00:00:01";

        String actual = NextSecond.nextSecond(hours, minutes, seconds);

        assertEquals(expected, actual);
    }

    @Test
    void given000001_shouldBe000002(){
        int hours = 0;
        int minutes = 0;
        int seconds = 1;
        String expected = "00:00:02";

        String actual = NextSecond.nextSecond(hours, minutes, seconds);

        assertEquals(expected, actual);
    }

    @Test
    void given000059_shouldBe000100(){
        int hours = 0;
        int minutes = 0;
        int seconds = 59;
        String expected = "00:01:00";

        String actual = NextSecond.nextSecond(hours, minutes, seconds);

        assertEquals(expected, actual);
    }
}