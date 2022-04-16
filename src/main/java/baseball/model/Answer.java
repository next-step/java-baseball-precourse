package baseball.model;

import java.util.List;

public class Answer {
    private List<Integer> answer;

    public Answer(List<Integer> answer) {
        if (answer.size() != 3)
            throw new IllegalArgumentException("Answer numbers should be three");
        if (answer.get(0).equals(answer.get(1)) ||
                answer.get(0).equals(answer.get(2)) ||
                answer.get(1).equals(answer.get(2)))
            throw new IllegalArgumentException("Answer numbers are different.");
        this.answer = answer;
    }

    Result challenge(Trial trial) {
        int strikeCnt = 0;
        int ballCnt = 0;

        for (int i = 0; i < answer.size(); i++) {
            int trialNumber = trial.get(i);
            if (answer.get(i) == trialNumber)
                strikeCnt++;
            else if (answer.contains(trialNumber))
                ballCnt++;
        }

        return new Result(strikeCnt, ballCnt);
    }
}
