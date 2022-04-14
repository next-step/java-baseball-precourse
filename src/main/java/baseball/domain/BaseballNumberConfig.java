package baseball.domain;

public class BaseballNumberConfig {
    private final int startRandomNumber;
    private final int endRandomNumber;
    private final int numberCount;

    public BaseballNumberConfig(int startRandomNumber, int endRandomNumber, int numberCount) {
        this.startRandomNumber = startRandomNumber;
        this.endRandomNumber = endRandomNumber;
        this.numberCount = numberCount;
    }

    public int getStartRandomNumber() {
        return startRandomNumber;
    }

    public int getEndRandomNumber() {
        return endRandomNumber;
    }

    public int getNumberCount() {
        return numberCount;
    }
}
