package baseball.domain;

import baseball.domain.computer.Computer;
import baseball.domain.exceptions.DuplicatedInputNumberException;
import baseball.domain.exceptions.InvalidInputNumberException;
import baseball.domain.judge.Judge;
import baseball.domain.user.User;
import baseball.domain.utils.Messages;

import java.util.Arrays;

public class BaseballGame {
    static final String[] NEW_GAME_ANSWERS = new String[]{"1", "2"};
    private Computer computer;
    private User user;
    private Judge judge;

    protected void setInit() {
        this.computer = new Computer();
        this.user = new User();
        this.judge = new Judge(computer.generator());
    }

    public void play() {
        setInit();
        while (true) {
            if (keepGoing()) {
                System.out.println(Messages.COMPLETE.getMessage());
                break;
            }
        }
    }

    private boolean keepGoing() {
        try {
            String input = user.readUserInput(Messages.INPUT);
            Integer[] userIntegerArray = user.inputTo3differentNumbersArray(input);
            judge.init(userIntegerArray);
            String r = judge.hasDetermine();
            System.out.println(r);
            return judge.getIsOut();
        } catch (DuplicatedInputNumberException | InvalidInputNumberException e) {
            System.out.println(e.getMessage());
            return keepGoing();
        }
    }

    public boolean isNewGame() {
        String decisionForReplay;
        while (true) {
            decisionForReplay = user.readUserInput(Messages.END);
            if (validAskNewGameInput(decisionForReplay)) break;
            System.out.println(Messages.END_ERROR.getMessage());
        }
        return "1".equals(decisionForReplay);
    }


    private boolean validAskNewGameInput(String input) {

        if (input.length() > 1) return false;

        return Arrays.asList(NEW_GAME_ANSWERS).contains(input);
    }


}
