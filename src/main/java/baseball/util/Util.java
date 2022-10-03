package baseball.util;

import static baseball.Application.DIGIT_FOR_GAME;
import static baseball.constant.BaseballNumberEnum.NUMBER_END;
import static baseball.constant.BaseballNumberEnum.NUMBER_START;

import baseball.constant.BaseballNumberEnum;
import baseball.game.Baseball;
import baseball.model.player.ComputerPlayer;
import baseball.model.player.HumanPlayer;
import baseball.model.umpire.Umpire;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class Util {

    public String makeRandomNumberInString() {
        StringBuilder result = new StringBuilder();
        for (Integer number : getRandomNumbers(DIGIT_FOR_GAME)) {
            result.append(number);
        }
        return result.toString();
    }

    public static String getSubstring(String inputNumber) {
        return inputNumber.substring(BaseballNumberEnum.INDEX_ONE.intValue);
    }

    public static String getFirstLetter(String inputNumber) {
        return String.valueOf(inputNumber.charAt(BaseballNumberEnum.INDEX_ZERO.intValue));
    }


    private Set<Integer> getRandomNumbers(int numberOfDigits) {
        Set<Integer> randomNumbers = new HashSet<>();
        while (randomNumbers.size() < numberOfDigits) {
            randomNumbers.add(Randoms.pickNumberInRange(NUMBER_START.intValue, NUMBER_END.intValue));
        }
        return randomNumbers;
    }

    /**
     * @return Baseball with computer player which includes random number
     */
    public Baseball getBaseballWithRandomNumber() {
        final ComputerPlayer computer = new ComputerPlayer();
        final HumanPlayer user = new HumanPlayer();
        final Umpire umpire = new Umpire();
        return new Baseball(computer, user, umpire);
    }

}
