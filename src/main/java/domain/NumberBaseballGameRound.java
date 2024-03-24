package domain;

import domain.dto.GameResult;
import util.numberGenerator.NumberGenerator;

import java.util.*;

public class NumberBaseballGameRound {
    private final NumberGenerator numberGenerator;
    private boolean roundStatus;
    private final List<Integer> answer = new ArrayList<>();

    public NumberBaseballGameRound(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }


    /**
     * Public methods
     */
    public void init() {
        answer.clear();
        answer.addAll(numberGenerator.generateNumbersBetween(1, 9, 3));
        roundStatus = true;
    }

    public GameResult judge(List<Integer> input) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < input.size(); i++) {
            if (!isStrike(input, i)) {
                ballCount += isBall(input, i);
                continue;
            }
            strikeCount += 1;
        }

        return new GameResult(strikeCount, ballCount);
    }

    public void finish() {
        this.roundStatus = false;
    }

    public boolean isFinished() {
        return !this.roundStatus;
    }


    /**
     * Getter
     */
    public List<Integer> getAnswer() {
        return answer;
    }


    /**
     * Private methods
     */
    private boolean isStrike(List<Integer> input, int i) {
        return answer.get(i).equals(input.get(i));
    }

    private int isBall(List<Integer> input, int i) {
        int num = input.get(i);

        if (answer.contains(num)) {
            return 1;
        }

        return 0;
    }
}
