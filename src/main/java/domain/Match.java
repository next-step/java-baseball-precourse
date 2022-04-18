package domain;

import config.Policy;

public class Match {
    private int round;
    private String[] gameNumber;
    private boolean victory;

    public int getRound() {
        return round;
    }

    private void setRound(int round) {
        this.round = round;
    }

    public String[] getGameNumber() {
        return gameNumber;
    }

    private void setGameNumber(String[] gameNumber) {
        this.gameNumber = gameNumber;
    }

    public boolean isVictory() {
        return victory;
    }

    private void setVictory(boolean victory) {
        this.victory = victory;
    }

    public static Match init(String[] generatedGameNumber){
        Match match = new Match();
        match.setRound(Policy.MATCH_ROUND_START);
        match.setGameNumber(generatedGameNumber);
        match.setVictory(false);

        return match;
    }

    public void endOfRound(RoundResult roundResult){
        this.round++;
        if(roundResult.getStrikeCount()==Policy.IN_GAME_NUMBER_LENGTH){
            this.victory = true;
        }
    }
}
