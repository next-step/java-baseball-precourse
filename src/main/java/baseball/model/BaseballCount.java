package baseball.model;

public class BaseballCount {
    public static final String strike = "스트라이크";
    public static final String ball = "볼";
    public static final String nothing = "낫싱";
    private int strikes;
    private int balls;

    BaseballCount(int strikes, int balls){
        this.strikes = strikes;
        this.balls = balls;
    }

    public int getStrikes(){
        return this.strikes;
    }
    public int getBalls(){
        return this.balls;
    }

    public boolean isEnd(){
        if (this.strikes==3){
            return true;
        }
        return false;
    }

    public void setStrikes(int strikeNumbers){
        this.strikes = strikeNumbers;
    }

    public void setBalls(int ballNumbers){
        this.balls = ballNumbers;
    }

    public BaseballCount calculateCount(int computerNumber, int playerNumber){
        String stringComputerNumber = Integer.toString(computerNumber);
        String stringPlayerNumber = Integer.toString(playerNumber);

        int strikes = 0;
        int balls = 0;
        for (int i=0; i<3; i++){
            int addStrike = addStrikeCount(stringComputerNumber.charAt(i), stringPlayerNumber.charAt(i));
            strikes += addStrike;
            balls += addBallCount(addStrike, stringComputerNumber, stringPlayerNumber.charAt(i));
        }
        return new BaseballCount(strikes, balls);
    }

    private int addStrikeCount(char computerNumber, char playerNumber){
        if (computerNumber == playerNumber){
            return 1;
        }
        return 0;
    }

    private int addBallCount(int addStrike, String computerNumber , char playerNumber){
        if (addStrike!=1 && computerNumber.indexOf(playerNumber)!=-1){
            return 1;
        }
        return 0;
    }
}
