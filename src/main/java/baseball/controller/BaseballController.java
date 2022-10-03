package baseball.controller;

import baseball.domain.*;
import baseball.enums.BaseballOption;
import baseball.enums.Messages;
import camp.nextstep.edu.missionutils.Console;

public class BaseballController {

    private final Player player = new Player();
    private final Computer computer = new Computer();

    public void start() {
        BaseballResult baseballResult;
        computer.pickNumbers();

        do {
            System.out.print(Messages.START.getText());
            player.setInputNumbers(Console.readLine().trim());

            BaseballSystem baseballSystem = new BaseballSystem(player, computer);
            baseballResult = baseballSystem.play();

            System.out.println(baseballResult.convert(baseballResult));
        } while (baseballResult.getStrikeCount() != 3);

        gameOver();
    }


    private void gameOver() {
        System.out.println(Messages.END.getText());
        System.out.println(Messages.OPTION.getText());

        String input = Console.readLine().trim();

        if (input.equals(BaseballOption.RESTART.getNumber()+"")) {
            start();
        }
    }
}