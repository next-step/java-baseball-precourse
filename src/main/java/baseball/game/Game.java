package baseball.game;

import baseball.io.Input;
import baseball.io.Output;

public class Game {

    private final String CONTINUE = "1";
    private final String END = "2";
    private final BaseballGame baseballGame = new BaseballGame();
    private boolean playing;

    public void play() {
        this.playing = true;

        while (this.playing) {
            this.baseballGame.play();
            this.playing = this.playable();
        }

        Output.println("게임 종료");
    }

    private boolean playable() {
        String input = userInput();

        if (CONTINUE.equals(input)) {
            return true;
        }
        if (END.equals(input)) {
            return false;
        }

        throw new IllegalArgumentException("잘못된 값을 입력 하였습니다.");
    }

    private String userInput() {
        Output.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Input.readLine();

        return input;
    }
}
