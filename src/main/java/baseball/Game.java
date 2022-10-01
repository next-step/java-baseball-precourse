package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Game {
    Baseball CounterBaseball;
    Baseball UserBaseball;
    Score score ;

    public void init(){
        CounterBaseball = new Baseball();
        UserBaseball = new Baseball();
        score = new Score(0,0);
    }
    public void generateCounterBaseballs()
    {
        int FirstBall, SecondBall, ThirdBall;
        FirstBall = pickNumberInRange(1, 9);
        SecondBall = pickNumberInRange(1, 9);
        while (FirstBall == SecondBall)
            SecondBall = pickNumberInRange(1, 9);
        ThirdBall = pickNumberInRange(1, 9);
        while (FirstBall == ThirdBall || SecondBall == ThirdBall)
            ThirdBall = pickNumberInRange(1, 9);
        CounterBaseball.setBallAfterToChar(FirstBall,SecondBall,ThirdBall);
    }



    public void countScore( ) {
        score.countStrike(CounterBaseball, UserBaseball);
        score.countBall(CounterBaseball, UserBaseball);
    }

    public void evaluateScore() {
        System.out.println(scoreIsNothing() + scoreIsBall() + scoreIsStrike() );
    }

    private String scoreIsStrike() {
        if (score.getStrikeScore() > 0) {
            return spaceIfBallExist() + Integer.toString(score.getStrikeScore()) + "스트라이크";
        }
        return "";
    }

    private String spaceIfBallExist() {
        if (score.getBallScore() > 0)
            return " ";
        return "";
    }

    private String scoreIsBall() {
        if (score.getBallScore() > 0) {
            return Integer.toString(score.getBallScore()) + "볼";
        }
        return "";
    }

    public String scoreIsNothing(){
        if (score.getStrikeScore() == 0 && score.getBallScore() == 0) {
            return "낫싱";
        }
        return "";
    }
    public void guessCounterBaseballs() {
        while(this.score.getStrikeScore()!=3) {
            this.score.init(0);
            this.insertUserBaseballs();
            this.countScore();
            this.evaluateScore();
        }
    }

    private void insertUserBaseballs() {
        String RL = new String();
        System.out.print("숫자를 입력해주세요 : ");
        RL = readLine();
        if(RL.length() != 3  ){
            throw new IllegalArgumentException();
        }
        UserBaseball.setBall(RL.charAt(0),RL.charAt(1),RL.charAt(2));
    }

    public boolean isRestartGame() {
        if(score.getStrikeScore()==3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로시작하려면 1, 종료하려면 2를 입력하세요.");
            return checkRestartFlag();
        }
        return true;
    }

    private boolean checkRestartFlag() {
        String RestartFlag = readLine();
        if (RestartFlag.equals("2"))
            return false;
        if (RestartFlag.equals("1"))
            return true;
        throw new IllegalArgumentException();
    }
}
