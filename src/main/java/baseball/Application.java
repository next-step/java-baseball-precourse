package baseball;

import baseball.game.Game;
import baseball.game.Score;
import baseball.member.Computer;
import baseball.member.User;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
