package baseball;

public enum GameType {

    볼(0),

    스트라이크(1),

    낫싱(2);

    public final int index;

    GameType(int index) {
        this.index = index;
    }

}
