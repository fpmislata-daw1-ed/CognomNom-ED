package ud4.examples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DebugRockPaperScissorsTest {

    @Nested
    class Empat {

        @Test
        @DisplayName("Empat: Pedra vs Pedra")
        void testEmpatPedraPedra() {
            int expected = 0;
            int actual = DebugRockPaperScissors.guanya("pedra", "pedra");

            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Empat: Paper vs Paper")
        void testEmpatPaperPaper() {
            int expected = 0;
            int actual = DebugRockPaperScissors.guanya("paper", "paper");

            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Empat: Tisores vs Tisora")
        void testEmpatTisoresTisora() {
            int expected = 0;
            int actual = DebugRockPaperScissors.guanya("tisores", "tisores");

            assertEquals(expected, actual);
        }
    }

    @Nested
    class Jugador1 {

        @Test
        @DisplayName("Jugador 1 guanya: Pedra vs Tisores")
        void testJugador1GuanyaPedraTisores() {
            int expected = 1;
            int actual = DebugRockPaperScissors.guanya("pedra", "tisores");

            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Jugador 1 guanya: Paper vs Pedra")
        void testJugador1GuanyaPaperPedra() {
            int expected = 1;
            int actual = DebugRockPaperScissors.guanya("paper", "pedra");

            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Jugador 1 guanya: Tisores vs Paper")
        void testJugador1GuanyaTisoresPaper() {
            int expected = 1;
            int actual = DebugRockPaperScissors.guanya("tisores", "paper");

            assertEquals(expected, actual);
        }
    }

    @Nested
    class Jugador2 {

        @Test
        @DisplayName("Jugador 2 guanya: Tisores vs Pedra")
        void testJugador2GuanyaTisoresPedra() {
            int expected = 2;
            int actual = DebugRockPaperScissors.guanya("tisores", "pedra");

            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Jugador 2 guanya: Pedra vs Paper")
        void testJugador2GuanyaPedraPaper() {
            int expected = 2;
            int actual = DebugRockPaperScissors.guanya("pedra", "paper");

            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Jugador 2 guanya: Paper vs Tisores")
        void testJugador2GuanyaPaperTisores() {
            int expected = 2;
            int actual = DebugRockPaperScissors.guanya("paper", "tisores");

            assertEquals(expected, actual);
        }
    }
}