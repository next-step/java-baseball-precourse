package baseball.context;

public class ResultMessage {
    private String ball;
    private String strike;
    private String nothing;

    public ResultMessage(Result result) {
        toBallMessage(result);
        toStrikeMessage(result);
        toNothingMessage(result);
    }

    private void toBallMessage(Result result) {
        if (result.hasBall()) {
            this.ball = result.toBallString();
        }
    }

    private void toStrikeMessage(Result result) {
        if (result.hasStrike()) {
            this.strike = result.toStrikeString();
        }
    }

    private void toNothingMessage(Result result) {
        if (result.nothing()) {
            this.nothing = result.toNothingString();
        }
    }

    @Override
    public String toString() {
        if (ball != null && strike != null) {
            return ball + " " + strike;
        }
        if (ball != null) {
            return ball;
        }
        if (strike != null) {
            return strike;
        }
        return nothing;
    }
}
