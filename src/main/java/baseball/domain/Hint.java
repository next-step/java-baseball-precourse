package baseball.domain;

import static baseball.type.GameMessageType.BALL;
import static baseball.type.GameMessageType.NOTHING;
import static baseball.type.GameMessageType.STRIKE;

import baseball.domain.number.ComputerNumber;
import baseball.domain.number.Number;
import baseball.domain.number.PlayerNumber;
import java.util.List;

public class Hint {

    private int ball;
    private int strike;

    public Hint(final int ball, final int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public Hint(PlayerNumber playerNumber, ComputerNumber computerNumber) {
        isSameNumber(playerNumber, computerNumber);
        isSamePosition(playerNumber, computerNumber);
    }

    public boolean isExistBall() {
        return this.ball > 0;
    }

    public boolean isExistStrike() {
        return this.strike > 0;
    }

    public boolean isThreeStrike() {
        return this.strike == 3;
    }

    private void isSameNumber(PlayerNumber playerNumber, ComputerNumber computerNumber) {
        for (Number number : playerNumber.getPlayerNumbers()) {
            countSameNumber(computerNumber.toList(), number);
        }
    }

    private void isSamePosition(PlayerNumber playerNumber, ComputerNumber computerNumber) {
        List<Integer> playerNumbers = playerNumber.toList();
        List<Integer> computerNumbers = computerNumber.toList();
        for (int i = 0; i < playerNumbers.size(); i++) {
            countSamePosition(playerNumbers, computerNumbers, i);
        }
    }

    private void countSameNumber(List<Integer> computerNumber, Number number) {
        if (computerNumber.contains(number.getNumber())) {
            this.ball++;
        }
    }

    private void countSamePosition(
        List<Integer> playerNumbers,
        List<Integer> computerNumbers,
        int index
    ) {
        if (playerNumbers.get(index).equals(computerNumbers.get(index))) {
            this.strike++;
            this.ball--;
        }
    }

    private String getString(boolean isExist, String result, String hintToString) {
        if (isExist) {
            result += hintToString;
        }
        return result;
    }

    @Override
    public String toString() {
        String result = "";
        result = getString(isExistBall(), result, this.ball + BALL.getMessage());
        result = getString(isExistBall() && isExistStrike(), result, " ");
        result = getString(isExistStrike(), result, this.strike + STRIKE.getMessage());
        result = getString(!isExistBall() && !isExistStrike(), result, NOTHING.getMessage());
        return result;
    }
}
