package baseball;

import nextstep.utils.Randoms;
import utils.BaseballUtils;

import java.util.*;
import java.util.regex.Pattern;

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
            addNumberOnlyDistinct(numbers, picked);
        }

        return BaseballUtils.toIntArray(numbers);
    }

    private static void addNumberOnlyDistinct(List<Integer> numbers, int picked) {
        if (!numbers.contains(picked)) numbers.add(picked);
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
        Set<String> inputNumberSet = new HashSet<>(Arrays.asList(input.split("")));
        return inputNumberSet.size() == ANSWER_DIGIT;
    }

    private static int addCountOnlyContained(int[] userInput, List<Integer> answerNumbers, int count, int i) {
        if (answerNumbers.contains(userInput[i])) count++;
        return count;
    }

    void grade(int[] userInput) {
        int containCount = containCount(userInput);
        strikeCount = calculateStrikeCount(userInput);
        if (containCount > strikeCount) ballCount = containCount - strikeCount;
    }

    private int containCount(int[] userInput) {
        List<Integer> answerNumbers = getAnswerNumberList();

        int count = 0;
        for (int i = 0; i < ANSWER_DIGIT; i++) count = addCountOnlyContained(userInput, answerNumbers, count, i);

        return count;
    }

    private List<Integer> getAnswerNumberList() {
        List<Integer> answerNumbers = new ArrayList<>(answer.length);
        for (int i : answer) answerNumbers.add(i);

        return answerNumbers;
    }

    private int calculateStrikeCount(int[] userInput) {
        int count = 0;
        for (int i = 0; i < ANSWER_DIGIT; i++) count = addCountPositionAndValueMatched(userInput, count, i);
        return count;
    }

    private int addCountPositionAndValueMatched(int[] userInput, int count, int i) {
        if (answer[i] == userInput[i]) count++;
        return count;
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
