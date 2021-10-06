package baseball.interfaces.controllers;

import baseball.domain.GameService;
import baseball.interfaces.dto.BallCountDTO;
import baseball.interfaces.utils.Validation;
import nextstep.utils.Console;

import java.security.InvalidParameterException;

public class GameController {
    private GameService gameService;
    private boolean isGameEnded = false;

    public void playBall() {
        System.out.println("야구 게임에 오신것을 환영 합니다.");

        this.gameService = new GameService();

        gameService.playBall();

        System.out.println("야구 게임 시작 합니다.");

        while (!isGameEnded) {
            this.playGame();

        }
    }

    private void playGame() {
        String input = Console.readLine();
        try {
            Validation.validAnswerInput(input);
        } catch (InvalidParameterException err) {
            System.out.println(err.getMessage());
            return;
        }
        BallCountDTO ballCountDTO = gameService.submit(this.splitThreeDigitsNumber(Integer.parseInt(input)));

        checkBallCount(ballCountDTO);
    }

    private void checkBallCount(BallCountDTO ballCountDTO) {

        System.out.println(ballCountDTO.toString());

        if (ballCountDTO.isStrikeOut) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            checkContinueToPlay();
        }
    }

    private void checkContinueToPlay() {
        String choice = Console.readLine();
        try {
            Validation.validEndGameInput(choice);
        } catch (InvalidParameterException err) {
            System.out.println(err.getMessage());
            this.checkContinueToPlay();
            return;
        }

        if (choice.equals("1")) {
            this.gameService.playBall();
            return;
        }

        this.isGameEnded = true;


    }

    private int[] splitThreeDigitsNumber(int number) {
        int[] result = new int[3];

        result[0] = number / 100;
        result[1] = number / 10 % 10;
        result[2] = number % 10;

        return result;
    }
}
