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
        void constructorSenseParametres(){
            Robot r = new Robot();

            assertAll(
                () -> assertEquals(0, r.getX()),
                () -> assertEquals(0, r.getY()),
                () -> assertEquals(1, r.getSpeed())
            );
        }

        @Test
        void constructorAmbPosicio(){
            Robot r = new Robot(1, 1);

            assertAll(
                    () -> assertEquals(1, r.getX()),
                    () -> assertEquals(1, r.getY()),
                    () -> assertEquals(1, r.getSpeed())
            );
        }

        @Test
        void constructorAmbPosicioVelociat(){
            Robot r = new Robot(1, 1, 5);

            assertAll(
                    () -> assertEquals(1, r.getX()),
                    () -> assertEquals(1, r.getY()),
                    () -> assertEquals(5, r.getSpeed())
            );
        }

        @Test
        void constructorAmbPosicioVelociatNegativa(){
            Robot r = new Robot(1, 1, -5);

            assertAll(
                    () -> assertEquals(1, r.getX()),
                    () -> assertEquals(1, r.getY()),
                    () -> assertEquals(0, r.getSpeed())
            );
        }
        @Test
        void constructorAmbPosicioVelociatMajorMax(){
            Robot r = new Robot(1, 1, 15);

            assertAll(
                    () -> assertEquals(1, r.getX()),
                    () -> assertEquals(1, r.getY()),
                    () -> assertEquals(10, r.getSpeed())
            );
        }
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0.5",
            "1, 1.5",
            "10, 10",
    })
    void accelerate(double initialSpeed, double expectedSpeed){
        Robot r = new Robot(0, 0, initialSpeed);

        r.accelerate();

        assertEquals(expectedSpeed, r.getSpeed());
    }

    @ParameterizedTest
    @CsvSource({
            "10, 9.5",
            "9.5, 9",
            "0, 0",
    })
    void decelerate(double initialSpeed, double expectedSpeed){
        Robot r = new Robot(0, 0, initialSpeed);

        r.decelerate();

        assertEquals(expectedSpeed, r.getSpeed());
    }

    @ParameterizedTest(name="Robot(x={0},y={1},speed={2}).up() -> (x={3},y={4})")
    @CsvSource({
            "0,0,1,0,1",
            "0,1,1,0,2",
            "0,1,2,0,3",
            "-10,-10,2,-10,-8",
    })
    void up(double x, double y, double speed, double expectedX, double expectedY){
        Robot r = new Robot(x, y, speed);

        r.up();

        assertAll(
            () -> assertEquals(expectedX, r.getX()),
            () -> assertEquals(expectedY, r.getY())
        );
    }
}