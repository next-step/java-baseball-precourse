package baseball.domain;

public enum GameMachineStatus {

    RUNNING,
    FINISH;

    public boolean isFinish() {
        return this == FINISH;
    }
}
