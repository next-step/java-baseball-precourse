package baseball.view;

import static baseball.utils.Constants.BALL;
import static baseball.utils.Constants.CONTINUE_GAME_OR_NOT;
import static baseball.utils.Constants.INPUT_MAX;
import static baseball.utils.Constants.INPUT_MIN;
import static baseball.utils.Constants.MAX_NUMBERS;
import static baseball.utils.Constants.NOTHING;
import static baseball.utils.Constants.STOP_FLAG;
import static baseball.utils.Constants.STRIKE;
import static baseball.utils.Constants.THREE_STRIKE_GAME_END;
import static baseball.utils.Constants.TYPE_NUMBER_PLEASE;
import static baseball.utils.InputValidator.*;

import camp.nextstep.edu.missionutils.Console;

public class MatchView {
    public String startRound() {
        System.out.print(TYPE_NUMBER_PLEASE);

        String inputNumber = Console.readLine();
        isNumber(inputNumber);
        isDuplicate(inputNumber);
        isLength(inputNumber, MAX_NUMBERS);
        isMinMax(inputNumber, INPUT_MIN, INPUT_MAX);

        return inputNumber;
    }

    public void showGameResult(Integer strikeCount, Integer ballCount) {
        if(strikeCount.equals(0) && ballCount.equals(0)) {
            System.out.println(NOTHING);
            return;
        }

        String resultMsg = calcGameResult(strikeCount, ballCount);
        System.out.println(resultMsg);
    }

    public String calcGameResult(Integer strikeCount, Integer ballCount) {
        if(strikeCount.equals(MAX_NUMBERS)) {
            return THREE_STRIKE_GAME_END;
        }

        String strikeMessage = strikeCount.equals(0) ? "" : String.format("%d"+STRIKE, strikeCount);
        String ballMessage = ballCount.equals(0) ? "" : String.format(" %d"+BALL, ballCount);
        return strikeMessage.concat(ballMessage).trim();
    }

    public String getContinueInput() {
        System.out.print(CONTINUE_GAME_OR_NOT);
        String inputNumber = Console.readLine();

        isNumber(inputNumber);
        isDuplicate(inputNumber);
        isMinMax(inputNumber, INPUT_MIN, STOP_FLAG);

        return inputNumber;
    }
}
