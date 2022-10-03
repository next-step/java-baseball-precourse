package baseball.game.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;


public class GameNumber {
    public int ANSWER_LENGTH = 3;

    public void generateAnswer() {
        HashSet<Integer> answer = new HashSet<>();
        while (answer.size() < ANSWER_LENGTH) {
            int number = generateRandomNumber();
            answer.add(number);
        }
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }
}
