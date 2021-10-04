package baseball.model.enums;

public enum PlayerStatus {
    READY, PLAYING, END;

    public boolean isReady() {
        return this == READY;
    }

    public boolean isPlaying() {
        return this == PLAYING;
    }
}
