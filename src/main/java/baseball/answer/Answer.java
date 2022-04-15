package baseball.answer;

import java.util.Arrays;
import java.util.HashSet;

import baseball.common.Utils;

public class Answer {
    int[] numbers;

    static final String INVALID_ANSWER_LENGTH = "정답의 길이가 일치하지 않습니다. (expected : %d, actual : %d)";
    static final String INVALID_ANSWER_RANGE = "값이 정답의 범위를 벗어났습니다. (%d <= expected <= %d, actual : %d)";
    static final String DUPLICATE_ANSWER = "정답에 중복 값이 있습니다.";

    // 수동 초기화
    public Answer(int[] numbers){
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    // 초기화 전략
    public Answer(NumberStrategy generator){
        int[] generatedNumbers = generator.generate();
        validateNumbers(generatedNumbers);
        this.numbers = generatedNumbers;
    }

    public static void validateNumbers(int[] numbers){
        validateNumberRange(numbers);
        validateNumberLength(numbers);
        validateNumberDuplicate(numbers);
    }
    public static void validateNumberRange(int[] numbers){
        if (Utils.maxOf(numbers) > AnswerConfig.ANSWER_NUMBER_MAX
        || Utils.minOf(numbers) < AnswerConfig.ANSWER_NUMBER_MIN){
            throw new IllegalArgumentException(
                String.format(
                    INVALID_ANSWER_RANGE,
                    AnswerConfig.ANSWER_NUMBER_MIN,
                    AnswerConfig.ANSWER_NUMBER_MAX,
                    numbers.length
                    ));
        }
    }
    public static void validateNumberLength(int[] numbers){
        if (numbers.length != AnswerConfig.ANSWER_LENGTH){
            throw new IllegalArgumentException(
                String.format(
                    INVALID_ANSWER_LENGTH,
                    AnswerConfig.ANSWER_LENGTH,
                    numbers.length));
        }
    }
    public static void validateNumberDuplicate(int[] numbers){
        HashSet<Integer> numberSet = new HashSet<>();
        for (int number : numbers){
            numberSet.add(number);
        }
        if (numberSet.size() < numbers.length){
            throw new IllegalArgumentException(DUPLICATE_ANSWER);
        }
    }

    public int[] getNumbers(){
        return numbers;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Answer other = (Answer) obj;
        if (!Arrays.equals(numbers, other.numbers))
            return false;
        return true;
    }

    
}
