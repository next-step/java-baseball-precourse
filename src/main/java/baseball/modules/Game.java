package baseball.modules;

import baseball.entity.ComputerMachine;
import baseball.entity.Judgement;
import baseball.entity.Player;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Game {
    private ComputerMachine computerMachine;
    private Player player;
    private List<Integer> computerNumbers;
    private String playerNumbers;
    private int endOfGame = 0;

    public void playTheGame() {
        computerMachine = new ComputerMachine();
        computerNumbers = computerMachine.makeThreeNumbers();
        player = new Player();
        //게임 종료 조건
        while (endOfGame != 2) {
            playerNumbers = player.inputThreeNumbers();
            int result = startGame(computerNumbers, playerNumbers);
            endOfGame = resultAndContinueOrNot(result);
        }
    }

    private int startGame(List<Integer> computerNumbers, String playerNumbers) {
        String str;
        Judgement judgement = new Judgement();
        str = judgement.matchNumbers(computerNumbers, playerNumbers);
        System.out.println(str);
        if ("3스트라이크".equals(str)) {
            return 1;
        }
        return 0;
    }

    private int resultAndContinueOrNot(int result) {
        if (result == 1) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            computerNumbers = computerMachine.makeThreeNumbers();
            return Integer.valueOf(Console.readLine());
        }
        return 0;
    }

}
