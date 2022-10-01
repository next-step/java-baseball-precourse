package baseball.model;

import java.util.HashMap;
import java.util.Map;

/**
 * readLine()을 통한 숫자 생성기
 */
public class ReadLineNumberGenerator implements NumberGenerator{

    private final Map<Integer, Integer> generateNumber = new HashMap<>(); // 각 자리수가 서로 달라야 하므로 List가 아닌 Map 사용 (key: 숫자, value: 해당 숫자가 존재하는 자리)
    private final String readNumber;

    public ReadLineNumberGenerator(String readNumber) {
        this.readNumber = readNumber;
    }

    @Override
    public Map<Integer, Integer> generateNumber(NumberControl numberControl) {
        validateNumber(readNumber, numberControl);
        return generateNumber;
    }

    /**
     * 입력받은 숫자 validation
     * @param readNumber 입력받은 문자열로 된 숫자
     * @param numberControl 숫자 생성기 사용시 필요한 설정값
     */
    private void validateNumber(String readNumber, NumberControl numberControl) {
        int startInclusive = numberControl.getStartInclusive();
        int endInclusive = numberControl.getEndInclusive();
        for(char c: readNumber.toCharArray()) {
            int number = c - '0';
            validateNumberRange(number, startInclusive, endInclusive);
            validateNumberDuplicate(number);
            generateNumber.putIfAbsent(number, generateNumber.size() + 1);
        }
        validateNumberLength(generateNumber.size(), numberControl.getNumberTotalLength());
    }

    /**
     * 입력받은 숫자 자리수 validation
     * @param numberLength 입력받은 숫자의 자리수
     * @param expectLength 기대하는 숫자의 자리수(numberTotalLength)
     */
    private void validateNumberLength(int numberLength, int expectLength) {
        if(numberLength != expectLength) {
            throw new IllegalArgumentException(expectLength + "자리수의 숫자를 입력해주세요.");
        }
    }

    /**
     * 중복된 숫자 validation
     * @param number
     */
    private void validateNumberDuplicate(int number) {
        if(generateNumber.containsKey(number)) {
            throw new IllegalArgumentException("중복된 숫자는 허용하지 않습니다.");
        }
    }

    /**
     * 각 자리의 숫자가 startInclusize ~ endInclusive 사이 숫자인지 확인하는 validation
     * @param number
     * @param startInclusive 각 자리수에 들어갈 수 있는 가장 작은 숫자
     * @param endInclusive 각 자리수에 들어갈 수 있는 가장 큰 숫자
     */
    private void validateNumberRange(int number, int startInclusive, int endInclusive) {
        if(number < startInclusive) {
            throw new IllegalArgumentException("각 자리의 숫자는 " + startInclusive + "보다 작을 수 없습니다.");
        }
        if(number > endInclusive) {
            throw new IllegalArgumentException("각 자리의 숫자는 " + endInclusive + "보다 클 수 없습니다.");
        }
    }
}
