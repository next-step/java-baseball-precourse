package baseball;

import baseball.domain.Count;
import baseball.domain.Facilitator;
import baseball.domain.Referee;
import baseball.view.Command;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        Command command = new Command();
        Facilitator facilitator = new Facilitator();
        Referee referee = new Referee();

        boolean gameContinue = true;
        while (gameContinue){
            List<Integer> comNumbers = facilitator.numbersGenerator();
            boolean isStruckOut = false;
            while(!isStruckOut) {
                try {
                    List<Integer> playerNumbers = facilitator.splitNumbers(command.askPlayerNumbers());
                    Count count = referee.atBat(comNumbers, playerNumbers);
                    referee.callCount(command, count.getStrike(), count.getBall());
                    isStruckOut = referee.isStruckOut(count.getStrike());
                    if(isStruckOut) {
                        command.printGameClear();
                    }
                } catch (IllegalArgumentException e) {
                    command.printError();
                }
            }
            gameContinue = facilitator.isContinueGame(command.askContinueGame());
        }
    }
}
