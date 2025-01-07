package ud4.exercises.staticmethods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NextSecondTest {
    @Test
    void testAddSecond(){
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        String expected = "00:00:01";

        String actual = NextSecond.nextSecond(hours, minutes, seconds);

        assertEquals(expected, actual);
    }

    @Test
    void testAnotherAddSecond(){
        int hours = 0;
        int minutes = 0;
        int seconds = 1;
        String expected = "00:00:02";

        String actual = NextSecond.nextSecond(hours, minutes, seconds);

        assertEquals(expected, actual);
    }

    @Test
    void testNextMinute(){
        int hours = 0;
        int minutes = 0;
        int seconds = 59;
        String expected = "00:01:00";

        String actual = NextSecond.nextSecond(hours, minutes, seconds);

        assertEquals(expected, actual);
    }

    @Test
    void testNextHour(){
        int hours = 0;
        int minutes = 59;
        int seconds = 59;
        String expected = "01:00:00";

        String actual = NextSecond.nextSecond(hours, minutes, seconds);

        assertEquals(expected, actual);
    }

    @Test
    void testNextDay(){
        int hours = 23;
        int minutes = 59;
        int seconds = 59;
        String expected = "00:00:00";

        String actual = NextSecond.nextSecond(hours, minutes, seconds);

        assertEquals(expected, actual);
    }
}