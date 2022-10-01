package baseball.model;

/**
 * 숫자 생성기 사용시 필요한 설정값
 */
public class NumberControl {

    private final int numberTotalLength; // 숫자의 총 자리수(1 ~ 9까지 사용 가능)
    private final int startInclusive; // 각 자리수에 들어갈 수 있는 가장 작은 숫자
    private final int endInclusive; // 각 자리수에 들어갈 수 있는 가장 큰 숫자

    public NumberControl(int numberTotalLength, int startInclusive, int endInclusive) {
        validateNumberLength(numberTotalLength);
        validateNumberRange(startInclusive, endInclusive);
        this.numberTotalLength = numberTotalLength;
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
    }

    public int getNumberTotalLength() {
        return numberTotalLength;
    }

    public int getStartInclusive() {
        return startInclusive;
    }

    public int getEndInclusive() {
        return endInclusive;
    }

    /**
     * 숫자 생성 시, 각 자리에 들어갈 수 있는 최소/최대 수 validation
     * @param startInclusive 각 자리수에 들어갈 수 있는 가장 작은 숫자
     * @param endInclusive 각 자리수에 들어갈 수 있는 가장 큰 숫자
     */
    private static void validateNumberRange(final int startInclusive, final int endInclusive) {
        validateStartNumberRange(startInclusive);
        validateEndNumberRange(endInclusive);
        if (startInclusive > endInclusive) {
            throw new IllegalArgumentException("startInclusive cannot be greater than endInclusive.");
        }
    }

    /**
     * 숫자 생성 시, 각 자리에 들어갈 수 있는 최소 수 validation
     * @param startInclusive 각 자리수에 들어갈 수 있는 가장 작은 숫자
     */
    private static void validateStartNumberRange(final int startInclusive) {
        if(startInclusive > 9) {
            throw new IllegalArgumentException("startInclusive cannot be greater then 9.");
        }
        if(startInclusive < 1) {
            throw new IllegalArgumentException("startInclusive cannot be less then 1.");
        }
    }

    /**
     * 숫자 생성 시, 각 자리에 들어갈 수 있는 최대 수 validation
     * @param endInclusive 각 자리수에 들어갈 수 있는 가장 큰 숫자
     */
    private static void validateEndNumberRange(final int endInclusive) {
        if(endInclusive > 9) {
            throw new IllegalArgumentException("endInclusive cannot be greater then 9.");
        }
        if(endInclusive < 1) {
            throw new IllegalArgumentException("endInclusive cannot be less then 1.");
        }
    }

    /**
     * 숫자 생성 시, 가질 자리수 validation - 1~9 사이의 값을 갖도록 함
     * @param numberTotalLength 숫자 자리수
     */
    private static void validateNumberLength(final int numberTotalLength) {
        if(numberTotalLength > 9) { // int의 최대값은 2,147,483,647로, 각 자리별로 동일한 startInclusize/endIncludesize를 갖도록 9자리까지 허용
            throw new IllegalArgumentException("numberTotalLength cannot be greater than 9.");
        }
        if(numberTotalLength < 1) {
            throw new IllegalArgumentException("numberTotalLength cannot be less than 1.");
        }
    }
}
