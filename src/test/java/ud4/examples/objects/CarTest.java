package ud4.examples.objects;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Nested
    class Constructors {
        @Test
        void testConstructorWithPlate(){
            // Arrange
            String plate = "0000 BBB";
            int expectedKilometers = 0;

            // Act
            Car car = new Car(plate);

            // Assert
            assertAll(
                () -> assertEquals(plate, car.getPlate()),
                () -> assertEquals(expectedKilometers, car.getKilometers())
            );
        }

        @Test
        void testConstructorWithPlateAndKilometers(){
            // Arrange
            String plate = "0000 BBB";
            int kilometers = 100;

            // Act
            Car car = new Car(plate, kilometers);

            // Assert
            assertAll(
                    () -> assertEquals(plate, car.getPlate()),
                    () -> assertEquals(kilometers, car.getKilometers())
            );
        }
    }

    @Nested
    @DisplayName("Car::accelerate()")
    class AccelerateWithoutParameters {
        private Car car;

        @BeforeEach
        void setup(){
            car = new Car("0000 BBB");
        }

        @Test
        void testSingleAccelerate(){
            // Arrange
            int expectedSpeed = 5;

            // Act
            car.accelerate();

            // Assert
            assertEquals(expectedSpeed, car.getSpeed());
        }

        @Test
        void testMultipleAccelerate(){
            // Arrange
            int expectedSpeed = 10;

            // Act
            car.accelerate();
            car.accelerate();

            // Assert
            assertEquals(expectedSpeed, car.getSpeed());
        }
    }

    @Nested
    @DisplayName("Car::accelerate(int speed)")
    class AccelerateWithParameters {
        private Car car = new Car("0000 BBB");

        @Test
        void testSingleAccelerate(){
            // Arrange
            int expectedSpeed = 5;

            // Act
            car.accelerate(5);

            // Assert
            assertEquals(expectedSpeed, car.getSpeed());
        }

        @Test
        void testMultipleAccelerate(){
            // Arrange
            int expectedSpeed = 10;

            // Act
            car.accelerate(3);
            car.accelerate(7);

            // Assert
            assertEquals(expectedSpeed, car.getSpeed());
        }

    }
}