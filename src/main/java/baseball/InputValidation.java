package baseball;
/**
 * packageName    : baseball
 * fileName       : InputValidation
 * author         : BOM
 * date           : 2022-09-30
 * description    : 사용자의 입력값을 검증하는 class
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-30        BOM       최초 생성
 * 2022-10-02        BOM       validateRegameInputFromUser 추가
 */
public class InputValidation {
    private int gameNumberLength;

    public InputValidation(int length) {
        this.gameNumberLength = length;
    }

    /*사용자가 추측값으로 입력한 input을 검증하는 메서드*/
    public void validateInputNumberFromUser(String input) {

        if (input.equals(""))
            throw new IllegalArgumentException("입력값이 없습니다. " + gameNumberLength + "자리 수를 입력해주세요!!!!");
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("입력값에 숫자가 아닌 값이 포함되어 있습니다. " + gameNumberLength + "자리 숫자를 입력해주세요!!!!");
        }
        if (input.length() != gameNumberLength)
            throw new IllegalArgumentException("입력값의 자리수가 너무 적거나 많습니다. " + gameNumberLength + "자리 수를 입력해주세요!!!!");

    }
    /*사용자가 재게임 의사로 입력한 input을 검증하는 메서드*/
    public void validateRegameInputFromUser(String input) {

        if (input.equals(""))
            throw new IllegalArgumentException("입력값이 없습니다. 1이나 2를 입력해주세요!!!!");
        if (!input.equals("1") && !input.equals("2"))
            throw new IllegalArgumentException("입력값이 1이나 2가 아닙니다. 1이나 2를 입력해주세요!!!!");

    }
}