package baseball.game;

import baseball.game.computer.ComputerConfigurations;
import baseball.game.computer.ComputerNumber;
import nextstep.utils.Randoms;

public class GameApplication {
    public static void main(String[] args) {
        ComputerConfigurations test = new ComputerConfigurations();
        System.out.println(test.getValidatedRandomNumber());
    }
}



