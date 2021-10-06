package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Counting {

    public List<Integer> forRemove;
    public int strikeCnt;
    public int ballCnt;

    public Counting() {
        this.strikeCnt = 0;
        this.ballCnt = 0;
        forRemove = new ArrayList<>();
    }

    public Boolean isCorrectAnswer(String userInput, Integer answerNum) {
        return Integer.parseInt(userInput) - answerNum == 0;
    }

    public Integer strikeCounting(List<Integer> answerNumList, List<Integer> inputNumList) {
        for (int i = 0; i < answerNumList.size(); i++) {
            addStrikeCnt(answerNumList, inputNumList, i);
        }
        inputNumList.removeAll(forRemove);
        return strikeCnt;
    }

    public void addStrikeCnt(List<Integer> answerNumList, List<Integer> inputNumList, Integer idx) {
        if (answerNumList.get(idx).equals(inputNumList.get(idx))) {
            strikeCnt++;
            inputNumList.set(idx, -1);
        }
    }

    public Integer ballCounting(List<Integer> answerNumList, List<Integer> inputNumList) {
        for (int i = 0; i < inputNumList.size(); i++) {
            addBallCnt(answerNumList, inputNumList, i);
        }
        return ballCnt;
    }

    public void addBallCnt(List<Integer> answerNumList, List<Integer> inputNumList, Integer idx) {
        if (answerNumList.contains(inputNumList.get(idx))) {
            ballCnt++;
        }
    }

    public void clearCnt() {
        forRemove = new ArrayList<>();
        forRemove.add(-1);
        strikeCnt = 0;
        ballCnt = 0;
    }
}
