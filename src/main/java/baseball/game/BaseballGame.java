package baseball.game;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.model.Result;
import baseball.model.User;
import baseball.io.Input;
import baseball.io.Output;

public class BaseballGame {

    private final BaseballCompare baseballCompare = new BaseballCompare();
    private Computer computer;
    private User user;
    private boolean playing;

    public void play() {
        this.playing = true;
        this.start();

        while (this.playing) {
            this.userInput();
            this.playing = this.compare(this.user, this.computer);
        }
    }

    private void start() {
        this.computer = Computer.create();
    }

    private void userInput() {
        Output.print("숫자를 입력해주세요 : ");
        this.user = User.of(Input.readLine());
    }

    private boolean compare(final Player inputPlayer, final Player resultPlayer) {
        Result result = this.baseballCompare.compare(inputPlayer.getBaseballNumbers().getNumbers(),
                resultPlayer.getBaseballNumbers().getNumbers());

        Output.println(result.getResult());
        return !result.isFinish();
    }
}
