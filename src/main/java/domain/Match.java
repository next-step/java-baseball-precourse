package domain;

import policy.Policy;

public class Match {
    private int round;
    private String[] gameNumber;

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public String[] getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(String[] gameNumber) {
        this.gameNumber = gameNumber;
    }

    public static Match init(String[] generatedGameNumber){
        Match match = new Match();
        match.setRound(Policy.MATCH_ROUND_START);
        match.setGameNumber(generatedGameNumber);

        return match;
    }

    public void endOfRound(){
        this.round++;
    }
}
