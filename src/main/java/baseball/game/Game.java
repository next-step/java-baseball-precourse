package baseball.game;

import baseball.member.Computer;
import baseball.member.User;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    private static final int ALL_STRIKE = 3;
    private static final String STOP_CODE = "2";

    private static final Computer computer = new Computer();
    private static final User user = new User();
    private static final Score score = new Score();

    public void start() {
        computer.choiceNumbers();
        score.clearScore();
        round();
    }

    private void round() {
        while(score.getStrike() < ALL_STRIKE) {
            user.inputNumbers();
            score.judgeScore(computer, user);
            score.printScore();
        }
        if(!stopProcess()) {
            start();
        }
    }

    private boolean stopProcess() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if(input.equals(STOP_CODE)) {
            stop();
            return true;
        }
        return false;
    }

    public void stop() {
        System.out.println("게임 종료");
    }
}
