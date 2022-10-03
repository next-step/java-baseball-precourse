package baseball.model;

import java.util.ArrayList;

public class GamePlay {
    private ArrayList<Integer> randomNumbers;

    public GamePlay() {
        randomNumbers = new RandomNumbersGenerator().getRandomNumbers();
    }

    public void run() throws IllegalArgumentException {

    }


}
