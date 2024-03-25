package NumberBaseball.model;

import java.util.*;

public class NumberBaseballModel {
    private final List<String> numbers = new ArrayList<>();
    private final int NUMBER_LENGTH = BaseballConfig.BASEBALL_NUMBER_LENGTH;
    private final Set<Integer> numberSet = new HashSet<>();
    private final Random random;

    private boolean gameContinuing = true;

    public NumberBaseballModel(Random random) {
        this.random = random;
        generateNumbers();
    }

    private void generateNumbers() {
        while (numberSet.size() < NUMBER_LENGTH) {
            int newNumber = random.nextInt(9) + 1;
            numberSet.add(newNumber);
        }

        numbers.clear();
        numberSet.forEach(number -> numbers.add(number.toString()));
    }

    public BaseBallCount checkCount(List<String> input) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (numbers.get(i).equals(input.get(i))) {
                strike++;
            }
            if (numberSet.contains(Integer.parseInt(input.get(i)))) {
                ball++;
            }
        }
        ball -= strike;
        return new BaseBallCount(strike, ball);
    }

    public void reset() {
        numbers.clear();
        numberSet.clear();
        generateNumbers();
    }

    public int getNumberLength() {
        return NUMBER_LENGTH;
    }

    public boolean isGameContinuing() {
        return gameContinuing;
    }

    public void setGameContinuing(boolean continuing) {
        this.gameContinuing = continuing;
    }

    public boolean processRestartOption(String option) {
        if ("2".equals(option)) {
            gameContinuing = false;
        } else {
            reset();
            gameContinuing = true;
        }
        return gameContinuing;
    }
}
