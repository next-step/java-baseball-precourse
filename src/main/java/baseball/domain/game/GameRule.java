package baseball.domain.game;

public class GameRule {
    public int MIN_NUM = 1;
    public int MAX_NUM = 9;
    public int SIZE = 3;

    public GameRule() {
    }

    public GameRule(int minNum, int maxNum, int size) {
        this.MIN_NUM = minNum;
        this.MAX_NUM = maxNum;
        this.SIZE = size;
    }
}
