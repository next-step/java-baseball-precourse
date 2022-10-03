package baseball.model;

import java.util.HashMap;
import java.util.Map;

public class GameResult {
    private Map<String, Integer> gameResult;

    public GameResult() {
        gameResult = new HashMap<>();
        gameResult.put("스트라이크", 0);
        gameResult.put("볼", 0);
        gameResult.put("낫싱", 0);
    }

    public void updateResult(String match) {
        int matchNum = gameResult.get(match);

        gameResult.put(match, matchNum + 1);
    }

    public int getStrikeCnt() {
        return gameResult.get("스트라이크");
    }

    public int getBallCnt() {
        return gameResult.get("볼");
    }

    public String printStrikeResult() {
        String resultWord = "";

        if (getStrikeCnt() > 0) {
            resultWord += getStrikeCnt() + "스트라이크";
        }

        return resultWord;
    }

    public String printBallResult() {
        String resultWord = "";

        if (getBallCnt() > 0) {
            resultWord += getBallCnt() + "볼";
        }

        return resultWord;
    }

    public String printNothingResult() {
        String resultWord = "";

        if (getBallCnt() + getStrikeCnt() == 0) {
            resultWord = "낫싱";
        }

        return resultWord;
    }

    public String printGameResult() {
        String resultWord = "";

        if (getBallCnt() + getStrikeCnt() > 0) {
            resultWord += printBallResult() + " " + printStrikeResult();
            return resultWord.trim();
        }

        return printNothingResult();
    }
}
