package baseball.model;

import java.util.Map;

/**
 * 게임 플레이어
 */
public class GamePlayer {

    private final Map<Integer, Integer> number;

    public GamePlayer(NumberGenerator numberGenerator, NumberControl numberControl) {
        number = numberGenerator.generateNumber(numberControl);
    }

    public Map<Integer, Integer> getNumber() {
        return number;
    }
}
