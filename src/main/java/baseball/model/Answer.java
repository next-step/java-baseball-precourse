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


    Result challenge(Trial trial) {
        int strikeCnt = 0;
        int ballCnt = 0;

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
