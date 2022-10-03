package baseball.enums;

public enum BaseballOption {

    RESTART(1),
    END(2),
    NUMBERS_LENGTH(3)
    ;

    private final int number;


    BaseballOption(int value){this.number = value;}
    public int getNumber() {
        return number;
    }

}
