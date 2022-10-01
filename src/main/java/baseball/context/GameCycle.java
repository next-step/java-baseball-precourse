package baseball.context;

public interface GameCycle {
    void onPlay();
    void onEnd();
    void onRefresh();
}
