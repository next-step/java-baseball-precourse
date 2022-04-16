package baseball.model;

public class Trial {
    private final String trial;

    public Trial(String line) {
        if (line.length() != 3)
            throw new IllegalArgumentException("Trial numbers should be three");
        if (line.charAt(0) == line.charAt(1) || line.charAt(0) == line.charAt(2) || line.charAt(1) == line.charAt(2))
            throw new IllegalArgumentException("Trial numbers are different.");
        for (int i = 0; i < line.length(); i++)
            validateRange(line.charAt(i));

        this.trial = line;
    }

    private void validateRange(char c) {
        if (c < '1' || c > '9')
            throw new IllegalArgumentException("Trial number range is between 1 and 9.");
    }

    char get(int idx) {
        if (idx < 0 || idx > 2)
            throw new IllegalArgumentException("Range should be 0~2.");
        return trial.charAt(idx);
    }
}
