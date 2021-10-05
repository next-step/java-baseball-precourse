package baseball;

/**
 * Name : BaseBallGameNumberComparator <br/>
 * Description : 야구 게임 숫자 비교하는 기능을 하는 객체
 */
public class BaseBallGameNumberComparator {
    private int maxLength;

    private BaseBallGameNumberComparator() {
        this(BaseBallGame.DEFAULT_LENGTH);
    }

    public BaseBallGameNumberComparator(int maxLength) {
        this.maxLength = maxLength;
    }

    /**
     * 숫자를 비교하여 스트라이크 갯수를 계산하는 함수
     */
    public int getStrikesCount(String randomGenerated, String input) {
        int strikesCount = 0;
        for ( int i = 0 ; i < maxLength ; i++ )
            strikesCount += checkStrike(randomGenerated.charAt(i), input.charAt(i));

        return strikesCount;
    }

    /**
     * 동일한 자리의 숫자를 비교하여, 스트라이크 여부를 판별한다.
     */
    private int checkStrike(char randomGenerated, char input) {
        if (randomGenerated == input)
            return 1;

        return 0;
    }
}
