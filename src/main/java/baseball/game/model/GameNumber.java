package baseball.game.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;


public class GameNumber {
    public int ANSWER_LENGTH = 3;
    public List<Integer> answer;

    public GameNumber() {
        this.answer = generateAnswer();
    }

    private List<Integer> generateAnswer() {
        Set<Integer> answer = new HashSet<>();
        while (answer.size() < ANSWER_LENGTH) {
            int number = generateRandomNumber();
            answer.add(number);
        }
        List<Integer> answerList = new ArrayList<Integer>();
        for (Integer x : answer)
            answerList.add(x);
        return answerList;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }
}