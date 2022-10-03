package baseball.game.domain;

public class Game {
    private GameStatus status;

    public Game() {
        this.status = GameStatus.STOP;
    }

    public void start() {
        this.status = GameStatus.PLAYING;
    }

    public boolean isPlaying() {
        return this.status.equals(GameStatus.PLAYING);
    }

    public boolean isEnd() {
        return this.status == GameStatus.STOP;
    }

    public void end() {
        this.status = GameStatus.STOP;
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public GameStatus getStatus() {
        return this.status;
    }
}
