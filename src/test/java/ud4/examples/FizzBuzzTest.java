package ud4.examples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    @Test
    @DisplayName("FizzBuzz class should exist")
    void fizzBuzzClassShouldExist(){
        FizzBuzz fizzBuzz = new FizzBuzz();
    }

    /*
    @Test
    @DisplayName("FizzBuzz::transform() method should exist")
    void fizzBuzzTransformMethodShouldExist(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.transform();
    }
    */

    @Test
    @DisplayName("FizzBuzz::transfrom() should have an int parameter")
    void fizzBuzzTransformShouldHaveIntParameter(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.transform(1);
    }

    @Test
    @DisplayName("FizzBuzz::transform(1) should return 1")
    void fizzBuzzTransform_given1_shouldReturn1(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        String result = fizzBuzz.transform(1);
        assertEquals("1", result);
    }

    @Test
    @DisplayName("FizzBuzz::transform(2) should return 2")
    void fizzBuzzTransform_given2_shouldReturn2(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        String result = fizzBuzz.transform(2);
        assertEquals("2", result);
    }

    @Test
    @DisplayName("FizzBuzz::transform(3) should return Fizz")
    void fizzBuzzTransform_given3_shouldReturnFizz(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        String result = fizzBuzz.transform(3);
        assertEquals("Fizz", result);
    }

    @Test
    @DisplayName("FizzBuzz::transform(5) should return Buzz")
    void fizzBuzzTransform_given5_shouldReturnBuzz(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        String result = fizzBuzz.transform(5);
        assertEquals("Buzz", result);
    }

    @Test
    @DisplayName("FizzBuzz::transform(6) should return Fizz")
    void fizzBuzzTransform_given6_shouldReturnFizz(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        String result = fizzBuzz.transform(6);
        assertEquals("Fizz", result);
    }

    @Test
    @DisplayName("FizzBuzz::transform(10) should return Buzz")
    void fizzBuzzTransform_given10_shouldReturnBuzz(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        String result = fizzBuzz.transform(10);
        assertEquals("Buzz", result);
    }

    @Test
    @DisplayName("FizzBuzz::transform(15) should return FizzBuzz")
    void fizzBuzzTransform_given15_shouldReturnFizzBuzz(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        String result = fizzBuzz.transform(15);
        assertEquals("FizzBuzz", result);
    }

    @Test
    @DisplayName("FizzBuzz::transform(30) should return FizzBuzz")
    void fizzBuzzTransform_given30_shouldReturnFizzBuzz(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        String result = fizzBuzz.transform(30);
        assertEquals("FizzBuzz", result);
    }
}
