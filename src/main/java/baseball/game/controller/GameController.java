package baseball.game.controller;

import baseball.game.model.Player;
import camp.nextstep.edu.missionutils.Console;


public class GameController {
    public void start() {
        Player player = new Player();
        while(player.keepPlaying) {
            player.playGame();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String keepPlaying = Console.readLine();
            if (Integer.parseInt(keepPlaying) == 2) {
                break;
            }
        }
    }
}
