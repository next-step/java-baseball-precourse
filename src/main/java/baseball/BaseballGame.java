package baseball;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class BaseballGame {
    private static final int ANSWER_DIGIT = 3;

    private final int[] answer;
    private boolean finished;
    private int strikeCount;
    private int ballCount;

    BaseballGame(int[] numbers) {
        answer = numbers;
        strikeCount = 0;
        ballCount = 0;
        finished = false;
    }

    static int[] generateGameAnswer() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < ANSWER_DIGIT) {
            int picked = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(picked)) numbers.add(picked);
        }

        return toIntArray(numbers);
    }

    private static int[] toIntArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) arr[i] = list.get(i);

        return arr;
    }

    static boolean isValid(String userInput) {
        if (!consistOfDistinctValue(userInput)) return false;
        return isThreeDigitNumber(userInput);
    }

    private static boolean isThreeDigitNumber(String input) {
        final String THREE_DIGIT_NUMBER_PATTERN = "^[1-9]{3}$";
        return Pattern.matches(THREE_DIGIT_NUMBER_PATTERN, input);
    }

    private static boolean consistOfDistinctValue(String input) {
        return Arrays.stream(input.split("")).collect(Collectors.toSet()).size() == ANSWER_DIGIT;
    }

    void grade(int[] userInput) {
        int containCount = containCount(userInput);
        strikeCount = calculateStrikeCount(userInput);
        if (containCount > strikeCount) ballCount = containCount - strikeCount;
    }

    private int containCount(int[] userInput) {
        Set<Integer> answerNumberSet = Arrays.stream(answer).boxed().collect(Collectors.toSet());
        return (int) Arrays.stream(userInput).boxed().filter(answerNumberSet::contains).count();
    }

    private int calculateStrikeCount(int[] userInput) {
        return (int) IntStream.range(0, answer.length)
                .filter(i -> answer[i] == userInput[i])
                .count();
    }

    boolean nonMatch() {
        return strikeCount == 0 && ballCount == 0;
    }

    boolean allMatch() {
        return strikeCount == ANSWER_DIGIT;
    }

    int getStrikeCount() {
        return strikeCount;
    }

    int getBallCount() {
        return ballCount;
    }

    boolean isFinished() {
        return finished;
    }

    void complete() {
        finished = true;
    }

    void initGrade() {
        strikeCount = 0;
        ballCount = 0;
    }
}
