package baseball;

import baseball.game.Game;

import java.util.Objects;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        String line = "1";
        while (!Objects.equals(line, "2")) {
            Game game = new Game();
            game.play();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            line = readLine();
        }
    }
}
