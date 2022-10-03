package baseball.app;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.Rule;
import baseball.utils.io.IOUtils;

public class Referee {

    private final Rule rule;
    private final Computer computer;
    private final Player player;

    public Referee(Rule rule, Computer computer, Player player){
        this.rule = rule;
        this.computer = computer;
        this.player = player;
    }

    public void gameStart(){
        computer.init();
        do {
            gameProcess();
            rule.printResult();
        } while( rule.getStrike() < 3);
    }

    private void gameProcess(){
        player.inputNumbers(IOUtils.readStringByConsole("숫자를 입력하세요 : "));
        rule.checkStrikeCount(computer.getNumbers(), player.getNumbers());
    }

    public boolean isRestart() {
        String input = IOUtils.readStringByConsole("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. : ");
        return "1".equals(input);
    }
}
