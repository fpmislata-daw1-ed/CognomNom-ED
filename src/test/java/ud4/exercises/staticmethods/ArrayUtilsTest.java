package ud4.exercises.staticmethods;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilsTest {
    @Nested
    class MinTests {

        @Test
        void testNombresPositiusOrdenatsAcendetment(){
            // AAA
            // Arrange
            int[] array = {1, 2, 3, 4};
            int expectedResult = 1;

            // Act
            int actualResult = ArrayUtils.min(array);

            // Assert
            assertEquals(expectedResult, actualResult);
        }

        @Test
        void testNombresPositiusOrdenatsDescendentment(){
            // AAA
            // Arrange
            int[] array = {4, 3, 2, 1};
            int expectedResult = 1;

            // Act
            int actualResult = ArrayUtils.min(array);

            // Assert
            assertEquals(expectedResult, actualResult);
        }
    }
}