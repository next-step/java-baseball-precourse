package baseball.context;

public interface RestartPolicy {
    void restart(boolean canRestart, Runnable restartSignal, Runnable exitSignal);
}
