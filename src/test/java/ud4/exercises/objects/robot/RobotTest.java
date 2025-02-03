package ud4.exercises.objects.robot;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    @Nested
    class ConstructorsTest {
        @Test
        void defaultConstructor(){
            Robot robot = new Robot();

            assertAll(
                    () -> assertEquals(0, robot.getX()),
                    () -> assertEquals(0, robot.getY()),
                    () -> assertEquals(1, robot.getSpeed())
            );
        }

        @Test
        void constructorWithParams(){
            Robot robot = new Robot(1, 1);

            assertAll(
                    () -> assertEquals(1, robot.getX()),
                    () -> assertEquals(1, robot.getY()),
                    () -> assertEquals(1, robot.getSpeed())
            );
        }
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0.5",
            "1.5, 2.0",
            "10.0, 10.0",
    })
    void testAccelerate(double initialSpeed, double expectedSpeed){
        Robot r = new Robot(0, 0, initialSpeed);

        r.accelerate();

        assertEquals(expectedSpeed, r.getSpeed());
    }

    @ParameterizedTest
    @CsvSource({
            "5.0, 4.5",
            "1.5, 1.0",
            "0.0, 0.0",
    })
    void testDecelerate(double initialSpeed, double expectedSpeed){
        Robot r = new Robot(0, 0, initialSpeed);

        r.decelerate();

        assertEquals(expectedSpeed, r.getSpeed());
    }


    @ParameterizedTest
    @CsvSource({
            "0,0,1,0,1",
            "0,0,2,0,2",
            "0,-1,1,0,0",
    })
    void testUp(double initialX, double initalY, double speed, double expectedX, double expectedY){
        Robot r = new Robot(initialX, initalY, speed);

        r.up();

        assertAll(
                () -> assertEquals(expectedX, r.getX()),
                () -> assertEquals(expectedY, r.getY())
        );
    }
}