package baseball;

import java.util.List;

public class Game {

    private GenerateNumber generateNumber;
    private PlayerInput playerInput;
    private Judge judge;

    public Game() {
        this.generateNumber = new GenerateNumber();
        this.playerInput = new PlayerInput();
        this.judge = new Judge();
    }

    public void game() {
        do{
            guess(generateNumber.generate());
        }while(playerInput.doAgain());

        return;
    }

    public void guess(List<Integer> computerNumbers) {
        int strike;
        int ball;
        do{
            List<Integer> playerNumbers = playerInput.getPlayerNumber();
            ball = judge.countBall(computerNumbers, playerNumbers);
            strike = judge.countStrike(computerNumbers, playerNumbers);
            System.out.println(displayPoints(ball, strike));
        }while(strike != 3);
    }

    private String displayPoints(int ball, int strike) {
        if(ball + strike == 0) {
            return "낫싱";
        }

        String pointMessage = "";
        if(ball > 0) pointMessage += ball + "볼 ";
        if(strike > 0) pointMessage += strike + "스트라이크";
        if(strike == 3) pointMessage += "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";

        return pointMessage;
    }


}
