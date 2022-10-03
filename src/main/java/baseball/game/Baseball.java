package baseball.game;

import static baseball.constant.BaseballNumberEnum.INDEX_FOR_BALL;
import static baseball.constant.BaseballNumberEnum.INDEX_FOR_STRIKE;
import static baseball.constant.BaseballStringEnum.BALL_IN_KOREAN;
import static baseball.constant.BaseballStringEnum.NOTHING;
import static baseball.constant.BaseballStringEnum.STRIKE_IN_KOREAN;
import static baseball.constant.BaseballStringEnum.THREE_STRIKE;
import static baseball.constant.BaseballStringEnum.USER_INPUT_REQUEST_STATEMENT;
import static baseball.constant.BaseballStringEnum.ZERO_BALL;
import static baseball.constant.BaseballStringEnum.ZERO_STRIKE;

import baseball.model.player.ComputerPlayer;
import baseball.model.player.HumanPlayer;
import baseball.model.umpire.Umpire;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Baseball {
    private final ComputerPlayer computer;
    private final HumanPlayer user;
    private final Umpire umpire;


    public Baseball(ComputerPlayer computer, HumanPlayer user, Umpire umpire) {
        this.computer = computer;
        this.user = user;
        this.umpire = umpire;
    }

    public void runGame(boolean isThreeStrike) {

        if (isThreeStrike) {
            return;
        }

        System.out.print(USER_INPUT_REQUEST_STATEMENT.label);
        user.setInputNumber(Console.readLine());
        List<String> result = umpire.judge(computer.getInputNumber(), user.getInputNumber());
        System.out.println(returnStringifiedJudgeStatement(result.get(INDEX_FOR_BALL.intValue),
                result.get(INDEX_FOR_STRIKE.intValue)));
        runGame(checkIfGameIsDone(result));
    }

    protected String returnStringifiedJudgeStatement(String ballPart, String strikePart) {
        if (isaNothing(ballPart, strikePart)) {
            return NOTHING.label;
        }
        if (isaZeroBall(ballPart)) {
            return String.format("%s%s", strikePart, STRIKE_IN_KOREAN.label);
        }
        if (isaZeroStrike(strikePart)) {
            return String.format("%s%s", ballPart, BALL_IN_KOREAN.label);
        }
        return String.format("%s%s %s%s", ballPart, BALL_IN_KOREAN.label, strikePart, STRIKE_IN_KOREAN.label);
    }

    protected boolean isaZeroStrike(String STRIKE_PART) {
        return STRIKE_PART.equals(ZERO_STRIKE.label);
    }

    protected boolean isaZeroBall(String BALL_PART) {
        return BALL_PART.equals(ZERO_BALL.label);
    }

    protected boolean isaNothing(String BALL_PART, String STRIKE_PART) {
        return isaZeroBall(BALL_PART) && isaZeroStrike(STRIKE_PART);
    }


    protected boolean checkIfGameIsDone(List<String> judge) {
        return judge.get(INDEX_FOR_STRIKE.intValue).equals(THREE_STRIKE.label);
    }
}

