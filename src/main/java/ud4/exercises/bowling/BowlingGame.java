package ud4.exercises.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private final List<Integer> rolls;
    private int currentTurn;
    private int previousRoll;

    public BowlingGame(){
        rolls = new ArrayList<>();
        currentTurn = 0;
        previousRoll = -1;
    }

    public boolean roll(int pins){
        if (pins < 0 || pins > 10)
            return false;

        if(previousRoll != -1){
            int currentTurnScore = previousRoll + pins;
            if (currentTurnScore > 10)
                return false;
        }

        rolls.add(pins);

        if (previousRoll != -1)
            previousRoll = pins;
        else
            previousRoll = -1;

        return true;
    }

    public int score(){
        int score = 0;
        for (int i = 0; i < rolls.size(); i++) {
            score += rolls.get(i);
        }
        return score;
    }
}
