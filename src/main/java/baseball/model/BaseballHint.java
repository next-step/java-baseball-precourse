package baseball.model;

public class BaseballHint {
    public static final String strike = "스트라이크";
    public static final String ball = "볼";
    public static final String nothing = "낫싱";
    private int strikes = 0;
    private int balls = 0;

    public BaseballHint(int strikes, int balls){
        this.strikes = strikes;
        this.balls = balls;
    }

    public void showHint(){
        System.out.println(strike + this.strikes +  " " + ball + this.balls);
    }

}
