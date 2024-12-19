package ud4.exercises.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingTurn {
    private final List<Integer> rolls;

    public BowlingTurn() {
        this.rolls = new ArrayList<>();
    }

    public boolean roll(int pins){
        rolls.add(pins);
        return true;
    }
}
