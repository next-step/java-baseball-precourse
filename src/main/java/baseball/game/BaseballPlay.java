package baseball.game;

import baseball.ball.ComputerBaseball;
import baseball.ball.UserBaseball;
import baseball.score.BaseBallScore;
import baseball.score.Score;
import baseball.ball.Baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseballPlay implements Play {
    private final Baseball computer;
    private final Baseball person;
    private final BaseBallScore score;
    public static final String RUN = "1";
    public static final String END = "2";

    boolean RUNNING = true;

    public static BaseballPlay getInstance(){
        return new BaseballPlay(
                new ComputerBaseball(),
                new UserBaseball(),
                new BaseBallScore()
        );
    }

    private BaseballPlay(Baseball computer, Baseball person, BaseBallScore score) {
        this.computer = computer;
        this.person = person;
        this.score = score;
    }

    @Override
    public void run() {
        while (RUNNING) {
            start();
            Score score = getScore();
            createResult(score);
        }
        this.stop();
    }

    private void createResult(Score score) {
        System.out.println(score.toString());
        checkGameState();
    }

    void checkGameState() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = readLine();
        if (RUN.startsWith(userInput)){
            RUNNING = false;
        }
    }

    void start() {
        System.out.println("숫자를 입력해 주세요 : ");
        person.createBall();
        person.checkValidation();
        computer.checkValidation();
    }

    Score getScore() {
        Score score = new BaseBallScore();
        score.create(person.getBall(),computer.getBall());
        return score;
    }

    @Override
    public void stop() {
        System.out.println("게임 종료");
    }
}
