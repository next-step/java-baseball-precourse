package baseball.game.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;


public class GameNumber {
    public int ANSWER_LENGTH = 3;
    public Set<Integer> answer;

    public GameNumber() {
        this.answer = generateAnswer();
    }

    public Set<Integer> generateAnswer() {
        Set<Integer> answer = new HashSet<>();
        while (answer.size() < ANSWER_LENGTH) {
            int number = generateRandomNumber();
            answer.add(number);
        }
        return answer;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }
}