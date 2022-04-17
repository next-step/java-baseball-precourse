package baseball.model;

public class Answer {
    private final String answer;

    public Answer(String line) {
        if (line.length() != 3)
            throw new IllegalArgumentException("Answer numbers should be three");
        if (line.charAt(0) == line.charAt(1) || line.charAt(0) == line.charAt(2) || line.charAt(1) == line.charAt(2))
            throw new IllegalArgumentException("Answer numbers are different.");
        for (int i = 0; i < line.length(); i++)
            validateRange(line.charAt(i));

        this.answer = line;
    }

    private void validateRange(char c) {
        if (c < '1' || c > '9')
            throw new IllegalArgumentException("Trial number range is between 1 and 9.");
    }

    /**
     * Answer & Trial 모두 크기가 3 이고 서로 모두 다름을 보장 하므로 N^2 알고리즘을 사용한다.
     * @param trial 정답을 맞추기 위한 시도 (숫자가 모두 다름이 보장된다.)
     * @return strike & ball 정보가 기록된 결과
     */
    Result challenge(Trial trial) {
        int strikeCnt = 0, ballCnt = 0;
        for (int i = 0; i < answer.length(); i++) {
            char trialNumber = trial.get(i);
            if (answer.charAt(i) == trialNumber)
                strikeCnt++;
            else if (answer.contains(Character.toString(trialNumber)))
                ballCnt++;
        }
        return new Result(strikeCnt, ballCnt);
    }
}
