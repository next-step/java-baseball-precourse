package baseball;

/**
 * Name : BaseBallGame <br/>
 * Description : 야구 게임 객체
 */
public class BaseBallGame {
    public static final int DEFAULT_LENGTH = 3;
    private int maxLength;

    private BaseBallGame() {
        this(DEFAULT_LENGTH);
    }

    public BaseBallGame(int maxLength) {
        this.maxLength = maxLength;
    }
}
