package ud4.exercises.objects.shapes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {
    @Nested
    class Constructors {

        @Test
        void testConstructorNoParameters(){
            Circle c = new Circle();

            assertAll(
                () -> assertEquals(0, c.getX()),
                () -> assertEquals(0, c.getY()),
                () -> assertEquals(1, c.getRadius())
            );
        }

        @Test
        void testConstructorWithPosition(){
            Circle c = new Circle(2, 3);

            assertAll(
                    () -> assertEquals(2, c.getX()),
                    () -> assertEquals(3, c.getY()),
                    () -> assertEquals(1, c.getRadius())
            );
        }

        @Test
        void testConstructorWithRadius(){
            Circle c = new Circle(2);

            assertAll(
                    () -> assertEquals(0, c.getX()),
                    () -> assertEquals(0, c.getY()),
                    () -> assertEquals(2, c.getRadius())
            );
        }

        @Test
        void testConstructorWithPositionAndRadius(){
            Circle c = new Circle(1, 2, 3);

            assertAll(
                    () -> assertEquals(1, c.getX()),
                    () -> assertEquals(2, c.getY()),
                    () -> assertEquals(3, c.getRadius())
            );
        }
    }

    @Nested
    class GetArea {
        @Test
        @DisplayName("Circle::getArea() with radius 1")
        void testAreaRadius1(){
            // Arrange
            Circle c = new Circle(1);

            // Act
            double area = c.getArea();

            // Assert
            assertEquals(3.1415, area, 1e-3);
        }

        @Test
        @DisplayName("Circle::getArea() with radius 2")
        void testAreaRadius2(){
            // Arrange
            Circle c = new Circle(2);

            // Act
            double area = c.getArea();

            // Assert
            assertEquals(12.566, area, 1e-3);
        }
    }
}