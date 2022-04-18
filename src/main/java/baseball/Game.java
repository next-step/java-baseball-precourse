package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Game {
    Player player;
    int strike;
    int ball;

    public void start(Player player, Computer computer) {
        this.player = player;
        computer.randomNum();
        checkNum(computer.randomNums);
    }

    public void checkNum(List<Integer> randomNums) {
        while (true) {
            strike = ball = 0;
            player.playerNums(Console.readLine());
            for (int i = 0; i < player.playerNums.size(); i++) {
                for (int j = 0; j < randomNums.size(); j++) {
                    if (player.playerNums.get(i).equals(randomNums.get(j))) {
                        if (i == j) {
                            strike++;
                        }
                        if (i != j) {
                            ball++;
                        }
                    }
                }
            }
            System.out.println(resultMessage(strike, ball));
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                if ("1".equals(Console.readLine())) {
                    start(new Player(), new Computer());
                }
                break;
            }
        }
    }

    public String resultMessage(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }
        if (strike == 3 && ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }
}
