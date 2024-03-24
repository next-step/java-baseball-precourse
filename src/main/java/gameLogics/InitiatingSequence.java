package gameLogics;

import dto.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InitiatingSequence {
    public static List<Integer> generateAnswer(){
        List<Integer> result = new ArrayList<>();
        Random random = new Random(System.currentTimeMillis());
        int count = -1;
        while (++count < BaseRule.GAME_NUMBER_LENGTH) {
            int randInt = ((random.nextInt()% 9) + 1);
            if (randInt < 0)
                randInt *= -1;
            if (result.contains(randInt))
                continue;
            result.add(randInt);
        }
        return result;
    }
    public static State getInitialState() {
        return new State();
    }
}
