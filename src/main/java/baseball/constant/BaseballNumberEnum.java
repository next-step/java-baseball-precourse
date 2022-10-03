package baseball.constant;

public enum BaseballNumberEnum {

    // conditions
    MAX_DIGIT(3),
    BEGINNING_CHARACTER(0),
    TARGET_LENGTH_FOR_CHECKING_STRING(1),

    // array related
    INDEX_ZERO(0),
    INDEX_ONE(1),
    INDEX_ONE_HUNDRED(100),
    INDEX_FOR_BALL(0),
    INDEX_FOR_STRIKE(1),


    NUMBER_START(1),
    NUMBER_END(9);

    public final Integer intValue;

    BaseballNumberEnum(int intValue) {
        this.intValue = intValue;
    }
}
