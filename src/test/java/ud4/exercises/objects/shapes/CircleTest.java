package ud4.exercises.objects.shapes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest(name = "r={0} area should be {1}")
    @DisplayName("Circle::getArea()")
    @CsvSource({
            "1, 3.14159",
            "2, 12.56637",
    })
    void testGetArea(double radius, double expectedArea){
        // Arrange
        Circle c = new Circle(radius);

        // Act
        double area = c.getArea();

        // Assert
        assertEquals(expectedArea, area, 1e-5);
    }

    @ParameterizedTest(name = "r={0} perimeter should be {1}")
    @DisplayName("Circle::getPerimeter()")
    @CsvSource({
            "1, 6.28318",
            "2, 12.56637",
    })
    void testGetPerimeter(double radius, double expectedPerimeter){
        // Arrange
        Circle c = new Circle(radius);

        // Act
        double perimeter = c.getPerimeter();

        // Assert
        assertEquals(expectedPerimeter, perimeter, 1e-5);
    }


    @ParameterizedTest(name = "C(x={0},y={1}) -> ({2}, {3}) = ({4},{5})")
    @DisplayName("Circle::move(x, y)")
    @CsvSource({
            "0,0,0,0,0,0",
            "0,0,1,0,1,0",
            "0,0,0,1,0,1",
            "0,0,-1,0,-1,0",
            "0,0,0,-1,0,-1",
            "0,0,1,1,1,1",
            "1,1,1,2,2,3",
    })
    void testMove(double x1, double y1, double x2, double y2, double expectedX, double expectedY){
        // Arrange
        Circle c = new Circle(x1, y1);

        // Act
        c.move(x2, y2);

        // Assert
        assertAll(
            () -> assertEquals(expectedX, c.getX()),
            () -> assertEquals(expectedY, c.getY())
        );
    }

    @ParameterizedTest(name = "C(r={0},x={1},y={2}) contains ({3}, {4})? {5}")
    @DisplayName("Circle::contains(x, y)")
    @CsvSource({
            "1,0,0,0,0,true",
            "1,0,0,1,0,true",
            "1,0,0,1,1,false",
            "1,0,0,0.6,0.6,true",
            "2,2,-2,0,0,false",
            "2,2,-2,1,-1,true",
    })
    void testContains(double radius, double x1, double y1, double x2, double y2, boolean expectedContains){
        // Arrange
        Circle c = new Circle(x1, y1, radius);

        // Act
        boolean isContained = c.contains(x2, y2);

        // Assert
        assertEquals(expectedContains, isContained);
    }
}
