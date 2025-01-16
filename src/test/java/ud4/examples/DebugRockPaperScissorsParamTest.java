package ud4.examples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DebugRockPaperScissorsParamTest {
    @ParameterizedTest(name="\"{0}\" vs \"{1}\" should be {2}")
    @DisplayName("RockPaperScissors::guanya(j1, j2)")
    @CsvSource({
            "pedra,pedra,0",
            "pedra,paper,2",
            "pedra,tisores,1",
            "paper,pedra,1",
            "paper,paper,0",
            "paper,tisores,2",
            "tisores,pedra,2",
            "tisores,paper,1",
            "tisores,tisores,0",
    })
    void testGuanya(String j1, String j2, int expected) {
        int actual = DebugRockPaperScissors.guanya(j1, j2);

        assertEquals(expected, actual);
    }
}