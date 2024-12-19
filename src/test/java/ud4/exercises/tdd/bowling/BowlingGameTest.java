package ud4.exercises.tdd.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ud4.exercises.bowling.BowlingGame;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {
    private BowlingGame bowlingGame;

    @BeforeEach
    void setup(){
        this.bowlingGame = new BowlingGame();
    }

    @Nested
    class RollTests {
        @Test
        void givenValidRoll_shouldReturnTrue(){
            boolean result = bowlingGame.roll(5);
            assertTrue(result);
        }
        @Test
        void givenLessThan0Roll_shoudReturnFalse(){
            boolean result = bowlingGame.roll(-1);
            assertFalse(result);
        }
        @Test
        void givenMoreThan10Roll_shoudReturnFalse(){
            boolean result = bowlingGame.roll(15);
            assertFalse(result);
        }
        @Test
        void givenRollMoreThanAvailablePins_shoudReturnFalse(){
            bowlingGame.roll(5);
            boolean result = bowlingGame.roll(7);

            assertFalse(result);
        }
        @Test
        void givenRollAfterStrike_shoudBeTrue(){
            bowlingGame.roll(10);
            boolean result = bowlingGame.roll(7);

            assertTrue(result);
        }
    }

    @Nested
    class ScoreTests {

        @Test
        void givenNoRolls_scoreShouldBe0(){
            int expected = 0;

            int actual = bowlingGame.score();

            assertEquals(expected, actual);
        }

        @Test
        void givenRoll5_scoreShouldBe5(){
            int expected = 5;

            bowlingGame.roll(5);
            int actual = bowlingGame.score();

            assertEquals(expected, actual);
        }

        @Test
        void givenRoll7_scoreShouldBe7(){
            int expected = 7;

            bowlingGame.roll(7);
            int actual = bowlingGame.score();

            assertEquals(expected, actual);
        }

        @Test
        void givenMultipleValidRolls_shouldReturnAddition(){
            int expected = 8;

            bowlingGame.roll(3);
            bowlingGame.roll(5);
            int actual = bowlingGame.score();

            assertEquals(expected, actual);
        }

        @Test
        void givenLessThan0Roll_shoudNotScore(){
            int expected = 0;

            bowlingGame.roll(-1);
            int actual = bowlingGame.score();

            assertEquals(expected, actual);
        }

        @Test
        void givenMoreThan10_shoudNotScore(){
            int expected = 0;

            bowlingGame.roll(15);
            int actual = bowlingGame.score();

            assertEquals(expected, actual);
        }
    }
}