package baseball.model;

public class Computer {
    private final String number;

    public Computer(String number) {
        this.number = number;
    }

    public int getStrikeCount(String input) {
        int strikeCount = 0;

        for (int i = 0; i < number.length(); i++) {
            strikeCount += equalCount(number.charAt(i), input.charAt(i));
        }

        return strikeCount;
    }

    public int getBallCount(String input) {
        int ballCount = 0;

        for (int i = 0; i < input.length(); i++) {
            ballCount += ballCount(i, input.charAt(i));
        }

        return ballCount;
    }

    private int ballCount(int index, char value) {
        int ballCount = 0;

        for (int i = 0; i < number.length(); i++) {
            ballCount += countIfDifferentPositionEqual(index, i, value);
        }

        return ballCount;
    }

    private int countIfDifferentPositionEqual(
            int inputIndex,
            int computerIndex,
            char value
    ) {
        if (inputIndex != computerIndex) {
            return equalCount(value, number.charAt(computerIndex));
        }

        return 0;
    }

    private int equalCount(char num1, char num2) {
        return num1 == num2 ? 1 : 0;
    }
}
