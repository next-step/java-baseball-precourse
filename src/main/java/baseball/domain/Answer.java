package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Answer {

    private List<Integer> numberList;

    public static Answer createAnswer() {
        Answer answer = new Answer();

        List<Integer> numberList = createNumberList();
        answer.setNumberList(numberList);

        return answer;
    }

    private static List<Integer> createNumberList() {
        List<Integer> numberList = new ArrayList<>();

        while (numberList.size() < 3) {
            int candidate = Randoms.pickNumberInRange(1, 9);
            setRandomNumber(numberList, candidate);
        }

        return numberList;
    }

    private static void setRandomNumber(List<Integer> numberList, int candidateNumber) {
        if (!isDuplicate(numberList, candidateNumber)) {
            numberList.add(candidateNumber);
        }
    }

    private static boolean isDuplicate(List<Integer> numberList, int candidateNumber) {
        return numberList.contains(candidateNumber);
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    private void setNumberList(List<Integer> numberList) {
        this.numberList = numberList;
    }

    public Map<Hint, Integer> verifyAnswer(Candidate candidate) {
        Map<Hint, Integer> hintMap = new HashMap<>();

        for (int index = 0; index < numberList.size(); index++) {
            int answerNumber = numberList.get(index);
            Hint hint = getHint(index, answerNumber, candidate);
            hintMap.put(hint, hintMap.getOrDefault(hint, 0) + 1);
        }

        return hintMap;
    }

    private Hint getHint(int index, int number, Candidate candidate) {
        List<Integer> candidateNumberList = candidate.getNumberList();

        Hint strike = getStrike(index, number, candidateNumberList);
        if (strike != null) return strike;

        Hint ball = getBall(number, candidateNumberList);
        if (ball != null) return ball;

        return Hint.아웃;
    }

    private Hint getBall(int number, List<Integer> candidateNumberList) {
        if (candidateNumberList.contains(number)) {
            return Hint.볼;
        }
        return null;
    }

    private Hint getStrike(int index, int number, List<Integer> candidateNumberList) {
        Integer candidateNumber = candidateNumberList.get(index);
        if (candidateNumber == number) {
            return Hint.스트라이크;
        }
        return null;
    }

    public void setNumberListForTest(List<Integer> numberList) {
        this.numberList = numberList;
    }

    @Override
    public String toString() {
        return "AnswerNumber{" +
                "numberList=" + numberList +
                '}';
    }
}
