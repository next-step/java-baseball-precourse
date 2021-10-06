package baseball;

/**
 * Name : InputNumberValidator <br/>
 * Description : 게임 사용자 입력 숫자 검증하는 객체
 */
public class InputNumberValidator {
    /**
     * 게임 유저 입력 숫자를 검증하느 메소드
     * 1. null check
     * 2. length(3) check
     * 3. 1-9 number check
     * 4. 같은 숫자 있는지 check
     * */
    public boolean validate(String input) {
        if (isNull(input)) return false;
        if (lengthCheck(input)) return false;
        if (isValideInputNumberOneToNine(input)) return false;
        if (isSameNumbers(input)) return false;
        return true;
    }

    /**
     * 같은 숫자가 들어 있는지 여부 반환 메소드
     */
    private boolean isSameNumbers(String input) {
        char[] inputArray = input.toCharArray();
        boolean result = false;

        for (int i = 0; i< input.length(); i++) {
            result = result||checkSameNumber(input.charAt(i), inputArray);
        }
        return result;
    }

    /**
     * 같은 숫자가 있는지 체크
     */
    private boolean checkSameNumber(char input, char[] inputArray) {
        int sameNumberCount = 0;

        for(char data : inputArray) {
            sameNumberCount = getSameNumberCount(input, sameNumberCount, data);
        }
        return sameNumberCount > 1;
    }

    /**
     * 같은 숫자 수량 카운트
     */
    private int getSameNumberCount(char input, int sameNumberCount, char data) {
        if(data == input) sameNumberCount++;
        return sameNumberCount;
    }

    /**
     * 1-9까지 숫자 여부 반환하는 메소드
     */
    private boolean isValideInputNumberOneToNine(String input) {
        boolean result = false;

        for (int i = 0; i< input.length(); i++) {
            int number = input.charAt(i)-'0';
            result = result||checkNumberOneToNine(number); //OR조건으로 true(1-9아님)가 있으면 true리턴
        }
        return result;
    }

    /**
     * 1~9까지 수 체크 결과 메소드
     */
    private boolean checkNumberOneToNine(int number) {
        if(!(number >= 1 && number <= 9)) {
            return true;
        }
        return false;
    }

    /**
     * 길이 체크
     */
    private boolean lengthCheck(String input) {
        return input.length() != BaseBallGame.DEFAULT_LENGTH;
    }

    /**
     * null 체크
     * @param input
     * @return
     */
    private boolean isNull(String input) {
        return input == null;
    }
}
