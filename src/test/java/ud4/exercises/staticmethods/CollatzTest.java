package ud4.exercises.staticmethods;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollatzTest {

    @Test
    @DisplayName("collatz(1) -> 0")
    void test_given1_shouldReturn0(){
        // Arrange
        int n = 1;
        int expectedSteps = 0;

        // Act
        int actualSteps = Collatz.collatz(n);

        // Assert
        assertEquals(expectedSteps, actualSteps);
    }

    @Test
    @DisplayName("collatz(5) -> 5")
    void test_given5_shouldReturn5(){
        // Arrange
        int n = 5;
        int expectedSteps = 5;

        // Act
        int actualSteps = Collatz.collatz(n);

        // Assert
        assertEquals(expectedSteps, actualSteps);
    }

    @Test
    @DisplayName("collatz(8) -> 3")
    void test_given8_shouldReturn3(){
        // Arrange
        int n = 8;
        int expectedSteps = 3;

        // Act
        int actualSteps = Collatz.collatz(n);

        // Assert
        assertEquals(expectedSteps, actualSteps);
    }

    @Test
    @DisplayName("collatz(11) -> 14")
    void test_given11_shouldReturn14(){
        // Arrange
        int n = 11;
        int expectedSteps = 14;

        // Act
        int actualSteps = Collatz.collatz(n);

        // Assert
        assertEquals(expectedSteps, actualSteps);
    }

    @Test
    @DisplayName("collatz(27) -> 111")
    void test_given27_shouldReturn111(){
        // Arrange
        int n = 27;
        int expectedSteps = 111;

        // Act
        int actualSteps = Collatz.collatz(n);

        // Assert
        assertEquals(expectedSteps, actualSteps);
    }
}