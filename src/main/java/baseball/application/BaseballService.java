package baseball.application;

import baseball.domain.Baseballs;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseballService {
    private Baseballs userBaseballs;
    private Baseballs computerBaseballs;

    public void playBaseball() {
        computerBaseballs = Baseballs.createRandomBaseballs();

        do {
            playBaseballOnce();
        } while(!isCorrectAnswer());
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료.");
    }

    private void playBaseballOnce() {
        userBaseballs = receiveUserBaseballs();
        BaseballResult baseballResult = new BaseballResult(computerBaseballs, userBaseballs);
        System.out.println(baseballResult.getResult());
    }

    private Baseballs receiveUserBaseballs() {
        return Baseballs.createBaseballs(readLine());
    }

    private boolean isCorrectAnswer() {
        return userBaseballs.equals(computerBaseballs);
    }
}
