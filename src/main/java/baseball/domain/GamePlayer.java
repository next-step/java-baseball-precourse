package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GamePlayer {

    private Balls input;

    public GamePlayer() {
        input = new Balls();

    }

    public void settingPlayerBalls(String inputNumber) {
        input.setBalls(convertStringToListInt(inputNumber));
    }

    public List<Integer> convertStringToListInt(String inputNumber) {
        String[] values = inputNumber.split("");
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            res.add(Integer.parseInt(values[i]));
        }
        return res;
    }

    public String getBallsNumber() {
        return input.toString();
    }

    public Balls getBalls() {
        return input;
    }


}
