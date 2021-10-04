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
}
