package baseball;

public class Score {

    private int BallScore;
    private int StrikeScore;

    public Score(int ballScore, int strikeScore) {
        BallScore = ballScore;
        StrikeScore = strikeScore;
    }

    public int getBallScore() {
        return BallScore;
    }

    public void setBallScore(int ballScore) {
        BallScore = ballScore;
    }

    public int getStrikeScore() {
        return StrikeScore;
    }

    public void setStrikeScore(int strikeScore) {
        StrikeScore = strikeScore;
    }

    public void init(int i) {
        this.setBallScore(i);
        this.setStrikeScore(i);
    }

    public void countStrike(Baseball counterBaseball, Baseball userBaseball) {

        if(counterBaseball.getFirst() == userBaseball.getFirst())
            this.setStrikeScore(this.getStrikeScore()+1);

        if(counterBaseball.getSecond() == userBaseball.getSecond())
            this.setStrikeScore(this.getStrikeScore()+1);

        if(counterBaseball.getThird() == userBaseball.getThird())
            this.setStrikeScore(this.getStrikeScore()+1);


    }

    public void countBall(Baseball counterBaseball, Baseball userBaseball) {

        if(counterBaseball.getFirst() == userBaseball.getSecond()
                ||counterBaseball.getFirst()==userBaseball.getThird() )
            this.setBallScore(this.getBallScore()+1);
        if(counterBaseball.getSecond() == userBaseball.getFirst()
                ||counterBaseball.getSecond()==userBaseball.getThird() )
            this.setBallScore(this.getBallScore()+1);
        if(counterBaseball.getThird() == userBaseball.getFirst()
                ||counterBaseball.getThird()==userBaseball.getSecond() )
            this.setBallScore(this.getBallScore()+1);
    }
}
